package perseverance.li.consumer.feign.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ---------------------------------------------------------------
 * Author: perseverance_li
 * Email: perseverance_li@126.com
 * Create: 2019-11-27 16:40
 * ---------------------------------------------------------------
 * Describe:
 * ---------------------------------------------------------------
 * Changes:
 * ---------------------------------------------------------------
 * 2019-11-27 16:40 : Create by perseverance_li
 * ---------------------------------------------------------------
 */
@Component
@ConfigurationProperties(prefix = "okhttp")
public class OkhttpConfig {
    /**
     * 读取超时时间,单位秒
     */
    private int readTimeout;
    /**
     * 写超时,单位秒
     */
    private int writeTimeout;
    /**
     * 连接超时,单位秒
     */
    private int connectionTimeout;
    /**
     * 线程池最大空闲数
     */
    private int maxIdleConnections;
    /**
     * 每个线程最大空闲时间,单位秒
     */
    private int keepAliveDuration;

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public int getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(int writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getMaxIdleConnections() {
        return maxIdleConnections;
    }

    public void setMaxIdleConnections(int maxIdleConnections) {
        this.maxIdleConnections = maxIdleConnections;
    }

    public int getKeepAliveDuration() {
        return keepAliveDuration;
    }

    public void setKeepAliveDuration(int keepAliveDuration) {
        this.keepAliveDuration = keepAliveDuration;
    }

    @Override
    public String toString() {
        return "OkhttpConfig{" +
                "readTimeout=" + readTimeout +
                ", writeTimeout=" + writeTimeout +
                ", connectionTimeout=" + connectionTimeout +
                ", maxIdleConnections=" + maxIdleConnections +
                ", keepAliveDuration=" + keepAliveDuration +
                '}';
    }
}
