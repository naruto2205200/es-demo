package com.example.esdemo.demo;

import com.example.esdemo.config.ESClient;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxiaofeng
 * @Describetion
 * @date 2019/10/2315:00
 */
public class demo01 {


    public static void main(String[] args) throws IOException {


        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.86.155", 9200, "http")));
        IndexRequest request = new IndexRequest("posts2");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"zk\"," +
                "\"postDate\":\"2019-10-23\"," +
                "\"message\":\"trying out java\"" +
                "}";
        //为什么这里要有个jsonString2 ,因为这个request.source(jsonString, jsonString2);
        // 的参数数量必须是偶数, 不然会报错的.
        request.source(jsonString, XContentType.JSON);



        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", new Date());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest indexRequest = new IndexRequest("posts3")
                .id("1").source(jsonMap);


        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());



        client.close();
    }
}
