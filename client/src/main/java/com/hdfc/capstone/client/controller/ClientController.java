package com.hdfc.capstone.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.capstone.client.exception.EmployeeNotFoundException;
import com.hdfc.capstone.client.vo.EmployeeVO;

@RestController
@RequestMapping("/client")
public class ClientController {
  @Autowired
  private RestTemplate rest;

  private String baseUrl = "https://localhost:8086/emp/findEmp/";

  @GetMapping("/getdata/{employeeID}")
  public EmployeeVO getEmployeeById(@PathVariable int employeeID) throws Exception {
    EmployeeVO employeeVO = rest.getForObject(baseUrl + employeeID, EmployeeVO.class);
    if (employeeVO == null) {
      throw new EmployeeNotFoundException("Employee not found with ID: " + employeeID);
    }
    employeeVO.setDateOfBirth(EmployeeVO.decrypt(employeeVO.getDateOfBirth()));
    return employeeVO;
  }
}