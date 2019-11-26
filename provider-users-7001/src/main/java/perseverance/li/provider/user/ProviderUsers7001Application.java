package perseverance.li.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUsers7001Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUsers7001Application.class, args);
	}

}
