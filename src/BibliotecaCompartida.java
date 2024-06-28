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
    private Set<Usuario> propietarios = new HashSet<>();
    private Set<Integer> biblioCompartida = new HashSet<>();

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
            for (int videojuego : biblioCompartida){
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
    public int cantJuegos() {
        return biblioCompartida.size();
    }


    @Override
    public void buscarxNombre(String nombreJuego) {
        try (Connection conexion = obtenerConexion()){
            PreparedStatement statement = conexion.prepareStatement("SELEC * FROM juegos WHERE tiutlo = LIKE %?%");
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

}

