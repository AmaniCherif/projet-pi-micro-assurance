package tn.esprit.spring;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication

//@ComponentScan(basePackages = {"tn.esprit.spring.service.Interface"})
//@EnableSwagger2
@EnableScheduling
public class ProjetPiMicroAssuranceApplication {
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args)   {
		

		SpringApplication.run(ProjetPiMicroAssuranceApplication.class, args);

}
}
