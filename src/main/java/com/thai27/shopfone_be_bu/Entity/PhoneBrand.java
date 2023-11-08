package com.thai27.shopfone_be_bu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "phone_brand")
@Data
public class PhoneBrand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "phoneBrand", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PhoneLine> phonelines;
}
