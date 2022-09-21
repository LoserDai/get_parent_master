package com.df.controller;

import com.df.feign.SSOServiceFeign;
import com.df.pojo.User;
import com.df.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author feng.dai
 * @package com.df.controller
 * @project get_parent_master
 * @Date 2022/9/19 10:26
 */

@RestController
@RequestMapping("/frontend/sso")
public class UserController {

    @Autowired
    private SSOServiceFeign ssoServiceFeign;

    /**
     * 根据路径参数验证用户
     *
     * @param checkValue
     * @param checkFlag
     * @return
     */
    @RequestMapping("/")
    public Result checkUserInfo(@PathVariable String checkValue, @PathVariable Integer checkFlag) {
        Boolean checkInfo = ssoServiceFeign.checkUserInfo(checkValue, checkFlag);
        if (checkInfo) {
            return Result.ok();
        } else {
            return Result.error("校验失败!");
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/")
    public Result userRegister(User user) {
        int count = ssoServiceFeign.userRegister(user);
        if (count == 1){
            return Result.ok();
        }else {
            return Result.error("注册失败!");
        }
    }

    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping("/")
    public Result userLogin(String username, String pwd){
        Map map = ssoServiceFeign.userLogin(username, pwd);
        if (map.size() > 0){
            return Result.ok(map);
        }else {
            return Result.error("Login Error!");
        }
    }
}
