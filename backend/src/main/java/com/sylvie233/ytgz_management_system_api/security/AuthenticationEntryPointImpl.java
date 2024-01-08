package com.sylvie233.ytgz_management_system_api.security;

import com.alibaba.fastjson.JSON;
import com.sylvie233.ytgz_management_system_api.util.Result;
import com.sylvie233.ytgz_management_system_api.util.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result<String> result = new Result<String>("401", "认证失败，请重新登录！", "登录失败");
        String json = JSON.toJSONString(result);
        // 将字符串渲染到客户端
        WebUtils.renderString(response, json);
    }
}