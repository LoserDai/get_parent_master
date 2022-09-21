package com.df.controller;

import com.df.pojo.User;
import com.df.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author feng.dai
 * @package com.df.controller
 * @project get_parent_master
 * @Date 2022/9/20 14:36
 */
@RestController
@RequestMapping("/service/sso")
public class UserController {

    @Autowired
    private SSOService ssoService;

    @RequestMapping("/")
    public Boolean checkUserInfo(@PathVariable String checkValue, @PathVariable Integer checkFlag) {
        return ssoService.checkInfo(checkValue, checkFlag);
    }

    @RequestMapping("/")
    public int userRegister(User user){
        return ssoService.userRegister(user);
    }
    @RequestMapping("/")
    public Map userLogin(String username , String pwd){
        return ssoService.userLogin(username, pwd);
    }

}
