package com.law.lawonline.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

//http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-nosql.html#boot-features-connecting-to-elasticsearch-spring-data
//https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-elasticsearch/src/main/java/sample/data/elasticsearch
//http://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#elasticsearch.repositories
//http://geekabyte.blogspot.my/2015/08/embedding-elasticsearch-in-spring.html
//https://github.com/spring-projects/spring-data-elasticsearch/wiki/Spring-Data-Elasticsearch---Spring-Boot---version-matrix
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.law.lawonline.elasticsearch.repository")
public class EsConfig {

    //    @Value("${elasticsearch.host}")
    private String EsHost = "localhost";

    //    @Value("${elasticsearch.port}")
    private int EsPort = 9300;

    //    @Value("${elasticsearch.clustername}")
    private String EsClusterName = "mkyong-cluster";

    @Bean
    public Client client() throws Exception {

        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", EsClusterName)
                .build();

        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchTemplate(client());
    }
}