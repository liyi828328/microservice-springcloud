package perseverance.li.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import perseverance.li.rules.BookRule;
import perseverance.li.rules.UserRule;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 17:39
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 17:39 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@RibbonClient(name = "PROVIDER-USERS",configuration = UserRule.class)
public class UserServiceConfig {
}
