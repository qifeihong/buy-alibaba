package com.sale.buyalibaba;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableApolloConfig
@SpringBootApplication
@MapperScan("com.sale.buyalibaba.mapper")
@ComponentScan(basePackages = {"com.sale.*"})
public class BuyAlibabaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyAlibabaApplication.class, args);
	}

}
