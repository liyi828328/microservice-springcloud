package perseverance.li.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import perseverance.li.rules.BookRule;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-26 17:38
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-26 17:38 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@RibbonClient(name = "PROVIDER-BOOKS",configuration = BookRule.class)
public class BookServiceConfig {
}
