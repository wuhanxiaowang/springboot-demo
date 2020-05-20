package com.github.mall.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permissions implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String permissionsname;

    public Permissions(Integer id, String permissionsname) {
        this.id = id;
        this.permissionsname = permissionsname;
    }
}