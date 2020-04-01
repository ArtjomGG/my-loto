package com.bta.myloto.service;

import com.bta.myloto.dao.LotoTicketRepository;
import com.bta.myloto.dao.UserAccountRepository;
import com.bta.myloto.domain.LotoTicket;
import com.bta.myloto.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LotoTicketRepository lotoTicketRepository;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public boolean login(String userName, String userPassword) {

        //Option vernul korobochku, esli pustaja togda FALSE, esli polnaja to togda rabotaem dalshe
        List<UserAccount> userAccounts = userAccountRepository.findUserAccountByUserName(userName);
        if (userAccounts.isEmpty())

            return false;

        UserAccount userAccount = userAccounts.get(0);

        if (bCryptPasswordEncoder.matches(userPassword, userAccount.getUserPassword())) {

            return true;
        }

        return false;
    }

    @Override
    public void registrationTicket(LotoTicket ticket) {
        lotoTicketRepository.saveOrUpdate(ticket);
    }

    @Override // Metod dja registracii User-a -
    // 1.Proverka po UserName
    // 2.Chtob6 sohranit, nuzhno zakodirovat' UserPassword
    // 3.Peredaem zakodirovann6j porol
    // 4.Sohranit' User-a

    public int registration(UserAccount userAccount) {
        List<UserAccount> userAccounts = userAccountRepository.findUserAccountByUserName(userAccount.getUserName());
        if (!userAccounts.isEmpty()) { // proverjaet, est' li v sesteme User s UserName uzhe
            throw new RuntimeException("User with " + userAccount.getUserName() + "already exist, try another!");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bCryptPasswordEncoder.encode(userAccount.getUserPassword());
        userAccount.setUserPassword(encodedPassword);

        return userAccountRepository.saveOrUpdate(userAccount);
    }
}
