package com.weker.nvwa.common.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 12/12/2016
 */
@Data
public class Pageable<T> {

    /**
     * 数据
     */
    private List<T> list;

    /**
     * 总条目数
     */
    private int total;

    public static <T> Pageable<T> of(List<T> list, int total) {
        Pageable<T> pageable = new Pageable<>();
        pageable.setList(list);
        pageable.setTotal(total);

        return pageable;
    }

    public static <T> Pageable<T> empty() {
        return of(new ArrayList<T>(), 0);
    }
}
