package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tienda extends Juego implements Biblioteca{
    public static Tienda unicaTienda;

    public static Tienda crearTienda() {
        if (unicaTienda == null) {
            unicaTienda = new Tienda();
        }
        return unicaTienda;
    }

    @Override
    public int cantJuegos() {
        int contador = 0;
        try(Connection conexion = obtenerConexion()){
            PreparedStatement totalJuegos = conexion.prepareStatement("SELECT * FROM juegos");
            ResultSet resultado = totalJuegos.executeQuery();
            while (resultado.next()) {
                contador++;
            }
        }catch (SQLException e) {
            System.out.println("Error al obtener los datos de la persona: " + e.getMessage());
        }
        return contador;
    }

    @Override
    public void buscarxNombre(String nombreJuego) {
        try (Connection conexion = obtenerConexion()){
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
            System.out.println("Lista de Juegos en Biblioteca Compartida:");
            for (String columna : columnas) {
                if (columna.equals("id_juego")){
                    System.out.printf("%-10s",columna);
                }
                else{System.out.printf("%-30s", columna);}
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));

            // Juegos

            PreparedStatement stmtDatos = conexion.prepareStatement("SELECT * FROM juegos WHERE titulo LIKE ?");
            stmtDatos.setString(1, "%"+nombreJuego+"%");
            ResultSet rsDatos = stmtDatos.executeQuery();
            while (rsDatos.next()) {
                for (String columna : columnas) {
                    if (columna.equals("id_juego")) {
                        System.out.printf("%-10s", rsDatos.getString(columna));
                    } else {
                        System.out.printf("%-30s", rsDatos.getString(columna));
                    }
                }
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del juego: " + e.getMessage());}

    }

    public void buscarxGenero(int id_genero) {
        try (Connection conexion = obtenerConexion()){
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
            System.out.println("Lista de Juegos "+ obtenerGeneros(id_genero) + " en la tienda:");
            for (String columna : columnas) {
                if (columna.equals("id_juego")){
                    System.out.printf("%-10s",columna);
                }
                else{System.out.printf("%-30s", columna);}
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));

            // Juegos

            PreparedStatement stmtDatos = conexion.prepareStatement("SELECT * FROM juegos WHERE id_genero = ?");
            stmtDatos.setInt(1, id_genero);
            ResultSet rsDatos = stmtDatos.executeQuery();
            while (rsDatos.next()){
                for (String columna : columnas) {
                    if (columna.equals("id_juego")) {
                        System.out.printf("%-10s", rsDatos.getString(columna));
                    } else {
                        System.out.printf("%-30s", rsDatos.getString(columna));
                    }
                }System.out.println();
            }

            System.out.println("-".repeat(30 * columnas.size()));
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del juego: " + e.getMessage());}

    }
}
