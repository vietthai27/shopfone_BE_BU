package com.thai27.shopfone_be_bu.Controller;


import com.thai27.shopfone_be_bu.Entity.PhoneLine;
import com.thai27.shopfone_be_bu.ServiceImplement.PhoneLineSrvImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phoneLine")
public class PhoneLineController {

    @Autowired
    PhoneLineSrvImp phoneLineSrvImp;

    @GetMapping("/getAllPhoneLine")
    public List<PhoneLine> getAllPhoneLine() {
        return phoneLineSrvImp.getAllPhoneLine();
    }

}
