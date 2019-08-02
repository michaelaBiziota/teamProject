/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.model.Seenmovies;
import com.movieNIghts.movieNights.repository.SeenMoviesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class DaoSeenMovies {

    @Autowired
    SeenMoviesRepository sr;

    public void addToseenMovies(Seenmovies seenmovie) {
        sr.save(seenmovie);
    }

    public List<Seenmovies> findMovieByUserid(int userid) {
        return sr.findByuserId(userid);
    }

    public Seenmovies findByUserIdandMovieId(int userid, int movieid) {
        return sr.findByuserIdAndMovieId(userid, movieid);
    }

    public void deleteByUserIdandMovieId(Seenmovies sm) {
        sr.delete(sm);
    }
;
}
