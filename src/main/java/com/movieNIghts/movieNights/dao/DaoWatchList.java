/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.dao;

import com.movieNIghts.movieNights.model.Watchlist;
import com.movieNIghts.movieNights.repository.WatchListRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bizmi
 */
@Service
public class DaoWatchList {

    @Autowired
    WatchListRepository wlr;

    public void addToWatchList(Watchlist watchlist) {
        wlr.save(watchlist);
    }

    public List<Watchlist> findWatchListByUserId(int userid) {
        return wlr.findByuserId(userid);
    }

    public Watchlist findByUserIdandMovieId(int userid, int movieid) {
        return wlr.findByuserIdAndMovieId(userid, movieid);
    }
    
    public void deleteByUserIdandMovieId(Watchlist wm) {
        wlr.delete(wm);
    }
}
