package com.cinema23738.cinema.service;

import org.springframework.ui.Model;

import java.security.Principal;

public interface TokenService {

    String signUp(final String value);

    String welcome(final Principal principal, final Model model);
}