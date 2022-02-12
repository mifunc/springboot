package com.rumenz.lession50.controller.config;

import com.rumenz.lession50.controller.util.JWTUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(getRoles(username));
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        Map<String, Object> userInfo = getUserInfo(username);

        if (userInfo == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (! JWTUtil.verify(token, username, userInfo.get("password").toString())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

    /**
     * 模拟数据库查询，通过用户名获取用户信息
     *
     * @param username
     * @return
     */
    private Map<String, Object> getUserInfo(String username) {
        Map<String, Object> userInfo = null;
        if ("rumenz".equals(username)) {
            userInfo = new HashMap<>();
            userInfo.put("username", "rumenz");

            //加密算法，原密码，盐值，加密次数
            userInfo.put("password", "123456");
        }
        return userInfo;
    }

    /**
     * 模拟查询数据库，获取用户角色列表
     *
     * @param username
     * @return
     */
    private Set<String> getRoles(String username) {
        Set<String> roles = new HashSet<>();
        roles.add("user");
        roles.add("admin");
        return roles;
    }
}
