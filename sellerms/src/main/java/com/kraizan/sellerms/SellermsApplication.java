package com.kraizan.sellerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SellermsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellermsApplication.class, args);
	}

}
