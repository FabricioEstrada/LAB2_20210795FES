package com.example.lab2_20210795.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BingoJuego {

    @GetMapping("/configuracion")
    public String configuracion() {
        return "configuracion";
    }

    @PostMapping("/iniciar-juego")
    public String iniciarJuego(@RequestParam("tamaño_tarjeta") int tamano,
                               @RequestParam("numero_tarjeta") int num_tarjeta,
                               Model model) {
        String num="1";
        int matriz[][] = new int[tamano][tamano];
            for (int x=0; x < matriz.length; x++) {
                for (int y=0; y < matriz[x].length; y++) {
                    matriz[x][y] = (int) (Math.random()*98 + 1);
                }
            }
            model.addAttribute("numero_tar", num);
            model.addAttribute("tarjeta" + num, matriz);
        model.addAttribute("tamaño_tarjeta", tamano);

        return "juego";
    }
    /*

            String num;
        int matriz[][] = new int[tamano][tamano];

        for (int i = 1; i < num_tarjeta; i++) {

            for (int x=0; x < matriz.length; x++) {
                for (int y=0; y < matriz[x].length; y++) {
                    matriz[x][y] = (int) (Math.random()*98 + 1);
                }
            }
            num=Integer.toString(i);
            model.addAttribute("numero_tar", num);
            model.addAttribute("tarjeta" + num, matriz);
        }
        model.addAttribute("tamaño_tarjeta", tamano);


    */
}
