package com.example.bai10.config;

import com.example.bai10.interceptor.RoleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
  private final RoleInterceptor interceptor;
  public WebMvcConfig(RoleInterceptor interceptor) { this.interceptor = interceptor; }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(interceptor)
            .addPathPatterns("/admin/**","/user/**");
  }
}
