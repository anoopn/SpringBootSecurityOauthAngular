package com.camphor.application.security.oauth.config.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.camphor.application.security.oauth.config.transactions.InterUserTransaction;

@Service(value = "userService")
public class UserValidationServiceImpl implements InterUserValidationService {

	@Autowired
	InterUserTransaction transaction;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(username))
			throw new UsernameNotFoundException(username);
		try {
			com.camphor.application.security.oauth.entity.UserDetails userDetails = transaction
					.findUserDetails(username);
			if (userDetails != null) {
				Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
				setAuths.add(new SimpleGrantedAuthority("ADMIN"));
				List<GrantedAuthority> roles = new ArrayList<>(setAuths);
				return new User(userDetails.getUserId(), userDetails.getPassword(), roles);
			} else {
				throw new UsernameNotFoundException(username);
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
