package com.sylvie233.ytgz_management_system_api.security;

import com.alibaba.fastjson.JSON;
import com.sylvie233.ytgz_management_system_api.util.Result;
import com.sylvie233.ytgz_management_system_api.util.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result<String> result = new Result<String>("403", "您的权限不足！", "登录失败");
        String json = JSON.toJSONString(result);
        // 将字符串渲染到客户端
        WebUtils.renderString(response, json);
    }
}
