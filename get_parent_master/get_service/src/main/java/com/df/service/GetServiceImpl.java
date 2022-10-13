package com.df.service;

import com.df.mapper.UserMapper;
import com.df.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2022/10/8 8:47
 * @Project_Name get_parent_master
 * @Package_Name com.df.service
 */
@Service
@Transactional
public class GetServiceImpl implements GetService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID获取所有用户信息
     * @param id
     * @return
     */
    @Override
    public List<User> getAll(Long id) {
        List<User> userList = userMapper.getAll(id);
        return userList;
    }
}
