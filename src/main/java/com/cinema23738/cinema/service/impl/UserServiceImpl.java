package com.cinema23738.cinema.service.impl;

import com.cinema23738.cinema.model.Token;
import com.cinema23738.cinema.model.User;
import com.cinema23738.cinema.repository.TokenRepository;
import com.cinema23738.cinema.repository.UserRepository;
import com.cinema23738.cinema.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import com.cinema23738.cinema.service.UserService;

import javax.mail.MessagingException;
import java.security.Principal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final TokenRepository tokenRepository;
    private final MailService mailService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public String login(final Principal principal) {
        if (principal != null && ((Authentication) principal).isAuthenticated()) {
            return "forward:/";
        } else {
            return "login";
        }
    }

    @Override
    public String register(final Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @Override
    public String registerSuccessfully(final User user, final BindingResult bindingResult) {
        if (userNameExists(user.getUsername())) {
            bindingResult.addError(new FieldError
                    ("user", "username", "The provided login already exists"));
        }
        if (userEmailExists(user.getEmail())) {
            bindingResult.addError(new FieldError
                    ("user", "email", "The email address you entered already exists"));
        }
        if (bindingResult.hasErrors()) {
            return "register";
        } else {
            addUser(user);
            return "redirect:register?success";
        }
    }

    private void addUser(final User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepository.save(user);
        sendToken(user);
    }

    private void sendToken(final User user) {
        final String tokenValue = UUID.randomUUID().toString();
        final Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepository.save(token);
        String url = "localhost:8080/token?value=" + tokenValue;
        try {
            mailService.sendMail(user.getEmail(), "Register", url, false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private boolean userEmailExists(final String email) {
        return userRepository.findByEmail(email) != null;
    }

    private boolean userNameExists(final String username) {
        return userRepository.findByUsername(username) != null;
    }
}