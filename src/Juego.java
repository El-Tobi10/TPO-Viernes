package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Conexion{
    private static String titulo;
    private static int id_genero;
    private static String lanzamiento;
    private static String desarrollador;

    public Juego(String titulo, int id_genero, String lanzamiento, String desarrollador) {
        Juego.titulo = titulo;
        Juego.id_genero = id_genero;
        Juego.lanzamiento = lanzamiento;
        Juego.desarrollador = desarrollador;
    }
    public void setTitulo(String titulo){
        Juego.titulo = titulo;
    }
    public String getTitulo(){
        return titulo;
    }

    public void setId_genero(int id_genero){
        Juego.id_genero = id_genero;
    }
    public int getId_genero(){
        return id_genero;
    }

    public void setLanzamiento(String lanzamiento){
        Juego.lanzamiento = lanzamiento;
    }
    public String getLanzamiento(){
        return lanzamiento;
    }

    public void setDesarrollador(String desarrollador){
        Juego.desarrollador = desarrollador;
    }
    public String getDesarrollador(){
        return desarrollador;
    }

    public void obtenerJuegos() {
        try (Connection conexion = obtenerConexion();
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM juegos");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()){
                int idjuego = resultSet.getInt("id_juego");
                String juegoTitulo = resultSet.getString("titulo");
                int juegoGenero = resultSet.getInt("id_genero");
                String juegoLanzamiento = resultSet.getString("lanzamiento");
                String juegoDesarrollador = resultSet.getString("desarrollador");

                System.out.println("ID: " + idjuego);
                System.out.println("Tutulo: " + juegoTitulo);
                System.out.println("ID Genero: " + juegoGenero);
                System.out.println("Lanzamiento: " + juegoLanzamiento);
                System.out.println("Desarrollador: " + juegoDesarrollador);
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos de la persona: " + e.getMessage());
        }



    }




}
