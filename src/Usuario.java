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

    public String getUsuario() {
        return usuario;
    }

    public void agregarJuegosBiblioteca(Integer id) {
        try (Connection conexion = obtenerConexion()) {
            PreparedStatement insert = conexion.prepareStatement("SELECT * FROM juegos WHERE id_juego = ?");
            insert.setInt(1, id);
            ResultSet resultado = insert.executeQuery();
            while (resultado.next()) {
                biblioteca.add(resultado.getInt("id_juego"));
                System.out.println("Agregaste correctamente: " + resultado.getString("titulo") + " a tu biblioteca");
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar Juego: " + e.getMessage());
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
        if (!amigos.contains(nombreAmigo)){
            amigos.add(nombreAmigo);
            System.out.println("Ahora eres amigo de " + nombreAmigo.getUsuario());
        }else {
            System.out.println("Ya eres amigo de " + nombreAmigo.getUsuario());
        }
    }

    public void queJuegosTenes() {
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
            System.out.println("Lista de Juegos en la Biblioteca de " + getUsuario());
            System.out.println();
            for (String columna : columnas) {
                if (columna.equals("id_juego")){
                    System.out.printf("%-10s",columna);
                }
                else{System.out.printf("%-30s", columna);}
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));

            // Juegos
            for (int videojuego : biblioteca){
                PreparedStatement stmtDatos = conexion.prepareStatement("SELECT * FROM juegos WHERE id_juego = ?");
                stmtDatos.setInt(1, videojuego);
                ResultSet rsDatos = stmtDatos.executeQuery();
                while (rsDatos.next()){
                    for (String columna : columnas) {
                        if (columna.equals("id_juego")){
                            System.out.printf("%-10s",rsDatos.getString(columna));
                        }
                        else{System.out.printf("%-30s", rsDatos.getString(columna));}
                    }
                    System.out.println();
                }
            }
            System.out.println("-".repeat(30 * columnas.size()));

        }catch (SQLException e) {System.err.println("Error al obtener los datos de la persona: " + e.getMessage());}
    }

    @Override
    public int cantJuegos(){
        return biblioteca.size();
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
            System.out.println("Lista de Juegos en Biblioteca de " + getUsuario() + ":");
            for (String columna : columnas) {
                if (columna.equals("id_juego")){
                    System.out.printf("%-10s",columna);
                }
                else{System.out.printf("%-30s", columna);}
            }
            System.out.println();
            System.out.println("-".repeat(30 * columnas.size()));

            // Juegos
            for (int videojuego : biblioteca){
                PreparedStatement stmtDatos = conexion.prepareStatement("SELECT * FROM juegos WHERE titulo LIKE ? And id_juego = ?");
                stmtDatos.setString(1, "%"+nombreJuego+"%");
                stmtDatos.setInt(2, videojuego);
                ResultSet rsDatos = stmtDatos.executeQuery();
                while (rsDatos.next()) {
                    for (String columna : columnas) {
                        if (columna.equals("id_juego")) {
                            System.out.printf("%-10s", rsDatos.getString(columna));
                        } else {
                            System.out.printf("%-30s", rsDatos.getString(columna));
                        }
                    }System.out.println();
                }
            }
            System.out.println("-".repeat(30 * columnas.size()));
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos del juego: " + e.getMessage());}
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

    public void insertarJuegos(String titulo, int id_genero, String lanzamiento, String desarrollador) {
        Connection conn = null;
        PreparedStatement pstmt = null;
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
                    System.out.println(rowsAffected + " juego " + titulo + " insertado correctamente.");

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

    }



}

