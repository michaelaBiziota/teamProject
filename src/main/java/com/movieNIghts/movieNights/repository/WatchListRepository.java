/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.repository;


import com.movieNIghts.movieNights.model.Watchlist;
import com.movieNIghts.movieNights.model.WatchlistPK;
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
public interface WatchListRepository extends JpaRepository<Watchlist,WatchlistPK>{
    @Query(value = "Select * from watchlist where userid= :userid", nativeQuery = true)
    public List<Watchlist> findByuserId(@Param("userid") int userid);
  
}
