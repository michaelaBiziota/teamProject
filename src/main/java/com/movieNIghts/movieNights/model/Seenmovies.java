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
@Table(name = "seenmovies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seenmovies.findAll", query = "SELECT s FROM Seenmovies s")
    , @NamedQuery(name = "Seenmovies.findByMovieid", query = "SELECT s FROM Seenmovies s WHERE s.seenmoviesPK.movieid = :movieid")
    , @NamedQuery(name = "Seenmovies.findByUserid", query = "SELECT s FROM Seenmovies s WHERE s.seenmoviesPK.userid = :userid")})
public class Seenmovies implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SeenmoviesPK seenmoviesPK;
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Seenmovies() {
    }

    public Seenmovies(SeenmoviesPK seenmoviesPK) {
        this.seenmoviesPK = seenmoviesPK;
    }

    public Seenmovies(int movieid, int userid) {
        this.seenmoviesPK = new SeenmoviesPK(movieid, userid);
    }

    public SeenmoviesPK getSeenmoviesPK() {
        return seenmoviesPK;
    }

    public void setSeenmoviesPK(SeenmoviesPK seenmoviesPK) {
        this.seenmoviesPK = seenmoviesPK;
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
        hash += (seenmoviesPK != null ? seenmoviesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seenmovies)) {
            return false;
        }
        Seenmovies other = (Seenmovies) object;
        if ((this.seenmoviesPK == null && other.seenmoviesPK != null) || (this.seenmoviesPK != null && !this.seenmoviesPK.equals(other.seenmoviesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.Seenmovies[ seenmoviesPK=" + seenmoviesPK + " ]";
    }
    
}
