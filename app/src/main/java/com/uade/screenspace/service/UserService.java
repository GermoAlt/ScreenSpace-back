package com.uade.screenspace.service;

import com.uade.screenspace.entity.Code;
import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.exceptions.EntityNotFound;
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

    public PendingUser createPendingUser(String email, String password, boolean isOwner){
        String generatedCode;
        var existentPending = pendingUserRepository.findAll();
        Set<String> existentCodes = existentPending.stream().map(p -> p.getCode().getCode()).collect(Collectors.toSet());

        do {
            generatedCode = getCode();
        } while (existentCodes.contains(generatedCode));
        var pendingUser = pendingUserRepository.save(new PendingUser(new User(email, password, isOwner, null), new Code(generatedCode, Instant.now().plus(10, ChronoUnit.MINUTES))));

        try{
            emailSender.sendRegistrationCode(email, generatedCode);
        } catch (Exception e){

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
    public User updateUser(String email, String password, boolean isOwner, String profilePic) {
        return null;
    }

    @Override
    public void passwordReset(String email) {
        String generatedCode;
        var requestedUser = userRepository.findByEmail(email);
        if (requestedUser.isEmpty()){
            throw new RuntimeException();
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

        }

    }

    @Override
    public boolean confirmPasswordReset(String email, String code) {
        var requestedUser = userRepository.findByEmail(email);
        if (requestedUser.isEmpty()){
            throw new RuntimeException();
        }

        return requestedUser.get().getCodes()
                .stream()
                .anyMatch(c -> c.getCode().equals(code) && c.getExpirationDate().isAfter(Instant.now()));
    }

    private String getCode() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
