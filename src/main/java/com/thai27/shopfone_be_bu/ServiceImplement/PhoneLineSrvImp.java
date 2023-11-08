package com.thai27.shopfone_be_bu.ServiceImplement;

import com.thai27.shopfone_be_bu.Entity.PhoneLine;
import com.thai27.shopfone_be_bu.Repository.PhoneLineRepo;
import com.thai27.shopfone_be_bu.Service.PhoneLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneLineSrvImp implements PhoneLineService {

    @Autowired
    PhoneLineRepo phoneLineRepo;

    @Override
    public List<PhoneLine> getAllPhoneLine() {
        return phoneLineRepo.findAll();
    }


}
