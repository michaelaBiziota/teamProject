/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.dao.PasswordResetDao;
import com.movieNIghts.movieNights.model.User;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bizmi
 */
@Controller
public class PasswordResetController {

//    @Autowired
//    private UserRepository userService;
//    @Autowired
//    private PasswordResetTokenRepository tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private PasswordResetDao prd;
    @Autowired
    private DaoUser du;
//    @ModelAttribute("passwordResetForm")
//    public PasswordResetDto passwordReset() {
//        return new PasswordResetDto();
//    }
//
//    @GetMapping
//    public String displayResetPasswordPage(@RequestParam(required = false) String token,
//                                           Model model) {
//
//        PasswordResetToken resetToken = tokenRepository.findByToken(token);
//        if (resetToken == null){
//            model.addAttribute("error", "Could not find password reset token.");
//        } else if (resetToken.isExpired()){
//            model.addAttribute("error", "Token has expired, please request a new password reset.");
//        } else {
//            model.addAttribute("token", resetToken.getToken());
//        }
//
//        return "resetPassword";
//    }
//
//    @PostMapping
//    @Transactional
//    public String handlePasswordReset(@ModelAttribute("passwordResetForm") @Valid PasswordResetDto form,
//                                      BindingResult result,
//                                      RedirectAttributes redirectAttributes) {
//
//        if (result.hasErrors()){
//            return "resetPassword";
//        }
//
//        PasswordResetToken token = tokenRepository.findByToken(form.getToken());
//        User user = token.getUser();
//        String updatedPassword = passwordEncoder.encode(form.getPassword());
//        userService.updatePassword(updatedPassword, user.getId());
//        tokenRepository.delete(token);
//
//        return "login";
//    }

    @RequestMapping(value = "/user/changePassword", method = RequestMethod.GET)
    public String showChangePasswordPage(Locale locale, ModelMap model,
            @RequestParam("id") int id, @RequestParam("token") String token) {
        String result = prd.validatePasswordResetToken(id, token);
        if (result != null) {
            model.addAttribute("message",result);
            return "forgotPassword";
        }
        return "resetPassword";
    }
@RequestMapping(value = "/savePassword", method = RequestMethod.POST)
//@ResponseBody
public String savePassword(@RequestParam(value="newPassword") String newPassword,ModelMap mm) {
    User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     newPassword=passwordEncoder.encode(newPassword);
     user.setPassword(newPassword);
    du.registration(user);
    mm.addAttribute("savePass","your password has been reset");
return "login";
}
}
