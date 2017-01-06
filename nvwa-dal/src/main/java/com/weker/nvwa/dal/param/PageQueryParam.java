package com.weker.nvwa.dal.param;

import lombok.Setter;

/**
 * 带分页功能的查询参数
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 12/12/2016
 */
public class PageQueryParam {

    /**
     * 当前页
     */
    @Setter
    private int pageNo = 1;

    /**
     * 每页条目数
     */
    @Setter
    private int limit = 20;

    public int getPageNo() {
        return pageNo < 0 ? 0 : (pageNo - 1) * limit;
    }

    public int getLimit() {
        return limit < 0 ? 0 : limit;
    }
}
