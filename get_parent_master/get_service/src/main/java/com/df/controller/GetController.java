package com.df.controller;

import com.df.pojo.User;
import com.df.service.GetService;
import com.df.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2022/10/8 8:47
 * @Project_Name get_parent_master
 * @Package_Name com.df.controller
 */
@RestController
public class GetController {

    @Autowired
    private GetService getService;

    /**
     * 根据ID获取所有信息
     * @param Id
     * @return
     */
    @RequestMapping("/")
    public List<User> getAll(@PathVariable Long Id) {
        return getService.getAll(Id);
    }
}
