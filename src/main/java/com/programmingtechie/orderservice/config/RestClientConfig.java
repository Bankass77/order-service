package com.programmingtechie.orderservice.config;

import com.programmingtechie.orderservice.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.time.Duration;

@Configuration
public class RestClientConfig {

    @Value(("${inventory.url}"))
    private String inventoryUrl;

    @Bean
    public InventoryClient inventoryClient() {

        RestClient restClient = RestClient.builder().baseUrl(inventoryUrl).requestFactory(getRequestFactory()).build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpSeviceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpSeviceProxyFactory.createClient(InventoryClient.class);
    }

    /**
     *
     * @return ClientHttpResquestfactory
     */
    private ClientHttpRequestFactory getRequestFactory() {
        ClientHttpRequestFactorySettings clientHttpRequestFactorySettings = ClientHttpRequestFactorySettings.DEFAULTS.withConnectTimeout(Duration.ofSeconds(3))
                .withReadTimeout(Duration.ofSeconds(3));
        return ClientHttpRequestFactories.get(clientHttpRequestFactorySettings);
    }

}
