package com.sky.admin.service;

import com.sky.admin.entity.AdminInfo;

import java.util.List;

/**
 * @Description: 后台管理员
 * @Author: H
 * @Date: 2020/5/21 10:35
 * @Version: 1.0
 */
public interface AdminInfoService {

    /**
     * 分页查询后台管理员列表
     *
     * @param page
     * @param pageSize
     * @return
     */
    List<AdminInfo> getList(Integer page, Integer pageSize);

    /**
     * 根据ID查询详情
     *
     * @param id
     * @return
     */
    AdminInfo findAllById(Integer id);

}
