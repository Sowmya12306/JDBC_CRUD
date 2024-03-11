package com.ineuron.jdbc.controller;

import com.ineuron.jdbc.dto.Employee;

public interface IEmployeeController {

	String save(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);
	
}
