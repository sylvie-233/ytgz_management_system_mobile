package com.sylvie233.ytgz_management_system_api.security;

import com.sylvie233.ytgz_management_system_api.util.JwtTokenUtil;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Log
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String authHeader=request.getHeader(tokenHeader);
        log.info(authHeader);
        //存在token
        if (null != authHeader && authHeader.startsWith(tokenHead)) {
            String authToken=authHeader.substring(tokenHead.length() + 1);
            log.info(authToken);
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            log.info("token中解析到的用户名为："+username);
            //token存在但是未登录
            if (null!=username&&null==SecurityContextHolder.getContext().getAuthentication())
            {
                //登录
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                log.info(userDetails.toString());
                //判断token是否有效
                if (jwtTokenUtil.validateToken(authToken,userDetails))
                {
                    UsernamePasswordAuthenticationToken authenticationToken=
                            new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        chain.doFilter(request,response);
    }
}