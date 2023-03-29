package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.RegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new RegistrationDto());
        return "register";
    }
}
