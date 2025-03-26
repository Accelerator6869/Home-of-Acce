package com.zyf.sb_zyf.pojo.DTO.request;

import jakarta.validation.constraints.*;
import org.springframework.lang.NonNull;

public class PasswordChangeRequest {
    @NotBlank(message = "当前密码不能为空")
    private String currentPassword;

    @NotBlank(message = "新密码不能为空")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",
            message = "密码需至少8位，包含字母、数字和特殊字符")
    private String newPassword;

    @NotBlank(message = "确认密码不能为空")
    private String confirmPassword;


    // 验证逻辑（方法名必须以 `is` 开头）
    @AssertTrue(message = "密码和确认密码不一致")
    public boolean isPasswordMatch() {
        return newPassword != null && newPassword.equals(confirmPassword);
    }
}
