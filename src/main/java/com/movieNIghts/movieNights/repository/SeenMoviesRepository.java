/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.repository;

import com.movieNIghts.movieNights.model.Seenmovies;
import com.movieNIghts.movieNights.model.SeenmoviesPK;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bizmi
 */
@Repository
public interface SeenMoviesRepository extends JpaRepository<Seenmovies, SeenmoviesPK> {

    @Query(value = "Select * from seenmovies where userid= :userid", nativeQuery = true)
    public List<Seenmovies> findByuserId(@Param("userid") int userid);
    
    @Query(value="Select *  from seenmovies where userid= :userid and movieid= :movieid",nativeQuery=true)
    public Seenmovies findByuserIdAndMovieId(@Param("userid") int userid,@Param("movieid") int movieid);
}
