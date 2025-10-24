package cr.ufide.practica01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/", "/inicio"})
    public String home() {
        return "index"; // en vez de redirect:/arboles
    }
}
