package com.sylvie233.ytgz_management_system_api.mapper;

import com.sylvie233.ytgz_management_system_api.entity.UserAccount;
import com.sylvie233.ytgz_management_system_api.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserAccountMapper userAccountMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountMapper.getUserAccountByUsername(s);
        List<UserRole> userRoles = userRoleMapper.getUserRolesByUserAccountId(userAccount.getId());
        return new SylvieUserDetails(userAccount, userRoles);
    }
}
