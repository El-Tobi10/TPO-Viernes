package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class Tienda extends Juego implements Biblioteca{
    private static Tienda unicaTienda;
    private Usuario Usuario;

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
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM juegos WHERE titlo = LIKE ?");
            statement.setString(1, nombreJuego);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Lista de Jueguitos");
            while (resultSet.next()){
                int idjuego = resultSet.getInt("id_juego");
                String juegoTitulo = resultSet.getString("titulo");
                int juegoGenero = resultSet.getInt("id_genero");
                String juegoLanzamineto = resultSet.getString("lanzamiento");
                String juegoDesarrollador = resultSet.getString("desarrollador");

                System.out.println("ID Juego: " + idjuego);
                System.out.println("Titulo: " + juegoTitulo);
                System.out.println("Id Genero: " + juegoGenero);
                System.out.println("Lanzamiento: " + juegoLanzamineto);
                System.out.println("Desarrollador: " + juegoDesarrollador);
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del juego: " + e.getMessage());
        }

    }

    public void buscarxGenero(int id_genero) {

        try(Connection conexion = obtenerConexion()){
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM juegos WHERE id_genero = ?");
            statement.setInt(1, id_genero);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Lista de Generos: ");
            while (resultSet.next()){
                int idjuego = resultSet.getInt("id_juego");
                String juegoTitulo = resultSet.getString("titulo");
                int juegoGenero = resultSet.getInt("id_genero");
                String juegoLanzamineto = resultSet.getString("lanzamiento");
                String juegoDesarrollador = resultSet.getString("desarrollador");

                System.out.println("ID Juego: " + idjuego);
                System.out.println("Titulo: " + juegoTitulo);
                System.out.println("Id Genero: " + juegoGenero);
                System.out.println("Lanzamiento: " + juegoLanzamineto);
                System.out.println("Desarrollador: " + juegoDesarrollador);
                System.out.println("-------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de la persona: " + e.getMessage());
        }

    }
}
