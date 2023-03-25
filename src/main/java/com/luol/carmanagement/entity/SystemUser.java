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


    private String userName;


    private String password;
}
