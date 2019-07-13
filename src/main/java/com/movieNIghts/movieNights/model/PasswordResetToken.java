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

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "passwordResetToken")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasswordResetToken.findAll", query = "SELECT p FROM PasswordResetToken p")
    , @NamedQuery(name = "PasswordResetToken.findById", query = "SELECT p FROM PasswordResetToken p WHERE p.id = :id")
    , @NamedQuery(name = "PasswordResetToken.findByToken", query = "SELECT p FROM PasswordResetToken p WHERE p.token = :token")
    , @NamedQuery(name = "PasswordResetToken.findByExpirydate", query = "SELECT p FROM PasswordResetToken p WHERE p.expirydate = :expirydate")})
public class PasswordResetToken implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "token",
    nullable = false, unique = true)
    private String token;
    @Column(name = "expirydate")
    @Temporal(TemporalType.DATE)
    private Date expirydate;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @OneToOne
    private User user;
private static final int EXPIRATION = 60 * 24;
    public PasswordResetToken() {
    }

    public PasswordResetToken(Integer id) {
        this.id = id;
    }


    public PasswordResetToken(String token, User user) {
                this.token = token;
        this.user = user;
        this.expirydate = calculateExpiryDate(EXPIRATION);
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

    public Date getExpirydate() {
        return expirydate;
    }

    public void setExpirydate(Date expirydate) {
        this.expirydate = expirydate;
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
        if (!(object instanceof PasswordResetToken)) {
            return false;
        }
        PasswordResetToken other = (PasswordResetToken) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.movieNIghts.movieNights.model.PasswordResetToken[ id=" + id + " ]";
    }

        public void setExpiryDate(final Date expiryDate){
        this.expirydate = expiryDate;
    }

    public boolean isExpired() {
        return new Date().after(this.expirydate);
    }
        private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
    
}
