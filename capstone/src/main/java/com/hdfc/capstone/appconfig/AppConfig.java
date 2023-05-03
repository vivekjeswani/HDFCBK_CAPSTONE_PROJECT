package com.hdfc.capstone.appconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hdfc.capstone.vo.EmployeeVO;

@Configuration
public class AppConfig {

    @Bean
    public EmployeeVO employeeVO() {
        return new EmployeeVO();
    }

    // Other bean definitions can be added here
}