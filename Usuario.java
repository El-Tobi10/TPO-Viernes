import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario implements Biblioteca{
    private String nombreUsuario;
    private String mail;
    private String contrasenia;
    private Set<String> biblioteca = new HashSet<String>();


    public void setUsuario(String nombreUsuario, String mail, String contrasenia, Set<String> biblioteca) {
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasenia = contrasenia;
        this.biblioteca = biblioteca;
    }

    public Set<String> getBiblioteca() {
        return biblioteca;
    }
    public void serAmigo(Usuario nombreAmigo){
        System.out.println("Ahora eres amigo de " + nombreAmigo);
    }

    @Override
    public int cantJuegos(){
        return biblioteca.size();
    }

    @Override
    public void queJuegosTenes() {
        for (String videojuego : biblioteca){
            System.out.println(videojuego);
        };
    }

    @Override
    public List<String> filtroNombre(String nombreJuego) {
        List<String> listaFiltrada = new ArrayList<>();
        for(String juego : biblioteca){
            if(juego.startsWith(nombreJuego)){
                listaFiltrada.add(juego);
            }
            else{continue;}
        }
        return listaFiltrada;
    }

    @Override
    public List<String> filtroGenero(String nombreGenero) {
        return List.of();
    }
}
