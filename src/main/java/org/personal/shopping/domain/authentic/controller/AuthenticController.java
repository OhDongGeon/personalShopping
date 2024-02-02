package org.personal.shopping.domain.authentic.controller;

import org.personal.shopping.domain.consumer.domel.form.SignIn;
import org.personal.shopping.domain.consumer.domel.form.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticController {

    // 로그인 페이지 이동
    @GetMapping("/sign-in")
    public String loginForm(Model model) {

        model.addAttribute("signIn", new SignIn());
        return "signIn";
    }

    // 회원가입 페이지 이동
    @GetMapping("/sign-up")
    public String signUpForm(Model model) {

        model.addAttribute("signUp", new SignUp());
        return "signUp";
    }
}
