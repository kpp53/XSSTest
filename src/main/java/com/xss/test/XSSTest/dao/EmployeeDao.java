package com.xss.test.XSSTest.dao;

import java.util.List;

import com.xss.test.XSSTest.employee.Employee;

public interface EmployeeDao {
	void insertEmployee(Employee cus);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empId);
}