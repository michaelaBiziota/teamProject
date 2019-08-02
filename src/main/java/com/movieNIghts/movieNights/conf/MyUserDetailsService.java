/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.conf;

import com.movieNIghts.movieNights.dao.DaoRoles;
import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    UserRepository ur;

    
    @Autowired
    DaoRoles dr;
    
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

       User user=ur.findByUsername(string);
//||(!user.getEnabled())
       if (user==null){
           throw new UsernameNotFoundException("User not found");
        }
       
       return new UserDetailsImpl(user);
    }
    
}
