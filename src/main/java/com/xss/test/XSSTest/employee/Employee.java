package com.xss.test.XSSTest.employee;

import org.hibernate.validator.constraints.SafeHtml;

public class Employee {

	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE)
	private String empId;
	
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE)
	private String empName;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

}