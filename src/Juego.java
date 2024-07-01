package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Juego extends Conexion{

    public void obtenerJuegos() {
        try (Connection conexion = obtenerConexion();){
             List<String> columnas = new ArrayList<>();
             PreparedStatement stmtColumnas = conexion.prepareStatement(
                     "SELECT column_name FROM information_schema.columns " +
                             "WHERE table_schema = 'public' AND table_name = ? " +
                             "ORDER BY ordinal_position"
             );
             stmtColumnas.setString(1, "juegos");
             ResultSet rsColumnas = stmtColumnas.executeQuery();
            while (rsColumnas.next()) {
            columnas.add(rsColumnas.getString("column_name"));
            }

            // Encabezado
            System.out.println("Los juegos disponibles de la tienda son: ");
            for (String columna : columnas) {
                if (columna.equals("id_juego")){
                    System.out.printf("%-10s",columna);
                }
                else{System.out.printf("%-30s", columna);}
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));

            // Juegos
            PreparedStatement stmtDatos = conexion.prepareStatement("SELECT * FROM juegos");
            ResultSet rsDatos = stmtDatos.executeQuery();
            while (rsDatos.next()) {
                for (String columna : columnas) {
                    if (columna.equals("id_juego")){
                        System.out.printf("%-10s",rsDatos.getString(columna));
                    }
                    else{System.out.printf("%-30s", rsDatos.getString(columna));}
                }
                System.out.println();
            }
            System.out.println("-".repeat(30 * columnas.size()));
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos de la persona: " + e.getMessage());
        }

    }

    public String obtenerGeneros(int id){
        String generos = "";
        try(Connection conexion = obtenerConexion()){
            String query = "Select * from generos WHERE id_genero = ?";
            PreparedStatement stmtGeneros = conexion.prepareStatement(query);
            stmtGeneros.setInt(1, id);
            ResultSet genero = stmtGeneros.executeQuery();
            while (genero.next()){
                generos = genero.getString("genero");
            }
            return generos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
