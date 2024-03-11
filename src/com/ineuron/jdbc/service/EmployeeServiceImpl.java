package com.ineuron.jdbc.service;

import com.ineuron.jdbc.dao.IEmployeeDao;
import com.ineuron.jdbc.dto.Employee;
import com.ineuron.jdbc.factory.EmployeeDaoFactory;

public class EmployeeServiceImpl implements IEmployeeService {
	IEmployeeDao empDao;

	@Override
	public String save(Employee emp) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.save(emp);

	}

	@Override
	public Employee findById(Integer eid) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.findById(eid);
	}

	@Override
	public String updateById(Employee emp) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.updateById(emp);	}

	@Override
	public String deleteById(Integer eid) {
		empDao = EmployeeDaoFactory.getEmployeeDao();
		return empDao.deleteById(eid);	}

}
