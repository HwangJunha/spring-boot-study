package com.around.springmvc.controller;

import com.around.springmvc.model.vo.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/test/hello")
    public String hello(){ //@ResponseBody가 생략되어 있다 RestController일떄
                            //@Controller를 사용할때는 @ResponseBody을 붙여줘야 한다
                            //MessageConvert를 탄다
        return "hello";
    }
    @PostMapping("/user")
    public @ResponseBody User create(@RequestBody User user){
        return null;
    }
    @PostMapping("/users/create")
    public User createJson(@RequestBody User user){
        return user;
    }
}
