package com.bta.myloto.controller;

import com.bta.myloto.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyLotoController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/index")
    public String index (Model model) {

        return "index"; // v otvet m6 poluchim stranicu index.ftl
    }

    @GetMapping("/loto/results") // zakr6n6e resulrs6 dlja  obzovanija
    public String myLotoResults (Model model) {
        return "loto/results";
    }

    @GetMapping("/loto/play") // zakr6n6e resulrs6 dlja  obzovanija
    public String myLotoPlay (Model model) {
        //resultService.getResults();
        //List<MyLotoResult> results = resultService.getAllResults();
        //model.addAttribute("results", results);

        return "loto/play";
    }
}
