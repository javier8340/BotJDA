package com.javiergg.webListener;

import com.javiergg.Principal;
import com.javiergg.webListener.entities.Jugador;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    @PostMapping("/test")
    public String index(){
        Principal.api.getTextChannels().forEach(c->c.sendMessage("prueba").queue());
        return "funciona";
    }
    @PostMapping("/asd")
    public Object asd(){
        return new Jugador();

    }
}
