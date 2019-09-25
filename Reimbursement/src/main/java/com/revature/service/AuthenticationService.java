package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.User;

public class AuthenticationService {

	public User authenticateUser(Credentials creds) {
		// if the credentials are not recognized, return null
		// if they are, return user associated with creds
		User u = null;
		if (creds.getUsername().equals("merlin") && creds.getPassword().equals("cat")) {
			u = new User(6, "Merlin", "Higgins");
		}
		return u;
	}
}
