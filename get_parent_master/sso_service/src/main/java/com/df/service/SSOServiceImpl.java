package com.df.service;

import com.df.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author feng.dai
 * @package com.df.service
 * @project get_parent_master
 * @Date 2022/9/20 14:38
 */
@Service
@Transactional
public class SSOServiceImpl implements SSOService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean checkInfo(String checkValue, Integer checkFlag) {
        return userMapper.checkInfo(checkValue,checkFlag);
    }
}
