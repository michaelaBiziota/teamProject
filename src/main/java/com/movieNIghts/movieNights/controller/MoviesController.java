/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.controller;

import com.movieNIghts.movieNights.authentication.AuthenticationFacadeImpl;
import com.movieNIghts.movieNights.conf.UserDetailsImpl;
import com.movieNIghts.movieNights.dao.DaoSeenMovies;
import com.movieNIghts.movieNights.dao.DaoUserAndMovie;
import com.movieNIghts.movieNights.model.Seenmovies;
import com.movieNIghts.movieNights.model.SeenmoviesPK;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.model.UserandmoviePK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author bizmi
 */
@Controller
public class MoviesController {

    @Autowired
    AuthenticationFacadeImpl fa;
    @Autowired
    DaoUserAndMovie dum;
    @Autowired
    DaoSeenMovies dsm;

    @Autowired
    AuthenticationFacadeImpl authentication;

    @RequestMapping(value = "getMovie/{id}", method = RequestMethod.GET)
    public String findMovie(ModelMap mm, @PathVariable("id") int movieId) {
        mm.addAttribute("mId", movieId);
        return "movie";
    }

    @RequestMapping(value = "/findUserIdByMovieId/{id}", method = RequestMethod.GET)
    public String findUserIdByMovieId(@PathVariable UserandmoviePK id) {
        dum.findById(id);
        return "";
    }

    @RequestMapping(value = "/seen/{id}", method = RequestMethod.GET)
    public void addToSeen(@PathVariable("id") int movieId) {
        UserDetailsImpl userd = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userd.getUser();
        Seenmovies sm = new Seenmovies(movieId, user.getId());
        sm.setUser(user);
        dsm.addToseenMovies(sm);
    }

}
