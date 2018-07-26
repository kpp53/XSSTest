package com.xss.test.XSSTest.service;

import java.util.List;

import com.xss.test.XSSTest.employee.Employee;

public interface EmployeeService {
	void insertEmployee(Employee emp);
	void insertEmployees(List<Employee> employees);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(String empid);
}