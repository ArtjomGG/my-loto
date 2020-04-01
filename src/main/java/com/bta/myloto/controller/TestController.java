package com.bta.myloto.controller;

import com.bta.myloto.domain.UserAccount;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @GetMapping (value = {"/", "/index1"})
    public String index(Model model){
        model.addAttribute("myTitle", "My First Page Title");

        return "index";
    }

    //@RequestMapping (path = "/get", method = RequestMethod.GET)
    @GetMapping ("/get")
    public ResponseEntity<String> getHelloWorld (@RequestParam String param1, @RequestParam String param2) { //kogda pri;etit zaproz mna get, budet iskat' param1
        System.out.println(param1);
        System.out.println(param2);

        return new ResponseEntity<>("Hello World!!!", HttpStatus.OK);
    }

    //@RequestMapping (path = "/getById/{id}", method = RequestMethod.GET)
    @GetMapping ("/getById/{id}")
    public ResponseEntity<String> getById (@PathVariable Long id) { //kogda priletit zaproz na get, budet iskat' Id
        System.out.println(id);

        return new ResponseEntity<>("Hello World!!!", HttpStatus.OK);
    }

    //@RequestMapping (path = "/post", method = RequestMethod.POST)
    @PostMapping ("/post")
    public ResponseEntity<UserAccount> postHelloWorld (@RequestBody UserAccount userAccount) {
        userAccount.setFirstName("AfterPost");
        userAccount.setId(999L);

        return new ResponseEntity<>(userAccount, HttpStatus.OK);
    }


}
