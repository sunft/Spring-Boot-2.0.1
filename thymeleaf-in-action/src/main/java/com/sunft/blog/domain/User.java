package com.sunft.blog.domain;

/**
 * Created by sunft on 2018/4/21.
 * 用户类
 */
public class User {

    private Long id;//实体一个唯一标识
    private String name;
    private int age;

    public User() {

    }

    public User(Long id, String name, int age) {
        this.id = id;
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

}
