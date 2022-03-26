package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"tn.esprit.spring.service.Interface"})
//@EnableSwagger2
public class ProjetPiMicroAssuranceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetPiMicroAssuranceApplication.class, args);
	}

}
