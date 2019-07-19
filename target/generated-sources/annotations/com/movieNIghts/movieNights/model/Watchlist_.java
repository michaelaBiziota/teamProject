package com.movieNIghts.movieNights.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Watchlist.class)
public abstract class Watchlist_ {

	public static volatile SingularAttribute<Watchlist, WatchlistPK> watchlistPK;
	public static volatile SingularAttribute<Watchlist, User> user;

	public static final String WATCHLIST_PK = "watchlistPK";
	public static final String USER = "user";

}

