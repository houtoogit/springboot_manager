package com.sky.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.sky.admin.entity.AdminInfo;
import com.sky.admin.mapper.AdminInfoMapper;
import com.sky.admin.repository.AdminInfoRepository;
import com.sky.admin.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 后台管理员
 * @Author: H
 * @Date: 2020/5/21 10:37
 * @Version: 1.0
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    private AdminInfoMapper adminInfoMapper;

    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @Override
    public List<AdminInfo> getList(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        return adminInfoMapper.getList();
    }

    @Override
    public AdminInfo findAllById(Integer id) {
        return adminInfoRepository.findAllById(id);
    }
}
