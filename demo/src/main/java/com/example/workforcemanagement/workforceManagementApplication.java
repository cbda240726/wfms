package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.treansaction.annoatation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class WorkforceManagementApplicaiton {

    public static void main(String[] args) {
        SpringApplication.run(WorkforceManagementApplicaiton.class, args);
    }

}

