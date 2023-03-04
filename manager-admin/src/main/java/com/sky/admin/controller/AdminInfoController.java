package com.sky.admin.controller;

import com.sky.admin.entity.AdminInfo;
import com.sky.admin.service.AdminInfoService;
import com.sky.common.util.CommonPage;
import com.sky.common.util.CommonResult;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Description: 后台管理员
 * @Author: H
 * @Date: 2020/5/21 10:13
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/info")
@Api(tags = "后台管理员操作类")
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @GetMapping("/list/{page}/{pageSize}")
    @ApiOperation(value = "分页查询后台管理员列表")
    @ApiResponses({
            @ApiResponse(code = 200, message = "操作成功", response = AdminInfo.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示条数", required = true, paramType = "path", dataType = "int")
    })
    public CommonResult<CommonPage<AdminInfo>> getList(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        List<AdminInfo> adminInfos = adminInfoService.getList(page, pageSize);
        return CommonResult.success(CommonPage.restPage(adminInfos));
    }


    @GetMapping("/findbyid/{id}")
    @ApiOperation(value = "根据ID查询详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "int")
    })
    public CommonResult<AdminInfo> getById(@PathVariable("id") Integer id) {
        AdminInfo adminInfo = adminInfoService.findAllById(id);
        return CommonResult.success(adminInfo);
    }


}
