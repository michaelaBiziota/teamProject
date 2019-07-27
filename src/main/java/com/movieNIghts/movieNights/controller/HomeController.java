/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author bizmi
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/login")
    public String loginPage() {

        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logoutPage() {

        return "";
    }

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public String movies() {

        return "movies";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

}
