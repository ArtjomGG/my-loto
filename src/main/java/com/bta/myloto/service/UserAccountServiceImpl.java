package com.bta.myloto.service;

import com.bta.myloto.dao.UserAccountRepository;
import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean login(String userName, String userPassword) {

        //Option vernul korobochku, esli pustaja togda FALSE, esli polnaja to togda rabotaem dalshe
        List<UserAccount> userAccounts = userAccountRepository.findUserAccountByUserName(userName);
        if (userAccounts.isEmpty()) return false;

        UserAccount userAccount = userAccounts.get(0);
        if (userAccount.getUserPassword().equals(userPassword)) {
            return true;
        }

        return false;
    }
}
