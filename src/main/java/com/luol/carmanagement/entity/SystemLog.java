package com.luol.carmanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统日志
 * @author luolei
 */
@Data
@Entity
@Table(name = "SystemLog")
public class SystemLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 类名称
     */
    private String clazzName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 操作说明
     */
    private String description;

    /**
     * 耗时（ms）
     */
    private String consumeTime;

    /**
     * 返回参数
     */
    private String result;

}
