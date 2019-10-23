package com.example.esdemo.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/10/2317:06
 */
@Configuration
public class ESClient {

    @Value("spring.elasticsearch.rest.uris")
    private static String url;

    private static RestHighLevelClient restHighLevelClient;

    static{
        init();
    }
    private static void init(){
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(url)));
    }

    public RestHighLevelClient getRestHighLevelClient(){
        return restHighLevelClient;
    }
}
