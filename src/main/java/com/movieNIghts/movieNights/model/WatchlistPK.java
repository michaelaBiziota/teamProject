/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bizmi
 */
@Embeddable
public class WatchlistPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "movieid")
    private int movieid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userid")
    private int userid;

    public WatchlistPK() {
    }

    public WatchlistPK(int movieid, int userid) {
        this.movieid = movieid;
        this.userid = userid;
    }

    public int getMovieid() {
        return movieid;
    }

    public void setMovieid(int movieid) {
        this.movieid = movieid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) movieid;
        hash += (int) userid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WatchlistPK)) {
            return false;
        }
        WatchlistPK other = (WatchlistPK) object;
        if (this.movieid != other.movieid) {
            return false;
        }
        if (this.userid != other.userid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.WatchlistPK[ movieid=" + movieid + ", userid=" + userid + " ]";
    }
    
}
