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
@Table(name = "userandmovie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userandmovie.findAll", query = "SELECT u FROM Userandmovie u")
    , @NamedQuery(name = "Userandmovie.findByMovieid", query = "SELECT u FROM Userandmovie u WHERE u.userandmoviePK.movieid = :movieid")
    , @NamedQuery(name = "Userandmovie.findByUserid", query = "SELECT u FROM Userandmovie u WHERE u.userandmoviePK.userid = :userid")})
public class Userandmovie implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserandmoviePK userandmoviePK;
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    public Userandmovie() {
    }

    public Userandmovie(UserandmoviePK userandmoviePK) {
        this.userandmoviePK = userandmoviePK;
    }

    public Userandmovie(int movieid, int userid) {
        this.userandmoviePK = new UserandmoviePK(movieid, userid);
    }

    public UserandmoviePK getUserandmoviePK() {
        return userandmoviePK;
    }

    public void setUserandmoviePK(UserandmoviePK userandmoviePK) {
        this.userandmoviePK = userandmoviePK;
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
        hash += (userandmoviePK != null ? userandmoviePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userandmovie)) {
            return false;
        }
        Userandmovie other = (Userandmovie) object;
        if ((this.userandmoviePK == null && other.userandmoviePK != null) || (this.userandmoviePK != null && !this.userandmoviePK.equals(other.userandmoviePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.Userandmovie[ userandmoviePK=" + userandmoviePK + " ]";
    }
    
}
