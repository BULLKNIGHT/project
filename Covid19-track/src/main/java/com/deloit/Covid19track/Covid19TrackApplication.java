package com.deloit.Covid19track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Covid19TrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19TrackApplication.class, args);
	}

}
