package com.sylvie233.ytgz_management_system_api.security;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.util.StringUtils;
import com.sylvie233.ytgz_management_system_api.entity.UserAccount;
import com.sylvie233.ytgz_management_system_api.entity.UserRole;
import com.sylvie233.ytgz_management_system_api.mapper.UserAccountMapper;
import com.sylvie233.ytgz_management_system_api.mapper.UserRoleMapper;
import com.sylvie233.ytgz_management_system_api.security.SylvieUserDetails;
import com.sylvie233.ytgz_management_system_api.util.JwtTokenUtil;
import com.sylvie233.ytgz_management_system_api.util.Result;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserAccountMapper userAccountMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountMapper.getUserAccountByUsername(s);
        List<UserRole> userRoles = userRoleMapper.getUserRolesByUserAccountId(userAccount.getId());
        log.info(userRoles.toString());
        return new SylvieUserDetails(userAccount, userRoles);
    }

    public Result<String> login(String username, String password, HttpServletRequest request) {
        //登录
        UserDetails userDetails = loadUserByUsername(username);
        log.info("登录用户为："+ username);
        if (null==userDetails|| null == password|| !password.equals(userDetails.getPassword()))
            return Result.error("用户名或者密码不正确");
        if (!userDetails.isEnabled())
            return Result.error("账户被禁止使用，请联系管理员");
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        String token= jwtTokenUtil.generateToken(userDetails);
        Map<String,Object> map=new HashMap<>();
        map.put("token", jwtTokenUtil.getTokenHead() + " " + token);
        return Result.success("登录成功", JSON.toJSONString(map));
    }
}
