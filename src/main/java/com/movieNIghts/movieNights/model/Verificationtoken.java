/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movieNIghts.movieNights.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bizmi
 */
@Entity
@Table(name = "verificationtoken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Verificationtoken.findAll", query = "SELECT v FROM Verificationtoken v")
    , @NamedQuery(name = "Verificationtoken.findById", query = "SELECT v FROM Verificationtoken v WHERE v.id = :id")
    , @NamedQuery(name = "Verificationtoken.findByToken", query = "SELECT v FROM Verificationtoken v WHERE v.token = :token")
    , @NamedQuery(name = "Verificationtoken.findByExpiredate", query = "SELECT v FROM Verificationtoken v WHERE v.expiredate = :expiredate")})
public class Verificationtoken implements Serializable {

    private static final int EXPIRATION = 60 * 24;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "token")
    private String token;
    @Column(name = "expiredate")
    @Temporal(TemporalType.DATE)
    private Date expiredate;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private User user;

    public Verificationtoken() {
    }

    public Verificationtoken(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Verificationtoken(String token, User user) {
        this.token = token;
        this.user = user;
        this.expiredate = calculateExpiryDate(EXPIRATION);
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Verificationtoken)) {
            return false;
        }
        Verificationtoken other = (Verificationtoken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.Verificationtoken[ id=" + id + " ]";
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }

}
