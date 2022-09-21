package com.df.service;

import com.df.config.RedisClient;
import com.df.mapper.UserMapper;
import com.df.pojo.User;
import com.df.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Autowired
    private RedisClient redisClient;

    @Value("${USER_INFO}")
    private String USER_INFO;

    @Value("${SESSION_EXPIRE}")
    private Long SESSION_EXPIRE;


    @Override
    public Boolean checkInfo(String checkValue, Integer checkFlag) {
        return userMapper.checkInfo(checkValue,checkFlag);
    }

    @Override
    public int userRegister(User user) {
        //信息进行加密,补齐数据
        String digest = MD5Utils.digest(user.getPwd());
        user.setPwd(digest);
        user.setCreated(new Date());
        user.setUpdated(new Date());
        return userMapper.insertSelective(user);
    }

    @Override
    public Map userLogin(String username, String pwd) {
        //根据信息查询到用户,有的话就存到redis,然后返回
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("pwd",MD5Utils.digest(pwd));
        List<User> list = userMapper.selectUser(map);
        if (list.size()  == 0 || list == null){
            //没有查询到数据
            return map;
        }
        User user = list.get(0);
        String token = UUID.randomUUID().toString();
        redisClient.set(USER_INFO + ":" + token,user);
        redisClient.expire(USER_INFO + ":" +token,SESSION_EXPIRE);

        map.put("token",token);
        map.put("userId",user.getId());
        map.put("username",user.getUsername());
        return map;
    }
}
