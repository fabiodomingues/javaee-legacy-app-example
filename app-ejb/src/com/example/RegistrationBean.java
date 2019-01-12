package com.example;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class RegistrationBean implements SessionBean {
	 
	public String register(String username, String password) {
		return "Hello";
	}
	
	public void ejbCreate() { }

	@Override
	public void ejbActivate() throws EJBException, RemoteException { }

	@Override
	public void ejbPassivate() throws EJBException, RemoteException { }

	@Override
	public void ejbRemove() throws EJBException, RemoteException { }

	@Override
	public void setSessionContext(SessionContext arg0) throws EJBException, RemoteException { }

}