package com.xss.test.XSSTest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xss.test.XSSTest.employee.Employee;
import com.xss.test.XSSTest.service.EmployeeService;
import com.xss.test.XSSTest.user.User;

@Controller
public class XSSController {
	
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@RequestMapping("/showLogin")
	public ModelAndView showLogin() {
		return new ModelAndView("login", "user", new User());
	}
	
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user) {
		String userName=user.getUname();
		String password=user.getPwd();
		ModelAndView mav= new ModelAndView("login");
		if(userName!=null && !userName.equalsIgnoreCase("")) {
			if(userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
				mav.setViewName("welcome");		
			}else {
				mav.addObject("errorMsg", "Please Check UserName Or Password");
			}
		}else {
			mav.addObject("errorMsg", "Username or password shouldn't be empty");
		}
		return mav;
		
	}
	
	@RequestMapping(value = "/addEmployee")
	public ModelAndView addEmployee() {
		return new ModelAndView("addEmployee", "emp", new Employee());
	}

	
	
	@RequestMapping(value = "/addNewEmployee", method = RequestMethod.POST)
	public ModelAndView addNewEmployee(@Valid Employee emp, BindingResult result) {
		ModelAndView model = new ModelAndView("getEmployees");
		if(result.hasErrors()) {
			ModelAndView errorModel=new ModelAndView("addEmployee", "emp", new Employee());
			errorModel.addObject("errorinput", "Can't Add Html Input In The Inputs");
			return errorModel;
		}
		employeeService.insertEmployee(emp);
		List<Employee> employees = employeeService.getAllEmployees();
		model.addObject("employees", employees);
		return model;
	}
	
	@RequestMapping(value = "/searchEmployee")
	public ModelAndView searchEmployee(@ModelAttribute("emp") Employee emp) {
		ModelAndView model = new ModelAndView("employeeSearch");
		return model;
	}
	
	@RequestMapping(value = "/searchEmployees", method = RequestMethod.POST)
	public ModelAndView searchEmployees(@ModelAttribute("emp") Employee emp) {
		Employee employeeById = employeeService.getEmployeeById(emp.getEmpId());
		ModelAndView model = new ModelAndView("employeeSearch");
		model.addObject("employees", employeeById);
		return model;
	}

}
