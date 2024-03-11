package com.ineuron.jdbc.factory;

import com.ineuron.jdbc.dao.IEmployeeDao;
import com.ineuron.jdbc.dao.EmployeeDaoImpl;

public class EmployeeDaoFactory {
    private static EmployeeDaoImpl EmployeeDao = null;
	private EmployeeDaoFactory() { // private bcoz to private object creation from outside
	}
	public static IEmployeeDao getEmployeeDao() {
		if(EmployeeDao == null) {
			EmployeeDao = new EmployeeDaoImpl();
		}
		return EmployeeDao;
	}
 
}
