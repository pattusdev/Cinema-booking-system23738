package com.cinema23738.cinema.service;

import com.cinema23738.cinema.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.security.Principal;

public interface UserService {

    String login(final Principal principal);

    String register(final Model model);

    String registerSuccessfully(final User user, final BindingResult bindingResult);
}