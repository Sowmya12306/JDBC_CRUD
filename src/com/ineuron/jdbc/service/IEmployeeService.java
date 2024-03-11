package com.ineuron.jdbc.service;

import com.ineuron.jdbc.dto.Employee;

public interface IEmployeeService {

	String save(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);
}
