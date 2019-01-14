package com.example.jaas;

import java.io.IOException;
import java.security.Principal;
import java.security.acl.Group;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

import org.jboss.security.SimpleGroup;
import org.jboss.security.SimplePrincipal;

public class MyLoginModule implements LoginModule {

	private Principal identity;
	private Subject subject;
	private CallbackHandler callbackHandler;
	private Map<String, ?> sharedState;
	private Map<String, ?> options;

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState,
			Map<String, ?> options) {
		this.subject = subject;
		this.callbackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	@Override
	public boolean login() throws LoginException {
		System.out.println("[MyLoginModule] Login");

		if (callbackHandler == null) {
			throw new LoginException("Error: no CallbackHandler available.");
		}

		NameCallback nameCallback = new NameCallback("username");
		PasswordCallback passwordCallback = new PasswordCallback("password: ", false);
		Callback[] callbacks = { nameCallback, passwordCallback };

		try {
			callbackHandler.handle(callbacks);

			String username = nameCallback.getName();
			String password = null;
			
			if (passwordCallback.getPassword() != null) {
				password = String.valueOf(passwordCallback.getPassword());
			}

			System.out.println("Username :" + username);
			System.out.println("Password : " + password);

			if (username == null || password == null) {
				System.out.println("Callback handler does not return login data properly");
				throw new LoginException("Callback handler does not return login data properly");
			}

			if (isValidUser(username, password)) {
				identity = new MyPrincipal(username);
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (UnsupportedCallbackException e) {
			e.printStackTrace();
		}

		return false;
	}

	private boolean isValidUser(String username, String password) {
		if (username.equals("admin") && password.equals("123456")) {
			return true;
		}

		return false;
	}

	@Override
	public boolean commit() throws LoginException {
		System.out.println("[MyLoginModule] Commit");

		if (identity == null) {
			return false;
		}

		if (!subject.getPrincipals().contains(identity)) {
			subject.getPrincipals().add(identity);
		}
		// Roles
        Group[] groups = { new SimpleGroup("Roles") };
        groups[0].addMember(new SimplePrincipal("SIE"));
		subject.getPrincipals().add(groups[0]);

		return true;
	}

	@Override
	public boolean abort() throws LoginException {
		System.out.println("[MyLoginModule] Abort");
		return logout();
	}

	@Override
	public boolean logout() throws LoginException {
		System.out.println("[MyLoginModule] Logout");

		if (identity != null) {
			System.out.println("[MyLoginModule] Logout: " + identity.getName());
			Set<Principal> principals = subject.getPrincipals();
			Iterator<Principal> iter = principals.iterator();
			while (iter.hasNext()) {
				Object p = iter.next();
				if (p instanceof Principal) {
					iter.remove();
				}
			}
			System.out.println("[MyLoginModule] Successful logout");
		}

		return true;
	}

}