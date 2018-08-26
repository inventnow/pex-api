package com.inventnow.projectx.user.entity;

import com.inventnow.projectx.user.dto.Promo;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "pex_user_info")
@SequenceGenerator(name = "seq_pex_user_info", sequenceName = "seq_pex_user_info", allocationSize = 1)
@Data
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pex_user_info")
    private Long id;

    private Long userId;

    private String userName;

    private String firstName;

    private String lastName;

    private Long totalPoints;

    private Set<String> roles;

    private List<Promo> promos;

    private LocalDateTime createdon;
}
