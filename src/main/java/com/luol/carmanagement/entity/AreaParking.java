package com.luol.carmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 区域车位
 * @author luolei
 */
@Data
@Entity
@Table(name = "AreaParking")
public class AreaParking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;


    /**
     * 车位编码
     */
    private String parkingNo;



}
