package com.sunft.blog.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by sunft on 2018/4/21.
 * 用户类
 */
@Entity  // 实体
//@XmlRootElement // MediaType 转为 XML
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id  // 主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 自增长策略
    private Long id;//实体一个唯一标识


    @Column(nullable = false) // 映射为字段，值不能为空
    private String name;

    @Column(nullable = false)
    private int age;

    public User() {

    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
                "User[id=%d, name='%s', age='%d']",
                id, name, age);
    }
}
