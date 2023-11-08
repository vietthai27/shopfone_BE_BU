package com.thai27.shopfone_be_bu.Ulti;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    JavaMailSender mailSender;

    public String sendCodeResetPass(String userMail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("FIS.auto.service@gmail.com");
        message.setTo(userMail);
        message.setSubject("Mã xác thực reset mật khẩu");
        message.setText("Mã xác thực là: " + code);
        mailSender.send(message);
        return "Gửi xác thực thành công !";
    }

    public String sendSuccessResetPass(String userMail, String username, String newPassword) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("FIS.auto.service@gmail.com");
        message.setTo(userMail);
        message.setSubject("Reset mật khẩu thành công !");
        message.setText("Tài khoản " + username + " đã reset mật khẩu thành công với mật khẩu mới là: " + newPassword);
        mailSender.send(message);
        return "Reset mật khẩu thành công !";
    }
}
