package exarb.fmgamificationlogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FmgamificationlogicApplication {

	public static void main(String[] args) {
		SpringApplication.run(FmgamificationlogicApplication.class, args);
	}

}
