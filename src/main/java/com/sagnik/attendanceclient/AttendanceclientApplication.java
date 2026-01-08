package com.sagnik.attendanceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
public class AttendanceclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceclientApplication.class, args);
	}

}
