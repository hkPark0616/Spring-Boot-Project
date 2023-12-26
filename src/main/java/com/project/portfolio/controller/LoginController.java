package com.project.portfolio.controller;


import com.project.portfolio.domain.entity.UserEntity;
import com.project.portfolio.domain.repository.UserRepository;
import com.project.portfolio.dto.BoardDto;
import com.project.portfolio.dto.UserDto;
import com.project.portfolio.service.BoardService;
import com.project.portfolio.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @ResponseBody
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Map<String, String> doRegister(@ModelAttribute(name = "userDto") UserDto userDto){

        return userService.saveUser(userDto);
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, String> doLogin(@ModelAttribute(name = "userDto") UserDto userDto, HttpServletRequest httpServletRequest){

        // 세선 생성 전 기존의 세션 제거
        httpServletRequest.getSession().invalidate();
        // Session이 없으면 생성
        HttpSession session = httpServletRequest.getSession(true);

        // 세션에 userId를 넣어줌
        session.setAttribute("userId", userDto.getId());

        return userService.validateLogin(userDto);

    }


    // Logout
    @RequestMapping("/logout")
    public String Logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        // 세션이 null이 아니라면. 즉, 기존에 세션이 존재하면 세션 삭제
        if(session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }




}


