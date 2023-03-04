package com.sky.admin.repository;

import com.sky.admin.entity.AdminInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description: 后台管理员 --- 《admin_info》
 * @Author: H
 * @Date: 2020/5/21 10:39
 * @Version: 1.0
 */
public interface AdminInfoRepository extends JpaRepository<AdminInfo, Integer> {

    /**
     * 根据ID查询详情
     *
     * @param id
     * @return
     */
    AdminInfo findAllById(Integer id);
}
