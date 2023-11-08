package com.thai27.shopfone_be_bu.Controller;

import com.thai27.shopfone_be_bu.Entity.ResetPass;
import com.thai27.shopfone_be_bu.ServiceImplement.ResetPassServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resetPass")
public class ResetPassController {

    @Autowired
    ResetPassServiceImplement resetPassSrvImp;

    @PostMapping("sendRequest")
    public String sendRequest (String username){
        return resetPassSrvImp.createNewRequest(username);
    }
}
