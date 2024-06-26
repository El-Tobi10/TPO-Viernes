package org.example;

import java.sql.ResultSet;

public interface Biblioteca {
    public int cantJuegos();
    public void queJuegosTenes();
    public void buscarxNombre(String nombreJuego);
    public void buscarxGenero(int idGenero);
}
