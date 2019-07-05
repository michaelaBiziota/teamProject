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
@Table(name = "usersandmovies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usersandmovies.findAll", query = "SELECT u FROM Usersandmovies u")
    , @NamedQuery(name = "Usersandmovies.findByMovieid", query = "SELECT u FROM Usersandmovies u WHERE u.usersandmoviesPK.movieid = :movieid")
    , @NamedQuery(name = "Usersandmovies.findByUserid", query = "SELECT u FROM Usersandmovies u WHERE u.usersandmoviesPK.userid = :userid")})
public class Usersandmovies implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersandmoviesPK usersandmoviesPK;
    @JoinColumn(name = "userid", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Usersandmovies() {
    }

    public Usersandmovies(UsersandmoviesPK usersandmoviesPK) {
        this.usersandmoviesPK = usersandmoviesPK;
    }

    public Usersandmovies(int movieid, int userid) {
        this.usersandmoviesPK = new UsersandmoviesPK(movieid, userid);
    }

    public UsersandmoviesPK getUsersandmoviesPK() {
        return usersandmoviesPK;
    }

    public void setUsersandmoviesPK(UsersandmoviesPK usersandmoviesPK) {
        this.usersandmoviesPK = usersandmoviesPK;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersandmoviesPK != null ? usersandmoviesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usersandmovies)) {
            return false;
        }
        Usersandmovies other = (Usersandmovies) object;
        if ((this.usersandmoviesPK == null && other.usersandmoviesPK != null) || (this.usersandmoviesPK != null && !this.usersandmoviesPK.equals(other.usersandmoviesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.Usersandmovies[ usersandmoviesPK=" + usersandmoviesPK + " ]";
    }
    
}
