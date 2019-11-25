package perseverance.li.consumer.books.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ---------------------------------------------------------------
 * Author: LiYi
 * Email: yi.li@yulore.com
 * Create: 2019-11-22 14:38
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 14:38 : Create by LiYi
 * ---------------------------------------------------------------
 */
@Configuration
public class ConsumerConfig {

    @Bean
    @LoadBalanced //TODO:集群情况下需要加负载
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
