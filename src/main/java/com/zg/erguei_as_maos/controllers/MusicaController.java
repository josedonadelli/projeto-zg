package com.zg.erguei_as_maos.controllers;


import com.zg.erguei_as_maos.services.MusicaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class MusicaController {
    @Autowired
    MusicaService musicaService;



    //Escolha de parte da musica: 0-Música completa | 1-Primeira parte apenas | 2-Segunda parte apenas
    @Operation(summary = "Retorna a musica (ou a parte escolhida da musica) Erguei as Maos ", description = "Para incluir as falas do padre, altere 'falasPadre' para 1 " +
            "  Para escolher a musica altere 'parteMusica' para:  0 - musica completa; 1 - Primeira parte da musica; 2 - Segunda part da musica")
    @GetMapping("/parte")
    public ResponseEntity<String>  parte(@RequestParam(defaultValue = "0") int parteMusica, @RequestParam(defaultValue = "0") int falasPadre) throws IOException {
        String musica;
        if(falasPadre == 0){
         musica = musicaService.removeParenteses(musicaService.carregarMusica());
        }   else{
            musica = musicaService.carregarMusica();
        }
        if(parteMusica == 0 ){
            return ResponseEntity.ok(musica);
        }
        if (parteMusica > 0 && parteMusica<=2) {
            return ResponseEntity.ok(musicaService.escolheParte(musica, parteMusica));
        }
        if (parteMusica == 3){
            System.out.println(musicaService.removeParenteses(musica));
            return ResponseEntity.ok(musicaService.removeParenteses(musica));
        }
        return ResponseEntity.notFound().build();
    }

}
