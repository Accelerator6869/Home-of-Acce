package com.zyf.sb_zyf.pojo.DTO.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {

    @NotBlank(message = "用户名不能为空")
    @Size(min = 4, max = 20, message = "用户名长度4-20位")
    private String username;


    @NotBlank(message = "密码不能为空")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "密码需8-20位，包含大写字母、数字和特殊符号"
    )
    private String password;

    @NotBlank(message = "确认密码不能为空")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "密码需8-20位，包含大写字母、数字和特殊符号"
    )
    private String confirmPassword;

    // 验证逻辑（方法名必须以 `is` 开头）
    @AssertTrue(message = "密码和确认密码不一致")
    public boolean isPasswordMatch() {
        return password != null && password.equals(confirmPassword);
    }

    // 其他字段及 Getter/Setter...

    //获取用户名
    public @NotBlank(message = "用户名不能为空") @Size(min = 4, max = 20, message = "用户名长度4-20位") String getUsername() {
        return username;
    }

    //设置用户名
    public void setUsername(@NotBlank(message = "用户名不能为空") @Size(min = 4, max = 20, message = "用户名长度4-20位") String username) {
        this.username = username;
    }

    //获取密码
    public @NotBlank(message = "密码不能为空") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "密码需8-20位，包含大写字母、数字和特殊符号"
    ) String getPassword() {
        return password;
    }

    //设置密码
    public void setUserPassword(@NotBlank(message = "密码不能为空") @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "密码需8-20位，包含大写字母、数字和特殊符号"
    ) String password) {
        this.password = password;
    }
}

