package com.camphor.application.security.oauth.config.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.camphor.application.security.oauth.config.dao.InterUserDetailsDAO;
import com.camphor.application.security.oauth.config.exception.DataAccessException;
import com.camphor.application.security.oauth.entity.UserDetails;

@Service
@Transactional
public class UserTransactionImpl implements InterUserTransaction {

	@Autowired
	InterUserDetailsDAO userDAO;

	@Override
	public UserDetails findUserDetails(String userID) throws DataAccessException {
		try {
			return userDAO.findUserDetails(userID);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
