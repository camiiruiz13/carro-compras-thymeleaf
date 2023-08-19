package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.controllers.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, Principal principal, RedirectAttributes flash){

        if(principal != null) {
            flash.addFlashAttribute("info", "Ya ha inciado sesión anteriormente");
            return "redirect:/";
        }

        return "login";
    }
}
