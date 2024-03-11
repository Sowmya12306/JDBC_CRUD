package com.ineuron.jdbc.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.ineuron.jdbc.dto.Employee;
//import com.ineuron.jdbc.util.JdbcUtil;
import com.ineuron.jdbc.util.JdbcUtil;


public class EmployeeDaoImpl implements IEmployeeDao {
	Connection connection = null;

	@Override
	public String save(Employee emp) {
		String status = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "insert into Employee(name, email, city, country) values (?,?,?,?)";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
		  pstmt = connection.prepareStatement(sqlQuery);
			if(pstmt!=null) {
				pstmt.setString(1, emp.getName());
				pstmt.setString(2, emp.getEmail());
				pstmt.setString(3, emp.getCity());
				pstmt.setString(4, emp.getCountry());
			
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1) {
					status = "success";
				}else {
					status="failure";
				}
			}
			
		    
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			status = "failure";
		} 
		return status;
	}

	@Override
	public Employee findById(Integer eid) {
		String query = "select id, name, email, city, country from Employee where id=? ";
		PreparedStatement pstmt = null;
        Employee emp = null;
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
		  pstmt = connection.prepareStatement(query);
			if(pstmt!=null) {
			pstmt.setInt(1, eid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				//copy the rs data into employeeDto and transfer to view
//				Resultset can view the record based on column name or column number but using column number is recommended
//				here we tried using column name instead of column number from lines 65-69
				emp =new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setCity(rs.getString("city"));
				emp.setCountry(rs.getString("country"));
			}		 
		}    
	} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return emp;
		}

	@Override
	public String updateById(Employee emp) {
		String status = null;
		PreparedStatement pstmt = null;
		String sqlQuery = "update Employee set name=?, email=?, city=?, country=? where id =? ";
		try {
			connection = JdbcUtil.getJdbcConnection();
			if(connection!=null)
		  pstmt = connection.prepareStatement(sqlQuery);
			if(pstmt!=null) {
				pstmt.setString(1, emp.getName());
				pstmt.setString(2, emp.getEmail());
				pstmt.setString(3, emp.getCity());
				pstmt.setString(4, emp.getCountry());
				pstmt.setInt(5, emp.getId());
			
				int rowsAffected = pstmt.executeUpdate();
				if(rowsAffected == 1) {
					status = "success";
				}else {
					status="failure";
				}
			}	 
	} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return status;	
		}

	@Override
	public String deleteById(Integer eid) {
		String status = null;
		PreparedStatement pstmt = null;
		String sqlquerydel= "delete from Employee where id=? ";
		try {
			Employee emp = findById(eid);
			if(emp!=null) {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				pstmt = connection.prepareStatement(sqlquerydel);
				if (pstmt != null) {
					pstmt.setInt(1, eid);
					int row = pstmt.executeUpdate();
					if(row == 1)
						status = "success";
				}
			}
		}
			else {
				status="Not Available";
			}
		
	}catch (SQLException | IOException | NullPointerException e) {
			e.printStackTrace();
			status="failure";
			
		}
		return status;
	}
}

