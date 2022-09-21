package com.df.feign;

import com.df.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @Author feng.dai
 * @package com.df.feign
 * @project get_parent_master
 * @Date 2022/9/19 10:31
 */
@FeignClient("df-sso-service")
public interface SSOServiceFeign {
    /**
     *验证用户
     * @param checkValue
     * @param checkFlag
     * @return
     */
    @RequestMapping("/")
    Boolean checkUserInfo(@PathVariable String checkValue, Integer checkFlag);

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/")
    int userRegister(User user);

    /**
     * 登录
     * @param username
     * @param pwd
     * @return
     */
    @RequestMapping("/")
    Map userLogin(String username, String pwd);
}
