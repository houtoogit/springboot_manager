package com.sky.elasticsearch.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: H
 * @Date: 2021/3/11 16:59
 * @Version: 1.0.0
 */
@Data
@Entity
@Accessors(chain = true)
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "label")
    private String label;

    @Column(name = "isshow")
    private Integer isshow;

}
