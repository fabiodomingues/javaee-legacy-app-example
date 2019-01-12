package com.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		Context context = new InitialContext();
		Object ref = context.lookup("com.example/RegistrationEJB");
		Object javaRef = PortableRemoteObject.narrow(ref, RegistrationHome.class);
		RegistrationHome registrationHome = (RegistrationHome) javaRef;
		RegistrationEJB registrationEJB = registrationHome.create();
		String value = registrationEJB.register("", "");
		registrationEJB.remove();
		
		System.out.println(value);
		
		return (mapping.findForward("success"));
	}

}