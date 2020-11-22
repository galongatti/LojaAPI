package br.com.WebService.loja.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Anotação que tranforma a classe em um WS Rest
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get() {
        return "API Loja";
    }

}
