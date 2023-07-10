package com.uade.screenspace.service;

import com.uade.screenspace.auth.LoggedUserGetter;
import com.uade.screenspace.entity.Code;
import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.exceptions.DuplicatedEntity;
import com.uade.screenspace.exceptions.EntityNotFound;
import com.uade.screenspace.exceptions.ValidationError;
import com.uade.screenspace.repository.PendingUserRepository;
import com.uade.screenspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PendingUserRepository pendingUserRepository;
    @Autowired
    private IEmailSender emailSender;
    @Autowired
    private LoggedUserGetter userGetter;

    public PendingUser createPendingUser(String email, String password, boolean isOwner){
        String generatedCode;
        var existentPending = pendingUserRepository.findAll();
        Set<String> existentCodes = existentPending.stream().map(p -> p.getCode().getCode()).collect(Collectors.toSet());

        if (existentPending.stream().anyMatch(p -> p.getPendingUser().getEmail().equals(email)) || userRepository.findByEmail(email).isPresent())
            throw new DuplicatedEntity(String.format("User with email %s already exists", email));

        do {
            generatedCode = getCode();
        } while (existentCodes.contains(generatedCode));
        var pendingUser = pendingUserRepository.save(new PendingUser(new User(email, password, isOwner, null), new Code(generatedCode, Instant.now().plus(10, ChronoUnit.MINUTES))));

        try{
            emailSender.sendRegistrationCode(email, generatedCode);
        } catch (Exception e){
            throw new ValidationError("Error while sending email, please try again");
        }

        return pendingUserRepository.save(pendingUser);
    }

    @Override
    public User confirmUserCreation(String email, String code) {
        List<PendingUser> foundRequests = pendingUserRepository.findAll().stream().filter(p -> p.getCode().getCode().equals(code) && p.getPendingUser().getEmail().equals(email)).collect(Collectors.toList());
        if(foundRequests.isEmpty())
            throw new EntityNotFound(String.format("No pending registration for user %s and code %s", email, code));

        User createdUser = userRepository.save(foundRequests.get(0).getPendingUser());
        pendingUserRepository.delete(foundRequests.get(0));

        return createdUser;
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User findUser(String email, String password, boolean isOwner) {
        return userRepository.findByEmailAndPasswordAndIsOwner(email, password, isOwner);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User updateUser(String email, boolean isOwner, String profilePic, String name) {
        var user = userRepository.findByEmailAndIsOwner(email, userGetter.get().getOwner()).get();
        user.setEmail(email);
        user.setProfilePicBase64(profilePic);
        user.setName(name);
        return userRepository.save(user);
    }

    @Override
    public void passwordReset(String email) {
        String generatedCode;
        var requestedUser = userRepository.findByEmail(email);
        if (requestedUser.isEmpty()){
            throw new EntityNotFound(String.format("Email %s does not exists", email));
        }
        Set<String> existentCodes = requestedUser.get().getCodes()
                .stream()
                .map(Code::getCode)
                .collect(Collectors.toSet());
        do {
            generatedCode = getCode();
        } while (existentCodes.contains(generatedCode));
        requestedUser.get().addPasswordResetCode(new Code(generatedCode, Instant.now().plus(10, ChronoUnit.MINUTES)));

        try{
            emailSender.sendPasswordResetCode(email, generatedCode);
        } catch (Exception e){
            throw new ValidationError("Error while sending email, please try again");
        }

        userRepository.save(requestedUser.get());
    }

    @Override
    public void confirmPasswordReset(String email, String code) {
        var requestedUser = userRepository.findByEmail(email);
        if (requestedUser.isEmpty()){
            throw new RuntimeException();
        }

        requestedUser.get().getCodes()
                .stream()
                .filter(c -> c.getCode().equals(code) && c.getExpirationDate().isAfter(Instant.now()))
                .findAny().orElseThrow(() -> new EntityNotFound(String.format("Code not found for email %s", email)));
    }

    @Override
    public void updatePassword(String email, String password,  String code) {
        var requestedUser = userRepository.findByEmail(email);
        if (requestedUser.isEmpty()){
            throw new RuntimeException();
        }
        requestedUser.get().setPassword(password);
        requestedUser.get().getCodes().removeIf(c -> c.getCode().equals(code));
        userRepository.save(requestedUser.get());
    }

    @Override
    public User findOrCreateOauthUser(String email) {
        var foundUser = userRepository.findByEmailAndIsOwner(email, false);
        if (foundUser.isPresent())
            return foundUser.get();
        User newOauthUser = new User();
        newOauthUser.setEmail(email);
        newOauthUser.setOwner(false);
        newOauthUser.setPassword(null);
        return userRepository.save(newOauthUser);
    }

    private String getCode() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
