package com.weker.nvwa.biz.service;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象服务类
 *
 * @author jiuxin.zhang@cgtz.com
 * @since 27/12/2016
 */
public abstract class Convertor<S> {

    protected <T> T transfer(S source, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (source != null) {
            T target = clazz.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        }
        return null;
    }

    protected <T> List<T> transfer(List<S> sourceList, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        if (!CollectionUtils.isEmpty(sourceList)) {
            T target;
            List<T> targetList = new ArrayList<>();
            for (S s : sourceList) {
                target = clazz.newInstance();
                BeanUtils.copyProperties(s, target);
                targetList.add(target);
            }
            return targetList;
        }
        return null;
    }
}
