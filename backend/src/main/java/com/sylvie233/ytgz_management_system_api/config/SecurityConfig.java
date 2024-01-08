package com.sylvie233.ytgz_management_system_api.config;


import com.sylvie233.ytgz_management_system_api.mapper.JwtAuthenticationTokenFilter;
import com.sylvie233.ytgz_management_system_api.security.AccessDeniedHandlerImpl;
import com.sylvie233.ytgz_management_system_api.security.AuthenticationEntryPointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启@PreAuthorize()注解权限功能
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    // 认证失败处理器
    @Autowired
    private AuthenticationEntryPointImpl authenticationEntryPoint;

    // 授权失败处理器
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭csrf
            .cors().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //不通过session获取SecurityContext
            .and()
            .authorizeRequests()
            .antMatchers("/dologin").anonymous() //对于登录接口允许匿名访问
            .anyRequest().authenticated(); //除上面外的所有请求全部需要鉴权认证


        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.exceptionHandling()
            .authenticationEntryPoint(authenticationEntryPoint) // 认证失败处理
            .accessDeniedHandler(accessDeniedHandler); // 授权失败
    }
}
