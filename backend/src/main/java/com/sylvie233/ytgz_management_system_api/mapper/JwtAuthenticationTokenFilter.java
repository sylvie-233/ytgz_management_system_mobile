package com.sylvie233.ytgz_management_system_api.mapper;

import com.sylvie233.ytgz_management_system_api.entity.User;
import com.sylvie233.ytgz_management_system_api.entity.UserAccount;
import com.sylvie233.ytgz_management_system_api.entity.UserRole;
import com.sylvie233.ytgz_management_system_api.mapper.UserAccountMapper;
import com.sylvie233.ytgz_management_system_api.mapper.UserRoleMapper;
import com.sylvie233.ytgz_management_system_api.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import sun.rmi.runtime.Log;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    UserAccountMapper userAccountMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("token");
        // 没有token
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);//放行,因为后面的会抛出相应的异常
            return;
        }

        // 非法token
        Long userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = Long.parseLong(claims.getSubject());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("非法token!");
        }


        UserAccount loginUser = userAccountMapper.getUserAccountById(userId);//获取用户信息
        List<UserRole> userRoles = userRoleMapper.getUserRolesByUserAccountId(userId);// 获取权限列表
        List<GrantedAuthority> grantedAuthorities = userRoles.stream().map((it) -> {
            return new SimpleGrantedAuthority(it.getRole());
        }).collect(Collectors.toList());

        // redis中用户不存在
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("用户不存在!");
        }

        // 将Authentication对象（用户信息、已认证状态、权限信息）存入 SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword(), grantedAuthorities);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
