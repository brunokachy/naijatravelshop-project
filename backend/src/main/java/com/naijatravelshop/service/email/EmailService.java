package com.naijatravelshop.service.email;

import java.util.Map;

public interface EmailService {

    void sendPlainEmail(String to, String subject, String text);

    void sendPlainEmail(String[] recipients, String subject, String text);

    void sendHtmlEmail(String to, String subject, String templateFileName, Map<String, Object> emailVariables, String emailSender);

    void sendHtmlEmail(String[] recipients, String subject, String templateFileName, Map<String, Object> emailVariables, String emailSender);

    void sendEmail(String[] recipients, String subject, String content, boolean isHTML, String emailSender);

}
