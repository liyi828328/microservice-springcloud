package perseverance.li.consumer.books.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-22 14:38
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-22 14:38 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Configuration
public class ConsumerConfig {

    @Bean
    @LoadBalanced //TODO:集群情况下需要加客户端负载
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 切花负载算法
     * 默认无轮训算法 RoundRobinRule
     *
     * @return
     */
    @Bean
    public IRule changeRule() {
        return new RandomRule();
    }
}
