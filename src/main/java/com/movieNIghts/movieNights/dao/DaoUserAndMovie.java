/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.model.User;
import com.movieNIghts.movieNights.model.Userandmovie;
import com.movieNIghts.movieNights.model.UserandmoviePK;
import com.movieNIghts.movieNights.repository.UserAndMovieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class DaoUserAndMovie {
 
    @Autowired
    UserAndMovieRepository umr;
    
    public Userandmovie findById(UserandmoviePK id){
   return umr.getOne(id);  
    }
        public void addToUserAndMovie(Userandmovie usermovie){
    umr.save(usermovie);
    }
        
public List<Userandmovie> findMovieByUserId(int userid){
return umr.findByuserId(userid);
}
  
public Userandmovie findByUserIdandMovieId(int userid,int movieid){
return umr.findByuserIdAndMovieId(userid, movieid);
}
public void deleteByUserIdandMovieId(Userandmovie um) {
        umr.delete(um);
    }
}
