package com.example;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface RegistrationHome extends EJBHome {
		 
	RegistrationEJB create() throws RemoteException, CreateException;

}