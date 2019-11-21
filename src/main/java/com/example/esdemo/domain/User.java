package com.example.esdemo.domain;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phone;
    private String beanName;
    private Integer id;
    private Integer age;
    private String headPortrait;
    private Byte isGroup;
}
