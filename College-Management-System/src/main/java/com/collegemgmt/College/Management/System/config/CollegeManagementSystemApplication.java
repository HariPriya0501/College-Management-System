package com.collegemgmt.College.Management.System.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.collegemgmt.College.Management.System")
@EnableJpaRepositories(basePackages = "com.collegemgmt.College.Management.System.repository")
@EntityScan(basePackages = "com.collegemgmt.College.Management.System.model")
public class CollegeManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeManagementSystemApplication.class, args);
    }
}
