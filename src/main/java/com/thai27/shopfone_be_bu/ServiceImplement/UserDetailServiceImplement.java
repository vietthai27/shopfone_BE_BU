package com.thai27.shopfone_be_bu.ServiceImplement;


import com.thai27.shopfone_be_bu.DTO.UserDetail;
import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;
import com.thai27.shopfone_be_bu.Repository.PhoneShopUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImplement implements UserDetailsService {

    @Autowired
    PhoneShopUserRepo phoneShopUserRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        PhoneShopUser userInfo = phoneShopUserRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Tài khoản " + username + " không tồn tại trong hệ thống"));
        return UserDetail.build(userInfo);
    }

}
