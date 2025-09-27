package com.example.Bai9.config;

import org.springframework.context.annotation.*;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
@Bean
public CorsFilter corsFilter(){
var source = new UrlBasedCorsConfigurationSource();
var cfg = new CorsConfiguration();
cfg.addAllowedOriginPattern("*");
cfg.addAllowedHeader("*");
cfg.addAllowedMethod("*");
source.registerCorsConfiguration("/**", cfg);
return new CorsFilter(source);
}
}
