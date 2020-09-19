package com.Ustora.clientui.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class SecurityController {

    /**
     *
     * @return redirect:/index"
     */
    @GetMapping("/login?logout")
    public String logout() {

        return "redirect:/";
    }

    /**
     *
     * @return login
     */
    @GetMapping("/login")
    public String login() {

        return "login";
    }

}
