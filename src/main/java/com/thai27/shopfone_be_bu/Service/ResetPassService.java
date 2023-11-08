package com.thai27.shopfone_be_bu.Service;

import com.thai27.shopfone_be_bu.Entity.ResetPass;

public interface ResetPassService {

    public String createNewRequest(String username);

    public String validateRequestCode( String requestCode);
}
