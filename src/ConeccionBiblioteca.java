import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConeccionBiblioteca implements Biblioteca {
    private Set<Usuario> propietarios = new HashSet<>();
    private Set<String> biblioCompartida = new HashSet<>();

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

    @Override
    public int cantJuegos() {
        return biblioCompartida.size();
    }

    @Override
    public void queJuegosTenes() {
        for (String videojuego : biblioCompartida){
            System.out.println(videojuego);
        };
    }

    @Override
    public List<String> filtroNombre(String nombreJuego) {
        List<String> listaFiltrada = new ArrayList<>();
        for(String juego : biblioCompartida){
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
