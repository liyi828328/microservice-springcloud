package perseverance.li.consumer.feign.config;

import feign.Feign;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-27 16:42
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-27 16:42 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkhttpConfig {

    @Autowired
    private OkhttpConfig okhttpConfig;

    @Bean
    public OkHttpClient okHttpClient() {
        ConnectionPool pool = new ConnectionPool(okhttpConfig.getMaxIdleConnections(),
                okhttpConfig.getKeepAliveDuration(), TimeUnit.SECONDS);
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(okhttpConfig.getReadTimeout(), TimeUnit.SECONDS)
                .writeTimeout(okhttpConfig.getWriteTimeout(), TimeUnit.SECONDS)
                .connectTimeout(okhttpConfig.getConnectionTimeout(), TimeUnit.SECONDS)
                .connectionPool(pool)
                .build();
        return client;
    }
}
