/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;


import com.movieNIghts.movieNights.dao.DaoRoles;
import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.repository.UserRepository;
import com.movieNIghts.movieNights.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    @Autowired
    UserRepository ur;

//        @InitBinder
//    private void initBider(final WebDataBinder binder) {
//        binder.setValidator(uv);
//
//    }
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
    public String updatedUser(ModelMap mm, @RequestParam(value = "myusername") String ou, @RequestParam(value = "myemail") String oe, @RequestParam(value = "mypass") String pass, @ModelAttribute("id") User us) {
        System.out.println("");
//       String n= us.getUsername();
//
//        if (!us.getUsername().equals(ou)) {
//            User t = ur.findByUsername(us.getUsername());
//            if (t != null) {
//                mm.addAttribute("ue", "username already exists");
//                mm.addAttribute("rolesArray", dr.getAll());
//            }
//            if (!us.getEmail().equals(oe)) {
//                User t2 = ur.findByEmail(us.getEmail());
//                if (t2 != null) {
//                    mm.addAttribute("ee", "email already exists");
//                    
//                }
//            }
//            return "update";
//        }
//        if ((!us.getEmail().equals(oe))) {
//            User t2 = ur.findByEmail(us.getEmail());
//            if (t2 != null) {
//                mm.addAttribute("ee", "email already exists");
//                mm.addAttribute("rolesArray", dr.getAll());
//                return "update";
//            }
//        }

               User u = ur.findByUsername(us.getUsername());
        User u2 = ur.findByEmail(us.getEmail());
        int temp1 = us.getId();
               if (u != null) {
            int temp = ur.findByUsername(u.getUsername()).getId();

            if (temp != temp1) {
                mm.addAttribute("ue", "username already exists");
                if (u2 != null) {
                    int temp2 = ur.findByEmail(us.getEmail()).getId();
                    if (temp2 != temp1) {
                        mm.addAttribute("ee", "email already exists");
                    }
                }
                mm.addAttribute("rolesArray", dr.getAll());
                return "update";
            }
        }
        if (u2 != null) {
            int temp2 = ur.findByEmail(us.getEmail()).getId();
            if (temp2 != temp1) {
                mm.addAttribute("ee", "email already exists");
                mm.addAttribute("rolesArray", dr.getAll());
                return "update";
            }
        }


 

        du.registration(us);

        return "redirect:/allusers";

    }

}
//@RequestParam(value = "oldusername") String oldu,
