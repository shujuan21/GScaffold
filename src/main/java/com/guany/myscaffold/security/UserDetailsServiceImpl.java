package com.guany.myscaffold.security;

import com.guany.myscaffold.common.exception.CustomException;
import com.guany.myscaffold.entity.PermEntity;
import com.guany.myscaffold.entity.RoleEntity;
import com.guany.myscaffold.entity.UserEntity;
import com.guany.myscaffold.mapper.RolePermMapper;
import com.guany.myscaffold.mapper.UserMapper;
import com.guany.myscaffold.mapper.UserRoleMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: guany
 * @Date: 2023/04/17
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper;

    @Resource
    private RolePermMapper rolePermMapper;

    /**
     * 这里根据传进来的用户账号进行用户信息查询并构建
     * 这里没有进行用户认证，真正的验证是在UsernamePasswordAuthenticationFilter对象当中
     * UsernamePasswordAuthenticationFilter对象会自动根据前端传入的账号信息和UserDetails对象对比进行账号的验证
     * 通常情况下，已经满足常见的使用常见，不过如果有特殊需求，需要使用自己实现的具体认证方式，可以继承UsernamePasswordAuthenticationFilter对象
     * 重写attemptAuthentication 方法和successfulAuthentication方法
     * 最后在WebSecurityConfiguration里面添加自己的过滤器即可
     * @param username 用户账号
     * @return UserInfo
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //TODO 当前使用测试数据 ,不限制用户账号。密码设置123456就通过验证，并添加权限
        //根据username查询数据库对应的用户信息
        UserEntity user = userMapper.selectByUserName(username);
        if(user == null){
            throw new CustomException("用户不存在");
        }
        String password = user.getPassword();

        //TODO:获取已认证用户的相应权限
        //根据用户信息查询出用户权限信息  例如菜单添加权限  sys:menu:add
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<RoleEntity> roleList = userRoleMapper.selectRolesByUserId(user.getId());
        for(RoleEntity role:roleList){
            role.setRoleName("ROLE_"+role.getRoleName());
            authorities.add(role);
        }
        for(RoleEntity role: roleList){
            List<PermEntity> permList = rolePermMapper.selectPermsByRoleId(role.getId());
            authorities.addAll(permList);
        }
        //根据用户账号，密码，权限构建对应的UserDetails对象返回
        //SimpleGrantedAuthority authority = new SimpleGrantedAuthority("sys:menu:add");
        UserInfo userinfo =new UserInfo(username,password,authorities);
        userinfo.setUserId(user.getId());
        userinfo.setPhoneNumber(user.getPhoneNumber());
        return userinfo;
    }
}
