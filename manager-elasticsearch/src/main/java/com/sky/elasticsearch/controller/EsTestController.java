package com.sky.elasticsearch.controller;

import com.sky.common.util.CommonResult;
import com.sky.common.util.ResultCode;
import com.sky.elasticsearch.entity.Category;
import com.sky.elasticsearch.service.EsTestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: H
 * @Date: 2021/3/11 17:05
 * @Version: 1.0.0
 */
@RestController
@RequestMapping(value = "/es/test/")
public class EsTestController {

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private EsTestService esTestService;

    @GetMapping("/get/{id}")
    @ApiOperation(value = "根据ID查询详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "string")
    })
    public CommonResult getById(@PathVariable(value = "id") String id) throws IOException {

        GetRequest request = new GetRequest("course_base", "test", id);

        GetResponse response = client.get(request, RequestOptions.DEFAULT);

        if (response.isExists()) {
            return CommonResult.success(response, ResultCode.SUCCESS.getMessage());
        }

        return CommonResult.failed(ResultCode.FAILED, ResultCode.FAILED.getMessage());
    }


    @PostMapping("/add/index")
    @ApiOperation(value = "创建索引(增加文档和修改文档)")
    public CommonResult addIndex() throws IOException {

        List<Category> categories = esTestService.findAll();

        HashMap<String, Object> map = new HashMap<>();

        map.put("description", "猴哥正在修改你嘞！！！");

        IndexRequest request = new IndexRequest("course_base", "test", "297e7c7c62b888f00162b8a7dec20000").source(map);

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        return CommonResult.success(response, ResultCode.SUCCESS.getMessage());
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据ID删除文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, paramType = "path", dataType = "string")
    })
    public CommonResult deleteById(@PathVariable(value = "id") String id) throws IOException {

        DeleteRequest request = new DeleteRequest("course_base", "test", id);

        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);

        return CommonResult.success(response, ResultCode.SUCCESS.getMessage());
    }


    @GetMapping("/search/{keyword}")
    @ApiOperation(value = "条件查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "keyword", required = true, paramType = "path", dataType = "string")
    })
    public CommonResult search(@PathVariable(value = "keyword") String keyword) throws IOException {

        // 需要查询的索引
        SearchRequest request = new SearchRequest("course_base");

        // 建立搜索对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        // 分页查询
        searchSourceBuilder.from(0);
        searchSourceBuilder.size(10);

        // 条件匹配
        searchSourceBuilder.query(QueryBuilders.matchQuery("description", keyword));

        // 超时设置
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        // 执行
        SearchRequest source = request.source(searchSourceBuilder);
        SearchResponse response = client.search(source, RequestOptions.DEFAULT);

        return CommonResult.success(response, ResultCode.SUCCESS.getMessage());
    }

}
