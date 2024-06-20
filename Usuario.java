import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Usuario implements Biblioteca{
    private String nombreUsuario;
    private String mail;
    private String contrasenia;
    private Set<String> biblioteca = new HashSet<>();
    private Set<Usuario> amigos = new HashSet<>();

    public void Usuario(String nombreUsuario, String mail, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    public Set<String> getBiblioteca() {
        return biblioteca;
    }
    public String getMail(){
        return mail;
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
            if(juego.contains(nombreJuego)){
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
