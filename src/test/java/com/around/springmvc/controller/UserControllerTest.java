package com.around.springmvc.controller;

import com.around.springmvc.controller.UserController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception{
        mockMvc.perform(get("/test/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception{
        String userJson = "{\"username\":\"junha\", \"password\":\"1234\"}";
        mockMvc.perform(post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(userJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username", Matchers.is(equalTo("junha"))))
                .andExpect(jsonPath("$.password", Matchers.is(equalTo("1234"))));

    }

    @Test
    public void createUser_XML() throws Exception{
        String userJson = "{\"username\":\"junha\", \"password\":\"1234\"}";
        mockMvc.perform(post("/users/create")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_XML)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username")
                        .string("junha"))
                .andExpect(xpath("/User/password")
                        .string("1234"));
    }
}
