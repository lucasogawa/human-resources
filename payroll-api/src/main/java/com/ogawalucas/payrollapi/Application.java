package com.ogawalucas.payrollapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@RibbonClient("worker-api")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
