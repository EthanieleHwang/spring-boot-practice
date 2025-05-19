package com.learning.myfirstwebapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    @NotBlank(message="用户名不能为空或纯空格！")
    @Size(min=3,max=20,message="用户名长度必须在{min}到{max}之间！")
    private String username;
    @NotEmpty(message = "邮箱不能为空！")
    @Email(message = "邮箱格式不正确！")
    private String email;

    @NotNull(message = "年龄不能为空！")
    @Min(value=18,message = "年龄必须大于等于{value}！")
    @Max(value=100,message = "年龄必须小于等于{value}！")
    private Integer age;

    @Pattern(regexp = "^(13|14|15|16|17|18|19)\\d{9}$", message = "手机号码格式不正确！")
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdAt= new Date();
    //假设有一个自定义校验逻辑，通过getter方法和@AssertTrue
    private boolean termsAccepted;
    @AssertTrue(message = "必须同意用户条款才能注册！")
    public boolean isTermsAccepted() {
        return termsAccepted;
    }

}
