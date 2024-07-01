package org.example;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BibliotecaCompartida extends Conexion implements Biblioteca {
    private final Set<Usuario> propietarios = new HashSet<>();
    private final Set<Integer> biblioCompartida = new HashSet<>();

    public void armarBiblioteca(Usuario usuario1, Usuario usuario2){
        if (usuario1.revisarAmigos(usuario2) && usuario2.revisarAmigos(usuario1)){
            if (usuario1.getBiblioteca().isEmpty() || usuario2.getBiblioteca().isEmpty()){
                System.out.println("No es posible armar/agregar juegos en la biblioteca ya que la biblioteca del usuario esta vacia");
            }
            else{
                propietarios.add(usuario1);
                propietarios.add(usuario2);
                biblioCompartida.addAll(usuario1.getBiblioteca());
                biblioCompartida.addAll(usuario2.getBiblioteca());
            }
        }
        else System.out.println("Los usuarios no son amigos para poder compartir sus bibliotecas");

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
            for (int videojuego : biblioCompartida){
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
        } catch (SQLException e) {
            System.err.println("Error al obtener los datos de la persona: " + e.getMessage());
        }
    }

    @Override
    public int cantJuegos() {
        return biblioCompartida.size();
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
            for (int videojuego : biblioCompartida){
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
}
