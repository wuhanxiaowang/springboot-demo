package com.github.mall.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;

    private String rolename;

    private Set<Permissions> permissions;

    public Role(Integer id, String rolename, Set<Permissions> permissions) {
        this.id = id;
        this.rolename = rolename;
        this.permissions = permissions;
    }
}