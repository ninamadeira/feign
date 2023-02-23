package br.com.madeira.apifeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApifeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApifeignApplication.class, args);
	}

}
