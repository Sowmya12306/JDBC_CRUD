package com.ineuron.jdbc.controller;

import com.ineuron.jdbc.dto.Employee;
import com.ineuron.jdbc.factory.EmployeeControllerFactory;
import com.ineuron.jdbc.factory.EmployeeServiceFactory;
import com.ineuron.jdbc.service.IEmployeeService;

public class EmployeeControllerImpl implements IEmployeeController{
	IEmployeeService empService;
	
@Override
public String save(Employee emp) {
	empService = EmployeeServiceFactory.getEmployeeService();
	System.out.println("Implementation class name is :: "+ empService.getClass().getName());
	return empService.save(emp);
}

@Override
public Employee findById(Integer eid) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.findById(eid);
}

@Override
public String updateById(Employee emp) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.updateById(emp);}

@Override
public String deleteById(Integer eid) {
	empService = EmployeeServiceFactory.getEmployeeService();
	return empService.deleteById(eid);}
}
