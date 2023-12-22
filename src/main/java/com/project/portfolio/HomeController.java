package com.project.portfolio;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
//    @GetMapping("/")
//    public String home(){
//        return "home";
//    }
    @GetMapping("/")
    public String home() {
        // 다른 홈 화면을 표시하는 로직 작성

        return "home";

    }
}
