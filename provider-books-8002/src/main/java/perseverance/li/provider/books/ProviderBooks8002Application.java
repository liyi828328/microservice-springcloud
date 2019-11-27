package perseverance.li.provider.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderBooks8002Application {

    public static void main(String[] args) {
        SpringApplication.run(ProviderBooks8002Application.class, args);
    }

}
