/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.repository;


import com.movieNIghts.movieNights.model.Userandmovie;
import com.movieNIghts.movieNights.model.UserandmoviePK;
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
public interface UserAndMovieRepository extends JpaRepository<Userandmovie,UserandmoviePK>{

    @Query(value="Select * from userandmovie where userid= :userid",nativeQuery=true)
    public List <Userandmovie> findByuserId(@Param("userid") int userid);
    
    @Query(value="Select *  from userandmovie where userid= :userid and movieid= :movieid",nativeQuery=true)
    public Userandmovie findByuserIdAndMovieId(@Param("userid") int userid,@Param("movieid") int movieid);
}
