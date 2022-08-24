package com.myunica.first.config;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ClientHttpRequestFactorySupplier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.KeyStore;

@Configuration
public class RestTemplateConfig {
    @Value("${key-store-password}")
    private String keyStorePassword;
    @Value("${key-store}")
    private String keyStore;
    @Value("${server-username}")
    private String username;
    @Value("${server-password}")
    private String password;


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(Constants.USERNAME, username)
                .defaultHeader(Constants.PASSWORD, password)
                .requestFactory(new ClientHttpRequestFactorySupplier())
                .build();
    }

    @Bean
    public HttpComponentsClientHttpRequestFactory restTemplateFactory() {
        SSLContext sslContext = buildSslContext();
        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        HttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    private SSLContext buildSslContext() {
        try {
            char[] keyStorePassword = this.keyStorePassword.toCharArray();
            return new SSLContextBuilder()
                    .loadKeyMaterial(
                            KeyStore.getInstance(new File(keyStore), keyStorePassword),
                            keyStorePassword
                    ).build();
        } catch (Exception ex) {
            throw new IllegalStateException("Unable to instantiate SSL context", ex);
        }
    }
}
