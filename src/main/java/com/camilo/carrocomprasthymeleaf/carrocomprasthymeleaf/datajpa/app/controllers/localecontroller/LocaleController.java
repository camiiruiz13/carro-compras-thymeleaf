package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.controllers.localecontroller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LocaleController {

    @RequestMapping(value = "/locale", method = RequestMethod.GET)
    public String locale(HttpServletRequest request){
        String ultimaUrl = request.getHeader("referer");

        return "redirect:".concat(ultimaUrl);
    }
}
