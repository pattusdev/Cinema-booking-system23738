package com.cinema23738.cinema.service;

import javax.mail.MessagingException;

public interface MailService {

    void sendMail(final String to, final String subject, final String text,
                  final boolean isHtmlContent) throws MessagingException;
}