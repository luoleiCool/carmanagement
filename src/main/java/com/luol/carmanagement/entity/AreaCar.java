package com.luol.carmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 区域车辆
 * @author luolei
 */
@Data
@Entity
@Table(name = "AreaCar")
public class AreaCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;

    /**
     * 车牌号
     */
    private String carNo;


    /**
     * 区域用户
     */
    private Long areaUser;

    /**
     * ..... 其他扩展
     */
}
