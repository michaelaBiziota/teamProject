/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.authentication;

import org.springframework.security.core.Authentication;

/**
 *
 * @author bizmi
 */
public interface IAuthenticationFacade {
   public Authentication getAuthentication();
}
