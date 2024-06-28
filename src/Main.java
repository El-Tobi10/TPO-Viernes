package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Usuario tobias = new Usuario("El-Tobi10", "tobias@gmail.com", "12345");
        //Usuario gaby = new Usuario("El_pendeviejo_erecto", "gabynegrita@hotmail.com", "0725");
        //Usuario chuco = new Usuario("SkibidiSigmaChuco", "peladin@yahoo.com", "pixelgun");
        //tobias.insertarJuegos("Skibidi Toilet", 15, "2023-02-07", "Chuco");
        System.out.println("");
        tobias.agregarJuegosBiblioteca(52);
        tobias.agregarJuegosBiblioteca(51);
        tobias.agregarJuegosBiblioteca(25);
        tobias.agregarJuegosBiblioteca(1);
        System.out.println("");
        tobias.queJuegosTenes();
    }

}