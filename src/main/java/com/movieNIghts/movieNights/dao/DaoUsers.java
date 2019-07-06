/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.repository.UsersRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class DaoUsers {

    @Autowired
    UsersRepository ur;

    public void insert(User u) {
        ur.save(u);
    }

    public List<User> getAllUsers() {
        return ur.findAll();
    }

    public User getUserkById(int id) {
        return ur.getOne(id);
    }
}
