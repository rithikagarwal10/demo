package ca.cmpt6.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class SpringRouteController {
    @GetMapping(path = "/protected") 
	public String process(Model model, HttpSession session) {
        return "protectedContent";
    }
}
