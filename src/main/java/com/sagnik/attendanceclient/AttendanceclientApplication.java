package com.sagnik.attendanceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AttendanceclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AttendanceclientApplication.class, args);
	}

}
