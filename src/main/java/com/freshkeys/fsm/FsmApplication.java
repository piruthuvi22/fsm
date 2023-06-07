package com.freshkeys.fsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FsmApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsmApplication.class, args);
		System.out.println("SERVER RUNNING ON PORT 8080");
	}

}
