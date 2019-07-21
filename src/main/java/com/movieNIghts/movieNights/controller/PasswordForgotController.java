/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;
import com.movieNIghts.movieNights.dao.PasswordResetDao;
import com.movieNIghts.movieNights.emailConfig.EmailService;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.repository.PasswordResetTokenRepository;
import com.movieNIghts.movieNights.repository.UserRepository;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author bizmi
 */
@Controller

@RequestMapping("/forgot-password")
public class PasswordForgotController {

    @Autowired
    UserRepository userService;
    @Autowired
    PasswordResetTokenRepository tokenRepository;
    @Autowired
    EmailService emailService;
    @Autowired
    PasswordResetDao prd;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MessageSource messages;


    @GetMapping
    public String displayForgotPasswordPage(ModelMap mm) {
//        mm.addAttribute("forgotPasswordForm", new PasswordForgotDto());
        return "forgotPassword";
    }

//    @PostMapping
//    public String processForgotPasswordForm(@ModelAttribute("forgotPasswordForm") @Valid PasswordForgotDto form,
//                                            BindingResult result,
//                                            HttpServletRequest request,ModelMap mm) {
//
//        if (result.hasErrors()){
//            return "forgotPassword";
//        }
//
//        User user = userService.findUserByEmail(form.getEmail());
//        if (user == null){
//            result.rejectValue("email", null, "We could not find an account for that e-mail address.");
//            return "forgot-password";
//        }
//
//        PasswordResetToken token = new PasswordResetToken();
//        token.setToken(UUID.randomUUID().toString());
//        token.setUser(user);
//        token.setExpiryDate(30);
//        tokenRepository.save(token);
//
//        Mail mail = new Mail();
//        mail.setFrom("no-reply@gmail.com");
//        mail.setTo(user.getEmail());
//        mail.setSubject("Password reset request");
//
//        Map<String, Object> model = new HashMap<>();
//        model.put("token", token);
//        model.put("user", user);
//        model.put("signature", "https://resetPassword.com");
//        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
//        model.put("resetUrl", url + "/reset-password?token=" + token.getToken());
//        mail.setModel(model);
//        emailService.sendEmail(mail);
//mm.addAttribute("success","You have successfully request a new password");
//        return "forgotPassword";
//
//    }
    
    
    
//    @PostMapping
//    @ResponseBody
//    public GenericResponse resetPassword(HttpServletRequest request, @RequestParam("email") String userEmail) {
//        User user = userService.findByEmail(userEmail);      
//        String token = UUID.randomUUID().toString();
//        prd.createPasswordResetTokenForUser(user, token);
//        mailSender.send(emailService.constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
//        return new GenericResponse("message.resetPasswordEmail");
//    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
        @PostMapping
//    @ResponseBody
    public String resetPassword(ModelMap mm,HttpServletRequest request, @RequestParam("email") String userEmail) {
        User user = userService.findByEmail(userEmail); 
        if (user==null){mm.addAttribute("userNotFound", "This email address doe not belong to any registered user");
        return"forgotPassword";
        }
        String token = UUID.randomUUID().toString();
        prd.createPasswordResetTokenForUser(user, token);
        mailSender.send(emailService.constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
        mm.addAttribute("reset", "An Email has been sent to reset your password");
        return "login";
    }

}
