package com.thai27.shopfone_be_bu.Repository;


import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneShopUserRepo extends JpaRepository<PhoneShopUser, Long> {

    Optional<PhoneShopUser> findByUsername(String username)  ;

}
