package perseverance.li.rules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 17:40
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 17:40 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Configuration
public class UserRule {

    @Bean
    public IRule myUserRule() {
        return new RandomRule();
    }
}
