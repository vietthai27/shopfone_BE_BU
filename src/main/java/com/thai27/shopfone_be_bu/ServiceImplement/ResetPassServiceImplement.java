package com.thai27.shopfone_be_bu.ServiceImplement;

import com.thai27.shopfone_be_bu.Entity.PhoneShopUser;
import com.thai27.shopfone_be_bu.Entity.ResetPass;
import com.thai27.shopfone_be_bu.Repository.PhoneShopUserRepo;
import com.thai27.shopfone_be_bu.Repository.ResetPassRepo;
import com.thai27.shopfone_be_bu.Service.ResetPassService;
import com.thai27.shopfone_be_bu.Ulti.GenerateRandomString;
import com.thai27.shopfone_be_bu.Ulti.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class ResetPassServiceImplement implements ResetPassService {

    @Autowired
    ResetPassRepo resetPassRepo;

    @Autowired
    GenerateRandomString randomString;
    @Autowired
    SendEmail sendEmail;

    @Autowired
    PhoneShopUserRepo phoneShopUserRepo;

    @Override
    public String createNewRequest(String username) {

        Optional<PhoneShopUser> findUser = phoneShopUserRepo.findByUsername(username);

        if (findUser.isEmpty()) {
            return "Tên người dùng: " + username + " không tồn tại trong hệ thống";
        } else {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String requestCode = randomString.generateRandomCode(5);

            ResetPass newRequest = new ResetPass();
            newRequest.setRequestCode(requestCode);
            newRequest.setCreatedTime(dtf.format(now));
            newRequest.setUsername(username);
            newRequest.setEmail(findUser.get().getEmail());
            resetPassRepo.save(newRequest);

            sendEmail.sendCodeResetPass(findUser.get().getEmail(), requestCode);

            return "Kiểm tra email để lấy mã";
        }
    }

    @Override
    public String validateRequestCode(String requestCode) {

        return null;
    }
}
