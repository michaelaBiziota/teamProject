package com.movieNIghts.movieNights.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PasswordResetToken.class)
public abstract class PasswordResetToken_ {

	public static volatile SingularAttribute<PasswordResetToken, Date> expirydate;
	public static volatile SingularAttribute<PasswordResetToken, Integer> id;
	public static volatile SingularAttribute<PasswordResetToken, User> user;
	public static volatile SingularAttribute<PasswordResetToken, String> token;

	public static final String EXPIRYDATE = "expirydate";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

