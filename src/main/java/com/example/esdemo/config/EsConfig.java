package com.example.esdemo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author zhangxiaofeng
 * @Describetion: es配置信息
 * @date 2019/11/2116:05
 */
@Component
@PropertySource("classpath:es-config.properties")
@Data
public class EsConfig {
    @Value("${es.cluster.name}")
    private String clusterName;
    @Value("${es.host.ip}")
    private String ip;
    @Value("${es.host.post}")
    private int port;
}
