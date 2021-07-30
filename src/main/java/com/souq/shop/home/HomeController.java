package com.souq.shop.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    // preview home page with Spring MVC Controller
    public String homePage(){
        return "index";
    }
}
