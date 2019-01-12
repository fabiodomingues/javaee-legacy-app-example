package com.example;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface RegistrationEJB extends EJBObject {
	 
	String register(String username, String password) throws RemoteException;

}