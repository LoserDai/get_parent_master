package com.df.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author feng.dai
 * @package com.df.feign
 * @project get_parent_master
 * @Date 2022/9/27 17:18
 */
@FeignClient("df-get-service")
public interface GetFeign {


}
