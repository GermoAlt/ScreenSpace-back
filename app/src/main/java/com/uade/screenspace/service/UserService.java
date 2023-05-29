package com.uade.screenspace.service;

import com.uade.screenspace.entity.Code;
import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;
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
        Set<String> existentCodes = pendingUserRepository.findAll().stream().map(p -> p.getCode().getCode()).collect(Collectors.toSet());
        do {
            generatedCode = getCode();
        } while (existentCodes.contains(generatedCode));
        return pendingUserRepository.save(new PendingUser(new User(email, password, isOwner, null), new Code(generatedCode, Instant.now().plus(10, ChronoUnit.MINUTES))));
    }

    @Override
    public User confirmUserCreation(String email, String code) {
        List<PendingUser> foundRequests = pendingUserRepository.findAll().stream().filter(p -> p.getCode().getCode().equals(code) && p.getPendingUser().getEmail().equals(email)).collect(Collectors.toList());
        if(foundRequests.isEmpty())
            throw new RuntimeException();

        User createdUser = userRepository.save(foundRequests.get(0).getPendingUser());
        pendingUserRepository.delete(foundRequests.get(0));

        return createdUser;
    }

    @Override
    public User findUser(String email, String password, boolean isOwner) {
        return userRepository.findByEmailAndPasswordAndIsOwner(email, password, isOwner);
    }

    @Override
    public void deleteUser(String email, boolean isOwner) {
        userRepository.deleteByEmailAndIsOwner(email, isOwner);
    }

    @Override
    public User updateUser(String email, String password, boolean isOwner, String profilePic) {
        return null;
    }

    @Override
    public void passwordReset(String email, boolean isOwner) {
        String generatedCode;
        User requestedUser = userRepository.findByEmailAndIsOwner(email, isOwner);
        if (requestedUser == null){
            throw new RuntimeException();
        }
        Set<String> existentCodes = requestedUser.getCodes()
                .stream()
                .map(Code::getCode)
                .collect(Collectors.toSet());
        do {
            generatedCode = getCode();
        } while (existentCodes.contains(generatedCode));
        requestedUser.addPasswordResetCode(new Code(generatedCode, Instant.now().plus(10, ChronoUnit.MINUTES)));

        emailSender.sendPasswordResetCode(email, generatedCode);
    }

    @Override
    public boolean confirmPasswordReset(String email, boolean isOwner, String code) {
        User requestedUser = userRepository.findByEmailAndIsOwner(email, isOwner);
        if (requestedUser == null){
            throw new RuntimeException();
        }

        return requestedUser.getCodes()
                .stream()
                .anyMatch(c -> c.getCode().equals(code) && c.getExpirationDate().isAfter(Instant.now()));
    }

    private String getCode() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
