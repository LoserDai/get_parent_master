package com.df.filter;

import com.df.util.JsonUtils;
import com.df.util.Result;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * @Author feng.dai
 * @package com.df.filter
 * @project get_parent_master
 * @Date 2022/9/20 16:34
 */
public class RateLimitFilter extends ZuulFilter {

    private static final RateLimiter RATE_LIMIT = RateLimiter.create(1);

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 令牌桶限流
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMIT.tryAcquire()){
            RequestContext currentContext = RequestContext.getCurrentContext();
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody(JsonUtils.objectToJson(
                    Result.ok("System is busy, please visit later~")
            ));
            currentContext.getResponse().setContentType("application/json; charset=utf-8");
        }
        return null;
    }
}
