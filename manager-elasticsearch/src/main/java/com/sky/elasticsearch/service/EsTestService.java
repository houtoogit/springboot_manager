package com.sky.elasticsearch.service;

import com.sky.elasticsearch.entity.Category;

import java.util.List;

/**
 * @Author: H
 * @Date: 2021/3/12 11:24
 * @Version: 1.0.0
 */
public interface EsTestService {

    /**
     * 查询所有
     *
     * @return
     */
    List<Category> findAll();

}
