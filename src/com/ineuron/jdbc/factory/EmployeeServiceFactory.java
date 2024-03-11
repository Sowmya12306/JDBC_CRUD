package com.ineuron.jdbc.factory;

import com.ineuron.jdbc.service.IEmployeeService;
import com.ineuron.jdbc.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {
	private static EmployeeServiceImpl EmployeeServiceImpl;

	private EmployeeServiceFactory() {
		
	}
	public static IEmployeeService getEmployeeService() {
		if(EmployeeServiceImpl==null) {
		EmployeeServiceImpl = new EmployeeServiceImpl();
		}
		return EmployeeServiceImpl;
			
	}
}
