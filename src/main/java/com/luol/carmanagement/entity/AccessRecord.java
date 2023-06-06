package com.luol.carmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 出入记录
 * @author luolei
 */
@Data
@Entity
@Table(name = "AccessRecord")
public class AccessRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;

    /**
     * 车牌号
     */
    private String areaCarNo;

    /**
     * 区域id
     */
    private Long areaId;

    /**
     * 记录创建时间
     */
    private String createTime;

    /**
     * :0：出 \  1：入
     */
    private Integer inOrOut = 0;


}
