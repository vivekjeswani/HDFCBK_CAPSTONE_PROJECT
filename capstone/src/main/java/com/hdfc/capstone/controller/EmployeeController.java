package com.hdfc.capstone.controller;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.capstone.vo.EmployeePojo;
import com.hdfc.capstone.vo.EmployeeVO;


@RestController
public class EmployeeController {

    @GetMapping("/get/{employeeId}")
    public EmployeePojo getEmployee(@PathVariable long employeeId) {
        EmployeeVO obj2 = new EmployeeVO().getEmployeeById(employeeId);
        return new EmployeePojo(obj2.getEmployeeId(), obj2.getEmployeeName(), obj2.getDateOfBirth());
    }

    @RequestMapping(value = "/get/{employeeId}", method = RequestMethod.OPTIONS)
    public ResponseEntity<?> getEmployeeOptions() {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET, HttpMethod.OPTIONS)
                .build();
    }
}