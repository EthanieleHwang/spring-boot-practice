package com.learning.myfirstwebapp.controller;

import com.learning.myfirstwebapp.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    //1.
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User userToCreate) {

        // 1.@RequestBody
        System.out.println("Received user via @RequestBody:" );
        System.out.println("Username: "+ userToCreate.getUsername());
        System.out.println("Email: "+ userToCreate.getEmail());
        System.out.println("Age: "+ userToCreate.getAge());

        //2.
        userToCreate.setId(System.currentTimeMillis() % 1000);
        return ResponseEntity.status(HttpStatus.CREATED).body(userToCreate);

    }

    //2.@RequestHeader 练习
    @GetMapping("/info-headers")
    public String getClientInfo(
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader(name = "Accept",defaultValue = "*/*") String acceptTYpe,
            @RequestHeader Map<String,String> allHeaders

            ){
        System.out.println("User-Agent: "+ userAgent);
        System.out.println("Client accepts: "+acceptTYpe);
        //打印部分头部信息，避免过多输出
        System.out.println("First few headers: ");
        allHeaders.entrySet().stream().limit(5).forEach(entry -> System.out.println(" " + entry.getKey() + "=" + entry.getValue()));
        return "Processed headers. User-Agent starts with: " + userAgent.substring(0,Math.min(userAgent.length(),20))+"...";
    }

    //3.@CookieValue练习
    @GetMapping("/info-cookies")
    public String getSessionInfo(
            @CookieValue(name="my-custom-cookie",required=false,defaultValue = "not_set") String customCookie,
            @CookieValue(name="JSESSIONID",required=false) String sessionId
    ){
        System.out.println("Custom Cookie 'my-custom-cookie':"+customCookie);
        System.out.println("Session ID Cookie 'JSESSIONID':"+(sessionId != null? sessionId:"not set"));
        return "Processed cookies. Custom cookie value:"+customCookie;
    }

    //4.简单表单对象绑定练习
    @GetMapping("/profile")
    public User getUserProfile(User user){
        System.out.println("Received user profile via object binding:");
        System.out.println("Username: "+user.getUsername());
        System.out.println("Email(might be null):"+user.getEmail());
        System.out.println("Age:"+user.getAge());

        //模拟返回用户信息
        if(user.getId() == null) user.setId(1L); //给个默认 ID
        return user;
    }
    
}
