package com.luol.carmanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 区域
 * @author luolei
 */
@Data
@Entity
@Table(name = "Area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;

    /**
     * 区域名称
     */
    private String areaName;

    /**
     * 枚举类型 （校园、办公园区、小区等等）
     */
    private Integer areaType;


    /**
     * 区域地址
     */
    private String areaAddress;


    /**
     * 区域车位数量
     */
    private Integer areaParkingNum;

    /**
     * 创建时间
     */
    private String createTime;

}
