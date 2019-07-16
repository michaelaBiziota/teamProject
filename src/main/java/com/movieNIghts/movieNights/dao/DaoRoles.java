/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.model.Roles;
import com.movieNIghts.movieNights.repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class DaoRoles {

    @Autowired
    RolesRepository rr;

    public Roles getRole(int id) {
        return rr.getOne(id);
    }

    
}
