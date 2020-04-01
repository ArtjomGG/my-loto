package com.bta.myloto.controller;

import com.bta.myloto.domain.MyLotoResult;
import com.bta.myloto.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyLotoController {
    @Autowired
    private ResultService resultService;

    @GetMapping("/myLoto")
    public String myLoto (Model model) {

        return "game"; // v otvet m6 poluchim stranicu game.ftl
    }

    @GetMapping("/play") // kak zhe kak i v game.ftl
    public String myLotoPlay (Model model) {
        resultService.getResults();
        List<MyLotoResult> results = resultService.getAllResults();
        model.addAttribute("results", results);

        return "game";
    }
}
