package com.zg.erguei_as_maos.services;

import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;


@Service
public class MusicaService {

//1 - carregar musica no programa
    public String carregarMusica() throws IOException {
    FileReader fr = new FileReader(
            "D:\\Biblioteca\\Documentos\\workspace\\erguei_as_maos\\src\\main\\resources\\files\\erguei as maos.txt");
    String musica="";
    int i;
        while ((i = fr.read()) != -1)
            musica+=(char) i;
    return musica;
    }



    //2 - dividir a musica

    public String escolheParte(String musica, int parte){
        String musica_f[];
        musica_f = musica.split("E atenção agora, porque");
        if(parte == 1){
            return musica_f[0];
        }
        else return musica_f[1];
    }
}

