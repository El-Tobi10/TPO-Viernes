package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Usuario extends Conexion implements Biblioteca{
    private String usuario;
    private String email;
    private String contrasenia;
    private Set<Integer> biblioteca = new HashSet<>();
    private Set<Usuario> amigos = new HashSet<>();

    public Usuario(String usuario, String email, String contrasenia) {
        this.usuario = usuario;
        this.email = email;
        this.contrasenia = contrasenia;


        boolean resultado = false;
        try(Connection connection = obtenerConexion()) {
            PreparedStatement ingresoUsuario = connection.prepareStatement("INSERT INTO usuarios (usuario, email, contrasenia, creacion) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");

            ingresoUsuario.setString(1, usuario);
            ingresoUsuario.setString(2, email);
            ingresoUsuario.setString(3, contrasenia);
            int rowsAffected = ingresoUsuario.executeUpdate();
            System.out.println(rowsAffected + " Usuario registrado correctamente.");

            resultado = rowsAffected > 0;
        }
        catch (SQLException e){
            System.err.println("Error al ingresar usuario: " + e.getMessage());
        }
        finally {
            cerrarConexion();
        }
    }

    public void agregarJuegosBiblioteca(Integer id) {
        int cont = 0;
        try (Connection conexion = obtenerConexion()) {
            PreparedStatement insert = conexion.prepareStatement("SELECT * FROM juegos WHERE id_juego = ?");
            insert.setInt(1, id);
            ResultSet resultado = insert.executeQuery();
            while (resultado.next()) {
                cont++;
                biblioteca.add(resultado.getInt("id_juego"));
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar Juego: " + e.getMessage());
        } finally {
            System.out.println("Fua sos el mascapito del barrio agregaste " + cont + " juego/s");
        }
    }
    public Set<Integer> getBiblioteca() {
        return biblioteca;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    public Boolean revisarAmigos(Usuario amigo){
        for (Usuario i : amigos){
            if (i == amigo){
                return true;
            }
        }
        return false;
    }
    public void serAmigo(Usuario nombreAmigo){
        amigos.add(nombreAmigo);
        System.out.println("Ahora eres amigo de " + nombreAmigo.toString());
    }

    public void queJuegosTenes() {
        try (Connection conexion = obtenerConexion()){
            for (int videojuego : biblioteca){
                PreparedStatement buscarID = conexion.prepareStatement("SELECT * FROM juegos WHERE id_juego = ?");
                buscarID.setInt(1, videojuego);
                ResultSet resultSet = buscarID.executeQuery();
                System.out.println("Lista de Juegos en Biblioteca:");
                while (resultSet.next()){
                    String juegoTitulo = resultSet.getString("titulo");
                    int juegoGenero = resultSet.getInt("id_genero");
                    String juegoLanzamiento = resultSet.getString("lanzamiento");
                    String juegoDesarrollador = resultSet.getString("desarrollador");

                    System.out.println("Tutulo: " + juegoTitulo);
                    System.out.println("Id Genero: " + juegoGenero);
                    System.out.println("Lanzamiento: " + juegoLanzamiento);
                    System.out.println("Desarrollador: " + juegoDesarrollador);
                    System.out.println("------------------------");
                };
            }

        }catch (SQLException e) {System.err.println("Error al obtener los datos de la persona: " + e.getMessage());}
    }

    @Override
    public int cantJuegos(){
        return biblioteca.size();
    }



    @Override
    public void buscarxNombre(String nombreJuego) {
        try (Connection conexion = obtenerConexion()){
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM juegos WHERE titlo LIKE '%'?'%'");
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
        try (Connection conexion = obtenerConexion()){
             PreparedStatement statement = conexion.prepareStatement("SELECT * FROM juegos WHERE id_genero = ?");
             statement.setInt(1, id_genero);
             ResultSet resultSet = statement.executeQuery();
            System.out.println("Lista de Jueguitos:");
            while (resultSet.next()){
                String juegoTitulo = resultSet.getString("titulo");
                int juegoGenero = resultSet.getInt("id_genero");
                String juegoLanzamiento = resultSet.getString("lanzamiento");
                String juegoDesarrollador = resultSet.getString("desarrollador");

                System.out.println("Tutulo: " + juegoTitulo);
                System.out.println("Id Genero: " + juegoGenero);
                System.out.println("Lanzamiento: " + juegoLanzamiento);
                System.out.println("Desarrollador: " + juegoDesarrollador);
                System.out.println("------------------------");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos de la persona: " + e.getMessage());
        }

    }

    public boolean insertarJuegos(String titulo, int id_genero, String lanzamiento, String desarrollador) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        boolean resultado = false;
        if (email.contains("@estym.com")){

            try {
                conn = obtenerConexion();
                if (conn != null) {
                    String sql = "INSERT INTO juegos (titulo, id_genero, lanzamiento, desarrollador) VALUES ( ?,?,?,?)";


                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, titulo);
                    pstmt.setInt(2, id_genero);
                    pstmt.setDate(3, Date.valueOf(lanzamiento));
                    pstmt.setString(4, desarrollador);


                    int rowsAffected = pstmt.executeUpdate();
                    System.out.println(rowsAffected + " juego(s) insertado(s).");

                    resultado = rowsAffected > 0;
                }

            } catch (SQLException e) {
                System.err.println("Error al insertar juegos: " + e.getMessage());
            } finally {
                try {
                    // Cerrar recursos
                    if (pstmt != null) pstmt.close();
                    if (conn != null) cerrarConexion();
                } catch (SQLException e) {
                    System.err.println("Error al cerrar recursos: " + e.getMessage());
                }
            }

        }
        else{System.out.println("Este usuario no tiene permisos para agregar videojuegos.");}

        return resultado;
    }



}

