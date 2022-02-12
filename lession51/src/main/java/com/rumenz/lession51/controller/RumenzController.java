package com.rumenz.lession50.controller;

import com.rumenz.lession50.controller.util.JWTUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: RumenzController
 * @description: TODO 类描述
 * @author: 入门小站 rumenz.com
 * @date: 2022/2/10
 **/
@RestController
@RequestMapping("/user")
public class RumenzController {

    @GetMapping("/login")
    public Map login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {
        Map<String, String> userInfo = getUserInfo(username);
        if (userInfo.get("password").equals(password)) {
            Map m=new HashMap();
            m.put("token",JWTUtil.sign(username, password));
            return m;
        } else {
            throw new UnauthorizedException();
        }
    }
    private Map<String, String> getUserInfo(String username) {
        Map<String, String> userInfo = null;
        if ("rumenz".equals(username)) {
            userInfo = new HashMap<>();
            userInfo.put("username", "rumenz");

            //加密算法，原密码，盐值，加密次数
            userInfo.put("password", "123456");
        }
        return userInfo;
    }
    @RequestMapping("/list")
    @RequiresAuthentication
    public String userList() {
        return "访问我需要登录并且需要拥有user角色！";
    }

    @RequiresPermissions(logical = Logical.AND, value = {"add"})
    @RequestMapping("/add")
    @RequiresAuthentication
    public String add() {
        return "添加用户";
    }

}
