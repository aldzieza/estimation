package pl.olointeria.assessment.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
class HomeController {

    @GetMapping("/")
    String home() {
        return "index";
    }
}
