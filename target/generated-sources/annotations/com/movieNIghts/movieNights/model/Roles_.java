package com.movieNIghts.movieNights.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Roles.class)
public abstract class Roles_ {

	public static volatile CollectionAttribute<Roles, User> userCollection;
	public static volatile SingularAttribute<Roles, String> userrole;
	public static volatile SingularAttribute<Roles, Integer> id;

	public static final String USER_COLLECTION = "userCollection";
	public static final String USERROLE = "userrole";
	public static final String ID = "id";

}

