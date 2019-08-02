/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.model.Verificationtoken;
import com.movieNIghts.movieNights.repository.VerificationRepository;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class VerificationDao {

    @Autowired
    VerificationRepository verificationRepository;

    public void createVerificationTokenForUser(User user, String token) {
        Verificationtoken myToken = new Verificationtoken(token, user);
        verificationRepository.save(myToken);
    }

    public String validationVerificationToken(int id, String token) {
        Verificationtoken vtoken = verificationRepository.findByToken(token);
        if ((vtoken == null) || (vtoken.getUser()
                .getId() != id)) {
            return "invalidToken";
        }
        Calendar cal = Calendar.getInstance();
        if ((vtoken.getExpiredate()
                .getTime() - cal.getTime()
                        .getTime()) <= 0) {
            return "expiredToken";
        }
        return null;
    }

}
