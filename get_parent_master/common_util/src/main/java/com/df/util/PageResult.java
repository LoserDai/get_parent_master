package com.df.util;

import java.util.List;

/**
 * @Author feng.dai
 * @package com.df.util
 * @project get_parent_master
 * @Date 2022/9/19 9:45
 */
public class PageResult {
    //当前页码
    private Integer pageIndex;
    //总页数
    private Long totalPage;
    //结果集
    private List result;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List getResult() {
        return result;
    }

    public void setResult(List result) {
        this.result = result;
    }
}
