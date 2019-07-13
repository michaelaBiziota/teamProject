/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.authentication.IAuthenticationFacade;

import com.movieNIghts.movieNights.conf.MyUserDetailsService;
import com.movieNIghts.movieNights.dao.DaoRoles;
import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.repository.UserRepository;
import com.movieNIghts.movieNights.validation.UserValidation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bizmi
 */
@Controller
public class UserController {

    @Autowired
    DaoUser du;
    @Autowired
    DaoRoles dr;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserValidation uv;
    @Autowired
    MyUserDetailsService ud;
    @Autowired
    UserRepository ur;
    @Autowired
    IAuthenticationFacade authenticationFacade;

    @InitBinder
    private void initBider(final WebDataBinder binder) {
        binder.setValidator(uv);

    }

    @RequestMapping(value = "registerUser", method = RequestMethod.GET)
    public String registerUser(ModelMap mm) {
        User u = new User();
        mm.addAttribute("user", u);

        return "registration";
    }

    @RequestMapping(value = "doRegisterUser", method = RequestMethod.POST)
    public String doRegisterUser(@RequestParam(value = "password") String pass, @ModelAttribute("user") User us, @Valid User user, BindingResult br) {

        if (br.hasErrors()) {
            return "registration";
        } else {
            us.setPassword(passwordEncoder.encode(pass));
            us.setRole(dr.getRole(1));

            du.registration(us);
        }

        return "movies";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserNameSimple() {
        Authentication authentication = authenticationFacade.getAuthentication();
        return authentication.getName();
    }

}
