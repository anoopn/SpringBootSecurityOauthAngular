package com.camphor.application.security.oauth.config.dao;

import com.camphor.application.security.oauth.entity.UserDetails;

public interface InterUserDetailsDAO {

	UserDetails findUserDetails(String userID);
}
