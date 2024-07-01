package org.example;
///Tobias Alfonso 1169215
///Gabriel Domingo 1168660
///Lautaro papaianni 1170805
///Agustin Lamendola 1164095
///Santino Lozano 1173470

import java.util.Scanner;

import static org.example.Tienda.unicaTienda;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tienda.crearTienda();
        Usuario tobias = new Usuario("El-Tobi10", "tobias@gmail.com", "12345");
        Usuario gaby = new Usuario("Gaby0725", "gabriel@hotmail.com", "0725");
        Usuario chuco = new Usuario("SkibidiSigmaChuco", "peladin@yahoo.com", "pixelgun");
        Usuario profe = new Usuario("martinsauczuk", "martinsauczuk@estym.com", "trenes");

        chuco.insertarJuegos("Sigma Adventure", 28, "2023-03-24", "Chuco");
        profe.insertarJuegos("The Last of Us", 15, "2013-06-14", "Naughty Dog");

        System.out.println("");
        tobias.serAmigo(gaby);
        gaby.serAmigo(tobias);
        System.out.println("");

        System.out.println();
        unicaTienda.obtenerJuegos();
        System.out.println("El total de los juegos de la Tienda son " + unicaTienda.cantJuegos() + " juegos");
        System.out.println();

        tobias.agregarJuegosBiblioteca(52);
        tobias.agregarJuegosBiblioteca(51);
        tobias.agregarJuegosBiblioteca(25);
        tobias.agregarJuegosBiblioteca(1);
        tobias.queJuegosTenes();
        System.out.println();

        gaby.agregarJuegosBiblioteca(20);
        gaby.agregarJuegosBiblioteca(52);
        gaby.agregarJuegosBiblioteca(5);
        gaby.agregarJuegosBiblioteca(42);
        gaby.queJuegosTenes();
        System.out.println();

        BibliotecaCompartida gaby_tobias = new BibliotecaCompartida();
        gaby_tobias.armarBiblioteca(tobias, gaby);
        gaby_tobias.queJuegosTenes();

        System.out.println("En la biblioteca compartida de " +
                tobias.getUsuario() + " y " + gaby.getUsuario() +
                " tienen " + gaby_tobias.cantJuegos() + " Juegos.");
        System.out.println("");
        System.out.println();
        gaby_tobias.buscarxNombre("Resident");

        unicaTienda.buscarxGenero(27);
    }

}
