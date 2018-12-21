package com.demo.service.serviceImp;

import com.demo.dao.RoleMapper;
import com.demo.dao.UserMapper;
import com.demo.dao.UserRoleMapper;
import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class CustomUserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserServiceImp userServiceImp;

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRoleMapper userRoleMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        //从数据库中取出用户信息
        User u = new User();

        User user = userMapper.selectByName(name);
        if(user == null ){
            throw  new UsernameNotFoundException("用户名不存在");
        }
        //添加权限
        List<UserRole> usersList = userRoleMapper.listByUserId(user.getId());
        for (UserRole list : usersList) {
            Role role = roleMapper.selectByPrimaryKey(list.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}
