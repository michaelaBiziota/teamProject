package com.movieNIghts.movieNights.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Verificationtoken.class)
public abstract class Verificationtoken_ {

	public static volatile SingularAttribute<Verificationtoken, Integer> id;
	public static volatile SingularAttribute<Verificationtoken, Date> expiredate;
	public static volatile SingularAttribute<Verificationtoken, User> user;
	public static volatile SingularAttribute<Verificationtoken, String> token;

	public static final String ID = "id";
	public static final String EXPIREDATE = "expiredate";
	public static final String USER = "user";
	public static final String TOKEN = "token";

}

