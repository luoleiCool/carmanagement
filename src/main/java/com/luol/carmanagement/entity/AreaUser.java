package com.luol.carmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 区域用户
 * @author luolei
 */
@Data
@Entity
@Table(name = "AreaUser")
public class AreaUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;

    /**
     * 关联区域信息
     */
    private Integer areaId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * 车牌号码
     */
    private String carNo;

    /**
     * 创建时间
     */
    private String createTime;


}
