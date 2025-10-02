package com.example.bai10.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;

@Component
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {
  @Override
  public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
                                      Authentication auth) throws IOException {
    boolean isAdmin = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).anyMatch("ROLE_ADMIN"::equals);
    boolean isUser = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).anyMatch("ROLE_USER"::equals);

    if (isAdmin) { res.sendRedirect("/admin"); return; }
    if (isUser)  { res.sendRedirect("/user");  return; }
    res.sendRedirect("/login?forbidden");
  }
}
