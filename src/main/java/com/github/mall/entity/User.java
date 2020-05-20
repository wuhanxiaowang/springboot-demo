package com.github.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private Integer age;

    private String name;

    private Integer phone;

    private Date dateTime;

    private BigDecimal salary;

    private Integer sex;

    private String password;

    private String email;

    private String address;

    private Set<Role> roles;

    public User(Integer id, String name, String password, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = roles;
    }
}