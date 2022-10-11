package com.df.feign;

import com.df.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Author feng.dai
 * @package com.df.feign
 * @project get_parent_master
 * @Date 2022/9/27 17:18
 */
@FeignClient("df-get-service")
public interface GetFeign {

    /**
     * 根据ID获取所有信息
     * @param id
     * @return
     */
    List<User> getAll(@PathVariable Long id);
}
