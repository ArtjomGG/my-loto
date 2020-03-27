package com.bta.myloto.service;

import com.bta.myloto.domain.LotoTicket;
import com.bta.myloto.domain.UserAccount;

public interface UserAccountService {
    boolean login(String userName, String userPassword);
    void registrationTicket (LotoTicket ticket);
}
