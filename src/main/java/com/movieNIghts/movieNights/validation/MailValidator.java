/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.validation;

import com.movieNIghts.movieNights.dao.DaoUser;
import com.movieNIghts.movieNights.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author bizmi
 */
@Component
public class MailValidator implements Validator {

    @Autowired
    DaoUser du;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (user.getEmail().equals(du.getUserByEmail(user.getEmail()).getEmail()));
        errors.rejectValue("email", "email.already.exists");
    }

}
