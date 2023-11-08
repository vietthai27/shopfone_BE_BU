package com.thai27.shopfone_be_bu.Controller;


import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;
import com.thai27.shopfone_be_bu.Security.JWTAuthenProvider;
import com.thai27.shopfone_be_bu.Security.JWTUltil;
import com.thai27.shopfone_be_bu.Service.PhoneShopUserService;
import com.thai27.shopfone_be_bu.ServiceImplement.UserDetailServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class PhoneShopUserController {

    @Autowired
    JWTUltil jwtUtil;

    @Autowired
    JWTAuthenProvider jwtAuth;

    @Autowired
    UserDetailServiceImplement userSrvImp;

    @Autowired
    PhoneShopUserService phoneShopUserSrvImp;


    @PostMapping("/login")
    public String login(@RequestBody PhoneShopUser userData) {
        return phoneShopUserSrvImp.login(userData);
    }

    @PostMapping("/userSignup")
    public String userSignup(@RequestBody PhoneShopUser userData) {
        return phoneShopUserSrvImp.userSignup(userData);
    }

    @PostMapping("/getUsernameByToken")
    public String getUsernameByToken(@RequestParam String token) {
        return phoneShopUserSrvImp.getUsernameByToken(token);
    }
}
