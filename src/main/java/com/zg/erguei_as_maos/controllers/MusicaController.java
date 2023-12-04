package com.zg.erguei_as_maos.controllers;


import com.zg.erguei_as_maos.services.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller

public class MusicaController {
    @Autowired
    MusicaService musicaService;

    @RequestMapping("/")
    public String teste() throws IOException {

        System.out.println(musicaService.carregarMusica());

        return "inicio";

    }

    //Escolha de parte da musica: 0-Música completa | 1-Primeira parte apenas | 2-Segunda parte apenas
    @RequestMapping("/parte")
    public String parte(@RequestParam(required = false) int parte) throws IOException {
        String musica = musicaService.carregarMusica();
        if(parte == 0 ){
            System.out.println( musica);
           // return musica;
        } else if (parte > 0 && parte<=2) {
            System.out.println( musicaService.escolheParte(musica, parte));
           // return musicaService.escolheParte(musica, parte);
        }
       // System.out.println("Entrou");

        return "inicio";
    }

}
