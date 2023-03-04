package com.sky.elasticsearch.repository;

import com.sky.elasticsearch.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: H
 * @Date: 2021/3/12 11:30
 * @Version: 1.0.0
 */
public interface EsTestRepository extends JpaRepository<Category, String> {

    /**
     * 查询所有
     *
     * @return
     */
    List<Category> findAll();

}
