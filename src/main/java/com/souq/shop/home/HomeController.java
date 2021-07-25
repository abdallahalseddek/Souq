package com.souq.shop.home;

import org.springframework.stereotype.Controller;

@Controller

public class HomeController {

    public String homePage(){
        return "index";
    }
}
