package perseverance.li.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderUsers7002Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderUsers7002Application.class, args);
	}

}
