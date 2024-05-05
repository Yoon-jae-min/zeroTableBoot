package com.example.zeroTableBoot.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class movePage {
    @GetMapping("/home")
    public String homePageGoto(Model model){

        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("id", id);

        if(id.equals("anonymousUser")){
            model.addAttribute("loginImgUrl", "../images/login.png");
            model.addAttribute("loginUrl", "/login");
            model.addAttribute("myPageVisible", "none");
        }
        else {
            model.addAttribute("loginImgUrl", "../images/logout.png");
            model.addAttribute("loginUrl", "/logout");
            model.addAttribute("myPageVisible", "flex");
        }

        return "homePage";
    }

    @GetMapping("/recipes")
    public String recipesPageGoto(Model model){

        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("id", id);

        if(id.equals("anonymousUser")){
            model.addAttribute("loginImgUrl", "../images/login.png");
            model.addAttribute("loginUrl", "/login");
            model.addAttribute("myPageVisible", "none");
        }
        else {
            model.addAttribute("loginImgUrl", "../images/logout.png");
            model.addAttribute("loginUrl", "/logout");
            model.addAttribute("myPageVisible", "flex");
        }

        return "recipesPage";
    }

    @GetMapping("/ingredients")
    public String ingredientsPageGoto(Model model){

        model.addAttribute("loginImgUrl", "../images/logout.png");
        model.addAttribute("loginUrl", "/logout");
        model.addAttribute("myPageVisible", "flex");
        return "ingredientsPage";
    }

    @GetMapping("/community")
    public String comunityPageGoto(Model model){

        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("id", id);

        if(id.equals("anonymousUser")){
            model.addAttribute("loginImgUrl", "../images/login.png");
            model.addAttribute("loginUrl", "/login");
            model.addAttribute("myPageVisible", "none");
        }
        else {
            model.addAttribute("loginImgUrl", "../images/logout.png");
            model.addAttribute("loginUrl", "/logout");
            model.addAttribute("myPageVisible", "flex");
        }

        return "communityPage";
    }

    @GetMapping("/customer")
    public String customerPageGoto(Model model){

        String id = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("id", id);

        if(id.equals("anonymousUser")){
            model.addAttribute("loginImgUrl", "../images/login.png");
            model.addAttribute("loginUrl", "/login");
            model.addAttribute("myPageVisible", "none");
        }
        else {
            model.addAttribute("loginImgUrl", "../images/logout.png");
            model.addAttribute("loginUrl", "/logout");
            model.addAttribute("myPageVisible", "flex");
        }

        return "customerPage";
    }

    @GetMapping("/login")
    public String loginPageGoto(Model model){

        model.addAttribute("loginImgUrl", "../images/login.png");
        model.addAttribute("loginUrl", "/login");
        model.addAttribute("myPageVisible", "none");

        return "loginPage";
    }

    @GetMapping("/myPage")
    public String myPageGoto(Model model){

        model.addAttribute("loginImgUrl", "../images/logout.png");
        model.addAttribute("loginUrl", "/logout");
        model.addAttribute("myPageVisible", "flex");

        return "myPage";
    }
}
