package com.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_user_role")
public class UserRole {

    private String id;

    private String roleId;

    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}