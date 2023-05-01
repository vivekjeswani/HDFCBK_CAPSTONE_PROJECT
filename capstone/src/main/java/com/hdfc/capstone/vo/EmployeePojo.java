package com.hdfc.capstone.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeePojo {
    @JsonProperty("employeeId")
    private String employeeId;
    
    @JsonProperty("employeeName")
    private String employeeName;
    
    @JsonProperty("encrypted Date of Birth")
    private String encryptedDateOfBirth;
    
    public EmployeePojo(String employeeId, String employeeName, String encryptedDateOfBirth) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.encryptedDateOfBirth = encryptedDateOfBirth;
    }
    
    // getters and setters omitted for brevity
}
