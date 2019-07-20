package com.movieNIghts.movieNights.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, String> firstname;
	public static volatile SingularAttribute<User, Roles> role;
	public static volatile SingularAttribute<User, Integer> id;
	public static volatile SingularAttribute<User, String> email;
	public static volatile CollectionAttribute<User, Verificationtoken> verificationtokenCollection;
	public static volatile SingularAttribute<User, Boolean> enabled;
	public static volatile SingularAttribute<User, String> username;
	public static volatile SingularAttribute<User, String> lastname;

	public static final String PASSWORD = "password";
	public static final String FIRSTNAME = "firstname";
	public static final String ROLE = "role";
	public static final String ID = "id";
	public static final String EMAIL = "email";
	public static final String VERIFICATIONTOKEN_COLLECTION = "verificationtokenCollection";
	public static final String ENABLED = "enabled";
	public static final String USERNAME = "username";
	public static final String LASTNAME = "lastname";

}

