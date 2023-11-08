package com.thai27.shopfone_be_bu.Service;


import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;

public interface PhoneShopUserService {

    String userSignup(PhoneShopUser userInput);

    String login(PhoneShopUser userData);

    String getUsernameByToken(String token);


}
