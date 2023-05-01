package com.hdfc.capstone.controller;

import java.io.PrintWriter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hdfc.capstone.vo.EmployeeVO;
import com.hdfc.capstone.vo.EmployeePojo;
import java.util.*;



@RestController
public class EmployeeController {
	
	@GetMapping("/get/{employeeId}")
	public EmployeePojo getEmployee(@PathVariable long employeeId)
	{
		
		EmployeeVO obj2=new EmployeeVO().getEmployeeById(employeeId);		
		return new EmployeePojo(obj2.getEmployeeId(), obj2.getEmployeeName(), obj2.getDateOfBirth());
	
				
	}
	


}
