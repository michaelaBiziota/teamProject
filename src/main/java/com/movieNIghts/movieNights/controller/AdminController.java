/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.dao.DaoRoles;
import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.validation.UserValidation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bizmi
 */
@Controller
public class AdminController {

    @Autowired
    DaoUser du;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
    @Autowired
    UserValidation uv;
    @Autowired
    DaoRoles dr;

    @RequestMapping(value = "/allusers", method = RequestMethod.GET)
    public String getAllUsers(ModelMap m) {
        m.addAttribute("userlist", du.getAll());
        return "admin";

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        du.deleteUser(id);
        return "redirect:/allusers";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(ModelMap m, @PathVariable int id, @ModelAttribute("users") User u) {

        User user = du.findById(id);
        m.addAttribute("id", user);
        m.addAttribute("rolesArray", dr.getAll());

        return "update";
    }

    @RequestMapping(value = "updatedUser", method = RequestMethod.POST)
    public String updatedUser(@RequestParam(value = "password") String pass, @ModelAttribute("id") User us) {

        us.setPassword(passwordEncoder.encode(pass));

        du.registration(us);

        return "redirect:/allusers";

    }


}
