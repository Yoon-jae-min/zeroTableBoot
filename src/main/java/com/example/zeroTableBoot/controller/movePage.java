package com.example.zeroTableBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class movePage {
    @GetMapping("/home")
    public String homePageGoto(){
        return "homePage";
    }

    @GetMapping("/recipes")
    public String recipesPageGoto(){
        return "recipesPage";
    }

    @GetMapping("/ingredients")
    public String ingredientsPageGoto(){
        return "ingredientsPage";
    }

    @GetMapping("/community")
    public String comunityPageGoto(){
        return "communityPage";
    }

    @GetMapping("/customer")
    public String customerPageGoto(){
        return "customerPage";
    }

    @GetMapping("/login")
    public String loginPageGoto(){
        return "loginPage";
    }
}
