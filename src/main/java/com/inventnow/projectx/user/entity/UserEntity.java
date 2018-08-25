package com.inventnow.projectx.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seq_users", sequenceName = "seq_users", allocationSize = 1)
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_users")
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    private String password;

    private boolean enabled;

    private String roles;

    @OneToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customerEntity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdon;
}
