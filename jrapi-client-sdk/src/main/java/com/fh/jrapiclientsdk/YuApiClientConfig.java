package com.fh.jrapiclientsdk;

import com.fh.jrapiclientsdk.client.JrApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * YuApi 客户端配置
 *
 */
@Configuration
@ConfigurationProperties("yuapi.client")
@Data
@ComponentScan
public class YuApiClientConfig {

    private String accessKey;

    private String secretKey;

    @Bean
    public JrApiClient yuApiClient() {
        return new JrApiClient(accessKey, secretKey);
    }

}
