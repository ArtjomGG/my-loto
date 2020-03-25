package com.bta.myloto.service;

import com.bta.myloto.dao.UserAccountRepository;
import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean login(String userName, String userPassword) {
        UserAccount userAccount = userAccountRepository.findUserAccountByUserName(userName);
        if (userAccount == null) {
            return false;
        }
        if (userAccount.getUserPassword().equals(userPassword)) {
            return true;
        }

        return false;
    }
}
