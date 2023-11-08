package com.thai27.shopfone_be_bu.ServiceImplement;

import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;
import com.thai27.shopfone_be_bu.Repository.PhoneShopUserRepo;
import com.thai27.shopfone_be_bu.Repository.UserRoleRepo;
import com.thai27.shopfone_be_bu.Security.JWTAuthenProvider;
import com.thai27.shopfone_be_bu.Security.JWTUltil;
import com.thai27.shopfone_be_bu.Service.PhoneShopUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PhoneShopUserSrvImp implements PhoneShopUserService {

    @Autowired
    JWTUltil jwtUtil;

    @Autowired
    JWTAuthenProvider jwtAuth;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    PhoneShopUserRepo phoneShopUserRepo;

    @Autowired
    UserRoleRepo userRoleRepo;


    @Override
    public String userSignup(PhoneShopUser userInput) {
        if (phoneShopUserRepo.findByUsername(userInput.getUsername()).isEmpty()) {
            PhoneShopUser userData = new PhoneShopUser();
            userData.setUsername(userInput.getUsername());
            userData.setPassword(encoder.encode(userInput.getPassword()));
            userData.setEmail(userInput.getEmail());
            userData.setUser_roles(userRoleRepo.findByRolename("USER"));
            phoneShopUserRepo.save(userData);
            return "Thêm người dùng " + userInput.getUsername() + " thành công !!!";
        } else return "Tên người dùng " + userInput.getUsername() + " đã tồn tại !!!";
    }

    @Override
    public String login(PhoneShopUser userData) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userData.getUsername(), userData.getPassword());
        jwtAuth.authenticate(token);
        String jwtToken = jwtUtil.generate(userData.getUsername());
        return jwtToken;
    }

    @Override
    public String getUsernameByToken(String token) {
        return jwtUtil.getUsername(token);
    }
}
