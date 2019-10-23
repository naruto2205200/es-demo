package com.example.esdemo.demo;

import com.example.esdemo.config.ESClient;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import java.io.IOException;

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
        IndexRequest request = new IndexRequest("posts");
        request.id("1");
        String jsonString = "{" +
                "\"user\":\"zk\"," +
                "\"postDate\":\"2019-01-30\"," +
                "\"message\":\"trying out java\"" +
                "}";
        String jsonString2 = "{" +
                "\"user\":\"zk2\"," +
                "\"postDate\":\"2019-10-01\"," +
                "\"message\":\"trying out javascript\"" +
                "}";
        //为什么这里要有个jsonString2 ,因为这个request.source(jsonString, jsonString2);
        // 的参数数量必须是偶数, 不然会报错的.
        request.source(jsonString, jsonString2);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.getResult());



        client.close();
    }
}
