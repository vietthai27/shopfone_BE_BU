package com.thai27.shopfone_be_bu.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "shop_phone_user")
@Data
public class PhoneShopUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @ManyToMany(targetEntity = UserRole.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserRole> user_roles;


}
