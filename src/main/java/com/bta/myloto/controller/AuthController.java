package com.bta.myloto.controller;

import com.bta.myloto.domain.UserAccount;
import com.bta.myloto.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AuthController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping ("/registration")
    public String showRegistration (){ //vozvrashaet stranicu /registration
        return "registration";
    }

    @PostMapping("/registration")
    public String registration (UserAccount userAccount){ //prinimaet s webForm6 i vnosit v sql
        userAccountService.registration(userAccount);
        return "redirect: /login";
    }

    @GetMapping ("/login")
    public String showLoginForm (){ //vozvrashaet stranicu /login
        return "login";
    }





}
