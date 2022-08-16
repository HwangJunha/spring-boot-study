package com.around.springmvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc //전부 사라지고 처음부터 다시 설정해줘야 한다
public class WebConfig implements WebMvcConfigurer {
}
