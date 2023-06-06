package com.luol.carmanagement.entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 * 系统用户
 * @author luolei
 */
@Data
@Entity
@Table(name = "SystemUser")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "myid")
    @GenericGenerator(name = "myid",
            strategy = "com.luol.carmanagement.common.IDGenerator")
    @Column(name = "id" )
    private Long id;


    /**
     * 用户名称
     */
    private String userName;


    /**
     * 密码
     */
    private String password;


    /**
     * 创建时间
     */
    private String createTime;
}
