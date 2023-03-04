package com.sky.elasticsearch.service.impl;

import com.sky.elasticsearch.entity.Category;
import com.sky.elasticsearch.repository.EsTestRepository;
import com.sky.elasticsearch.service.EsTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: H
 * @Date: 2021/3/12 11:24
 * @Version: 1.0.0
 */
@Service
public class EsTestServiceImpl implements EsTestService {

    @Autowired
    private EsTestRepository esTestRepository;

    @Override
    public List<Category> findAll() {
        return esTestRepository.findAll();
    }
}
