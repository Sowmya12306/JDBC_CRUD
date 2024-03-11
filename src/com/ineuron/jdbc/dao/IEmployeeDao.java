package com.ineuron.jdbc.dao;

import com.ineuron.jdbc.dto.Employee;

public interface IEmployeeDao {


	String save(Employee emp); //create 
	Employee findById(Integer eid);//for read 
	String updateById(Employee emp);
	String deleteById(Integer eid);
}
