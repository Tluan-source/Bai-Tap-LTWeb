package com.example.bai10.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final RoleBasedSuccessHandler successHandler;

  public SecurityConfig(RoleBasedSuccessHandler successHandler) {
    this.successHandler = successHandler;
  }

  @Bean
  public UserDetailsService userDetailsService() {
    var user = User.withUsername("user").password("{noop}123").roles("USER").build();
    var admin = User.withUsername("admin").password("{noop}123").roles("ADMIN").build();
    return new InMemoryUserDetailsManager(user, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
          .requestMatchers("/css/**","/js/**","/images/**").permitAll()
          .requestMatchers("/admin/**").hasRole("ADMIN")
          .requestMatchers("/user/**").hasRole("USER")
          .anyRequest().authenticated()
        )
        .formLogin(form -> form
          .loginPage("/login").permitAll()
          .successHandler(successHandler)
          .failureUrl("/login?error")
        )
        .logout(logout -> logout.logoutSuccessUrl("/login?logout"));

    return http.build();
  }
}
