/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.repository;

import com.movieNIghts.movieNights.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bizmi
 */
public interface UsersRepository extends JpaRepository<Users,Integer>{
    
}
