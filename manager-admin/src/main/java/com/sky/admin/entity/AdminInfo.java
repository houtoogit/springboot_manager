package com.sky.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @Description: 后台管理员表 --- 《admin_info》
 * @Author: H
 * @Date: 2020/5/20 17:58
 * @Version: 1.0
 */
@Data
@Entity
@Accessors(chain = true)
public class AdminInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("自增ID")
    private Integer id;

    @ApiModelProperty("用户名")
    @Column(name = "admin_username")
    private String username;

    @ApiModelProperty("姓名")
    @Column(name = "admin_name")
    private String name;

    @ApiModelProperty("密码")
    @Column(name = "admin_password")
    private String password;

    @ApiModelProperty("是否可用，0-不可用，1-可用")
    @Column(name = "admin_enabled")
    private Integer enabled;

    @ApiModelProperty("所属角色ID")
    @Column(name = "role_id")
    private Integer roleId;

    @ApiModelProperty("最后登录时间")
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss")
    @Column(name = "admin_lasttime")
    private Date lasttime;

    @ApiModelProperty("最后登录IP")
    @Column(name = "admin_lastip")
    private String lastip;

    @ApiModelProperty("登录次数")
    @Column(name = "admin_visit_count")
    private Integer visitCount;

    @ApiModelProperty("备注")
    private String remark;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminInfo adminInfo = (AdminInfo) o;
        return Objects.equals(id, adminInfo.id) &&
                Objects.equals(username, adminInfo.username) &&
                Objects.equals(name, adminInfo.name) &&
                Objects.equals(password, adminInfo.password) &&
                Objects.equals(enabled, adminInfo.enabled) &&
                Objects.equals(roleId, adminInfo.roleId) &&
                Objects.equals(lasttime, adminInfo.lasttime) &&
                Objects.equals(lastip, adminInfo.lastip) &&
                Objects.equals(visitCount, adminInfo.visitCount) &&
                Objects.equals(remark, adminInfo.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, password, enabled, roleId, lasttime, lastip, visitCount, remark);
    }
}
