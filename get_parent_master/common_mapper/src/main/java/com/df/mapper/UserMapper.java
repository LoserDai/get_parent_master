package com.df.mapper;

import com.df.pojo.User;

import java.util.HashMap;
import java.util.List;

/**
 * @Author feng.dai
 * @package com.df.mapper
 * @project get_parent_master
 * @Date 2022/9/20 14:47
 */
public interface UserMapper {

    Boolean checkInfo(String checkValue, Integer checkFlag);

    int insertSelective(User user);

    List<User> selectUser(HashMap<String, Object> map);

    List<User> getAll(Long id);
}
