package com.example.zeroTableBoot.controller;

import com.example.zeroTableBoot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class movePage {
    private final UserService userService;

    @GetMapping("/home")
    public String homePageGoto(Model model){

        userService.checkLoginIcon(model);

        return "homePage";
    }

    @GetMapping("/recipes")
    public String recipesPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "recipesPage";
    }

    @GetMapping("/ingredients")
    public String ingredientsPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "ingredientsPage";
    }

    @GetMapping("/community")
    public String comunityPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "communityPage";
    }

    @GetMapping("/customer")
    public String customerPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "customerPage";
    }

    @GetMapping("/login")
    public String loginPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "loginPage";
    }

    @GetMapping("/myPage")
    public String myPageGoto(Model model){

        userService.checkLoginIcon(model);

        return "myPage";
    }
}
