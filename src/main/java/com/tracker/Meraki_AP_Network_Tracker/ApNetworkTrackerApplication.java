package com.tracker.Meraki_AP_Network_Tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tracker")
@EnableJpaRepositories(basePackages = "com.tracker.repositories")
@EntityScan(basePackages = "com.tracker.entities")
public class ApNetworkTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApNetworkTrackerApplication.class, args);
	}
}
