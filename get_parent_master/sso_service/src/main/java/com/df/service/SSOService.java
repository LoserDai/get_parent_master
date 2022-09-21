package com.df.service;

import com.df.pojo.User;

import java.util.Map;

/**
 * @Author feng.dai
 * @package com.df.service
 * @project get_parent_master
 * @Date 2022/9/20 14:37
 */
public interface SSOService {

    Boolean checkInfo(String checkValue, Integer checkFlag);

    int userRegister(User user);

    Map userLogin(String username, String pwd);
}
