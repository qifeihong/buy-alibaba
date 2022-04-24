package com.sale.buyalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sale.*"})
public class BuyAlibabaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyAlibabaApplication.class, args);
	}

}
