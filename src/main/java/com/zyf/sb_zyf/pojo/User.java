package com.zyf.sb_zyf.pojo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;
import java.util.*;

@Table(name = "tb_user")
@Entity
public class User {

    // 主键，用户id
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    // 用户名
    @NonNull
    @Column(name = "user_name")
    private String userName;

    // 用户密码
    @Column(name = "user_password")
    private String userPassword;

    // 邮箱
    @Column(name = "email")
    private String email;

    // 创建时间
    @Column(name="create_time", updatable = false, insertable = false)
    @CreatedDate
    private LocalDateTime createTime;

    /*
    setter和getter方法
     */


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // 获取用户名
    public String getUserName() {
        return userName;
    }

    // 设置用户名
    public void setUserName(@NotBlank(message = "用户名不能为空") @Size(min = 4, max = 20, message = "用户名长度4-20位")String userName) {
        this.userName = userName;
    }

    //获取用户密码
    public String getUserPassword() {
        return userPassword;
    }

    //设置用户密码
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    //获取邮箱
    public String getEmail() {
        return email;
    }

    //设置邮箱
    public void setEmail(String email) {
        this.email = email;
    }

    //获取创建时间
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    //设置创建时间
    protected void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    //-- 重点：防御性检查写在实体类内部 --
    @PreUpdate
    protected void preventRegisterTimeUpdate() {
        // 实际逻辑应为：如果当前值与原值不同，则抛出异常
        // 此处简化示例，实际应根据数据库原始值判断
        if (this.createTime != null) {
            throw new IllegalStateException("注册时间不可修改");
        }
    }

}
