package com.camphor.application.security.oauth.config.transactions;

import com.camphor.application.security.oauth.config.exception.DataAccessException;
import com.camphor.application.security.oauth.entity.UserDetails;

public interface InterUserTransaction {

	UserDetails findUserDetails(String userID) throws DataAccessException;
}
