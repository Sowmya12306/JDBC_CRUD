package com.ineuron.jdbc.factory;

import com.ineuron.jdbc.controller.IEmployeeController;
import com.ineuron.jdbc.controller.EmployeeControllerImpl;

public class EmployeeControllerFactory {
	private static EmployeeControllerImpl EmployeeController = null;

	private EmployeeControllerFactory() {
		
	}
    public static IEmployeeController getEmployeeController() {
	if(EmployeeController == null)
	EmployeeController = new EmployeeControllerImpl();
	return EmployeeController;
}	
}
