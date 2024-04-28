package com.example.zeroTableBoot.controller;

import com.example.zeroTableBoot.dto.UsersForm;
import com.example.zeroTableBoot.entity.Users;
import com.example.zeroTableBoot.repository.UsersRepository;
import com.example.zeroTableBoot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UserAction {
    private final UserService userService;
    private final UsersRepository usersRepository;

    @PostMapping("/userJoin")
    public String userJoin(@ModelAttribute UsersForm usersForm, RedirectAttributes redirect){

        Users users = usersForm.toEntity(usersForm.getEmailId(), usersForm.getPassword(), usersForm.getUserName());

        String result = userService.joinIn(users);

        if(result.equals("failure")){
            redirect.addFlashAttribute("message", "회원가입에 실패했습니다.");
            return "redirect:/login";
        }
        redirect.addFlashAttribute("message", "회원가입이 완료되었습니다.");
        return "redirect:/login";
    }

//    @PostMapping("/userLogin")
//    public String userLogin(@ModelAttribute UsersForm usersForm, RedirectAttributes rttr){
//        System.out.println(usersForm.toString());
//
//        Users users = usersRepository.findById(usersForm.getEmailId()).orElse(null);
//
//        if(users == null){
//            rttr.addFlashAttribute("message", "존재하지 않는 아이디 입니다.");
//            return "redirect:/login";
//        }
//        else if(!users.getPassword().equals(usersForm.getPassword())){
//            rttr.addFlashAttribute("message", "아이디/비밀번호가 일치하지 않습니다.");
//            return "redirect:/login";
//        }
//
//        rttr.addFlashAttribute("message", users.getUserName() + "님 반갑습니다.");
//        return "redirect:/home";
//    }
}
