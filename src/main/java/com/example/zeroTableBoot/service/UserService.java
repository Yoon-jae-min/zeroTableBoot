package com.example.zeroTableBoot.service;

import com.example.zeroTableBoot.dto.UsersSecurityForm;
import com.example.zeroTableBoot.entity.Users;
import com.example.zeroTableBoot.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public String joinIn(Users users){
        if(usersRepository.existsById(users.getEmailId())){
            return "existed Id";
        }

        try{
            users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
            usersRepository.save(users);
        }
        catch (Exception e){
            return "failure";
        }
        return "success";
    }


    public void checkLoginIcon(Model model){
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
    }


    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        Users users = usersRepository.findById(emailId).orElse(null);

        if(users != null){
            return new UsersSecurityForm(users);
        }

        return null;
    }
}
