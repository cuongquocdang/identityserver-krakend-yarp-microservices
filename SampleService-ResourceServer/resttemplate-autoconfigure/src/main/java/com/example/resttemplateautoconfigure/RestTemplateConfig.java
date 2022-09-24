package com.example.resttemplateautoconfigure;

import lombok.RequiredArgsConstructor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.httpclient.LogbookHttpRequestInterceptor;
import org.zalando.logbook.httpclient.LogbookHttpResponseInterceptor;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateProperties restTemplateProperties;

    @Bean
    @Primary
    public RestTemplate restTemplate(Logbook logbook) {
        var connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(restTemplateProperties.getMaximumTotalPool());
        connectionManager.setDefaultMaxPerRoute(restTemplateProperties.getMaximumPerRoutePool());
        var requestConfig = RequestConfig
                .custom()
                .setConnectionRequestTimeout(restTemplateProperties.getConnectionRequestTimeout())
                .setSocketTimeout(restTemplateProperties.getSocketTimeout())
                .setConnectTimeout(restTemplateProperties.getConnectTimeout())
                .build();
        var httpClient = HttpClientBuilder.create()
                .addInterceptorFirst(new LogbookHttpRequestInterceptor(logbook))
                .addInterceptorFirst(new LogbookHttpResponseInterceptor())
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig).build();
        var requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        return new RestTemplate(requestFactory);
    }

}
