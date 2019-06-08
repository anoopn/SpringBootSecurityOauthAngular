package com.camphor.application.security.oauth.config.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.camphor.application.security.oauth.entity.UserDetails;

@Repository
public class UserDetailsDAOImpl implements InterUserDetailsDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UserDetails findUserDetails(String userID) {
		Session session = sessionFactory.getCurrentSession();
		Criteria ctrUserDetails = session.createCriteria(UserDetails.class);
		ctrUserDetails.add(Restrictions.eq("userId", userID));
		return (UserDetails) ctrUserDetails.uniqueResult();
	}

}
