package com.thai27.shopfone_be_bu.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "phone_line")
@Data
public class PhoneLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "line_name")
    private String lineName;

    @OneToMany(mappedBy = "phoneLine", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PhoneModel> phoneModels;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "phone_brand_id")
    private PhoneBrand phoneBrand;
}
