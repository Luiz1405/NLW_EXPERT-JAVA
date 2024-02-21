package com.LuizKubaszewski.NLW_EXPERT;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class PrimeiraController{

    @GetMapping("/retornarPrimeiraController")
    public Usuario retornarPrimeiraController() {
        var usuario = new Usuario(
            "Luiz" , 
            22);
        return usuario;
    }

    @PostMapping("/PrimeiroPost")
    public String primeiroPost(){
        return "Primeiro Post";

    }
    record Usuario(String nome, int idade){

    }
}