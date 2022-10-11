package com.df.service;

import com.df.pojo.User;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2022/10/8 8:47
 * @Project_Name get_parent_master
 * @Package_Name com.df.service
 */
public interface GetService {
    List<User> getAll(Long id);
}
