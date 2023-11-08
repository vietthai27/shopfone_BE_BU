package com.thai27.shopfone_be_bu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "phone_model")
@Data
public class PhoneModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "phone_name")
    private String phoneName;

    @Column(name = "phone_price")
    private Double phonePrice;

    @Column(name = "phone_imei")
    private String phoneImei;

    @Column(name = "sold_status")
    private Boolean soldStatus;

    @ManyToOne
    @JoinColumn(name = "phone_line_id")
    @JsonIgnore
    private PhoneLine phoneLine;

}
