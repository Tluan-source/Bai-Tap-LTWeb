package com.example.bai10.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RoleInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
    String uri = req.getRequestURI();
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    if (auth == null || auth instanceof AnonymousAuthenticationToken) return true;

    boolean hasAdmin = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).anyMatch("ROLE_ADMIN"::equals);
    boolean hasUser = auth.getAuthorities().stream()
        .map(GrantedAuthority::getAuthority).anyMatch("ROLE_USER"::equals);

    if (uri.startsWith("/admin") && !hasAdmin) { res.sendRedirect("/login?forbidden"); return false; }
    if (uri.startsWith("/user")  && !hasUser)  { res.sendRedirect("/login?forbidden"); return false; }
    return true;
  }
}
