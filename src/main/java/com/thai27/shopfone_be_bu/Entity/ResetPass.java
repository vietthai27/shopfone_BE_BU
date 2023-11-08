package com.thai27.shopfone_be_bu.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "reset_pass")
@Data
public class ResetPass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "request_code")
    private String requestCode;

    @Column(name = "created_time")
    private String createdTime;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
}
