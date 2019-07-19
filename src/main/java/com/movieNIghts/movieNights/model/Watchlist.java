/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bizmi
 */
@Entity
@Table(name = "watchlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Watchlist.findAll", query = "SELECT w FROM Watchlist w")
    , @NamedQuery(name = "Watchlist.findByMovieid", query = "SELECT w FROM Watchlist w WHERE w.watchlistPK.movieid = :movieid")
    , @NamedQuery(name = "Watchlist.findByUserid", query = "SELECT w FROM Watchlist w WHERE w.watchlistPK.userid = :userid")})
public class Watchlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WatchlistPK watchlistPK;
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Watchlist() {
    }

    public Watchlist(WatchlistPK watchlistPK) {
        this.watchlistPK = watchlistPK;
    }

    public Watchlist(int movieid, int userid) {
        this.watchlistPK = new WatchlistPK(movieid, userid);
    }

    public WatchlistPK getWatchlistPK() {
        return watchlistPK;
    }

    public void setWatchlistPK(WatchlistPK watchlistPK) {
        this.watchlistPK = watchlistPK;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (watchlistPK != null ? watchlistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Watchlist)) {
            return false;
        }
        Watchlist other = (Watchlist) object;
        if ((this.watchlistPK == null && other.watchlistPK != null) || (this.watchlistPK != null && !this.watchlistPK.equals(other.watchlistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.Watchlist[ watchlistPK=" + watchlistPK + " ]";
    }
    
}
