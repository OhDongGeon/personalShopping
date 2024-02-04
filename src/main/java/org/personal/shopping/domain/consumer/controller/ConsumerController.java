package org.personal.shopping.domain.consumer.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.personal.shopping.domain.consumer.domel.dto.LoginDto;
import org.personal.shopping.domain.consumer.domel.form.CheckEmailDuplication;
import org.personal.shopping.domain.consumer.domel.form.SignIn;
import org.personal.shopping.domain.consumer.domel.form.SignUp;
import org.personal.shopping.domain.consumer.service.ConsumerService;
import org.personal.shopping.global.exception.FindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/sign")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;


    // 구매자 로그인
    @PostMapping("/in")
    public String signInFunction(@ModelAttribute("signIn") @Valid SignIn signIn,
        BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpSession httpSession) {

        try {
            if (bindingResult.hasErrors()) {
                return "/signIn";
            }

            LoginDto loginDto = consumerService.signInFunction(signIn);

            httpSession.setAttribute("userId", loginDto.getEmail());
            httpSession.setAttribute("userName", loginDto.getName());

            return "redirect:/";

        } catch (FindException ex) {
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            redirectAttributes.addFlashAttribute("signIn", signIn);
            return "redirect:/auth/sign-in";
        }
    }

    // 이메일 중복확인
    @PostMapping("/up/check-duplication")
    public ResponseEntity<Map<String, String>> signUpCheckDuplication(
        @Valid @RequestBody CheckEmailDuplication email, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errors);
        }

        boolean checkDuplication = consumerService.signUpCheckDuplication(email.getEmail());

        return checkDuplication ? new ResponseEntity<>(HttpStatus.CONFLICT)
            : new ResponseEntity<>(HttpStatus.OK);
    }

    // 구매자 회원가입
    @PostMapping("/up")
    public String signUpFunction(
        @ModelAttribute("signUp") @Valid SignUp signUp, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/signUp";
        }

        return consumerService.signUpFunction(signUp) ? "redirect:/" : "/signUp";
    }
}
