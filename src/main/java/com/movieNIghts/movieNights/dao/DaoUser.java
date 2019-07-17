/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;


import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author bizmi
 */
@Service
public class DaoUser{
    
    @Autowired 
    UserRepository ur;

    
public void registration(User user){
ur.save(user);
}

public boolean EmailAlreadyExists(String email){
User u=ur.findByEmail(email);
if (u==null){return false;}
else{return true;}
}

public boolean usernameAlreadyExists(String username){
User user= ur.findByUsername(username);
if (user==null){return false;}
else{return true;}

}

public List<User> getAll(){
return ur.findAll();
}

public void deleteUser(int id){
ur.deleteById(id);
}
public User findById(int id){
return ur.getOne(id);
}


    }
    
    
    

