/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.validation;

import com.movieNIghts.movieNights.conf.MyUserDetailsService;
import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author bizmi
 */
@Component
public class UserValidation implements Validator {

    @Autowired
    DaoUser du;

    @Override
    public boolean supports(Class<?> type) {
        Boolean b=User.class.equals(type);
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        if (du.usernameAlreadyExists(user.getUsername())) {
            errors.rejectValue("username", "username.already.exists");
        } if (du.EmailAlreadyExists(user.getEmail())) {
            errors.rejectValue("email", "email.already.exists");
        }
        if(!user.getEmail().matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"))
        {errors.rejectValue("email", "invalid.email");}
        if(user.getPassword().length()<5){errors.rejectValue("password","password.min");}

    }

}
