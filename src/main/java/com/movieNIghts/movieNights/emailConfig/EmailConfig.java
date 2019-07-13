/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.emailConfig;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 *
 * @author bizmi
 */
//@Configuration 
//public class EmailConfig {
//@Bean
//public JavaMailSender getJavaMailSender() {
//    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//    mailSender.setHost("smtp.gmail.com");
//    mailSender.setPort(587);
//     
//    mailSender.setUsername("movienightsproject.gmail@gmail.com");
//    mailSender.setPassword("movienightsproject123");
//     
//    Properties props = mailSender.getJavaMailProperties();
//    props.put("mail.transport.protocol", "smtp");
//    props.put("mail.smtp.auth", "true");
//    props.put("mail.smtp.starttls.enable", "false");
//    props.put("mail.debug", "true");
//     
//    return mailSender;
//}
//@Bean
//public SimpleMailMessage templateSimpleMessage() {
//    SimpleMailMessage message = new SimpleMailMessage();
//    message.setText(
//      "This is the test email template for your email:\n%s\n");
//    return message;
//}
//}