package com.thai27.shopfone_be_bu.DTO;

import lombok.Data;

@Data
public class PhoneModelDetail {

    private int id;
    private int rowNum;
    private String phoneName;
    private Double phonePrice;
    private String phoneImei;
    private Boolean soldStatus;
    private String lineName;
    private String brandName;
}
