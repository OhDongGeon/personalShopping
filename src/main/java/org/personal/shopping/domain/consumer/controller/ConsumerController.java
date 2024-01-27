package org.personal.shopping.domain.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sign")
public class ConsumerController {

    @GetMapping("/in")
    public String loginForm() {

        return "login";
    }
}
