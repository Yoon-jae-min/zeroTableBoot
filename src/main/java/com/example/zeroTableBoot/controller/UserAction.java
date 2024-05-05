package com.example.zeroTableBoot.controller;

import com.example.zeroTableBoot.dto.UsersForm;
import com.example.zeroTableBoot.entity.Users;
import com.example.zeroTableBoot.repository.UsersRepository;
import com.example.zeroTableBoot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserAction {
    private final UserService userService;

    @PostMapping("/userJoin")
    public String userJoin(@ModelAttribute UsersForm usersForm, RedirectAttributes redirect){

        Users users = usersForm.toEntity(usersForm.getEmailId(), usersForm.getPassword(), usersForm.getUserName());

        String result = userService.joinIn(users);

        if(result.equals("failure")){
            redirect.addFlashAttribute("message", "회원가입에 실패했습니다.");
            return "redirect:/login";
        }
        else if(result.equals("existed Id")){
            redirect.addFlashAttribute("message", "이미 존재하는 아이디입니다.");
            return "redirect:/login";
        }
        redirect.addFlashAttribute("message", "회원가입이 완료되었습니다.");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String userLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        if (session != null) {
            session.invalidate();
        }

        return "/home";
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
