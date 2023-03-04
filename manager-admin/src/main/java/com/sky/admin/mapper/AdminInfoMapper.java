package com.sky.admin.mapper;

import com.sky.admin.entity.AdminInfo;

import java.util.List;

/**
 * @Description: 后台管理员 --- 《admin_info》
 * @Author: H
 * @Date: 2020/5/21 10:39
 * @Version: 1.0
 */
public interface AdminInfoMapper {

    /**
     * 分页查询后台管理员列表
     *
     * @return
     */
    abstract public List<AdminInfo> getList();

}
