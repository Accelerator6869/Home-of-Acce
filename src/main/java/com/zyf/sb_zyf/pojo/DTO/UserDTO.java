package com.zyf.sb_zyf.pojo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

//隐藏敏感字段
//DTO：数据传输对象
//POJO：简单java对象
public class UserDTO {

    private String userName;
    private String email;
    private LocalDateTime createTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    protected void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "createTime=" + createTime +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
