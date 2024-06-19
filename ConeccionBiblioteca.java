import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConeccionBiblioteca implements Biblioteca {
    private Set<String> biblioCompartida = new HashSet<String>();

    public void armarBiblioteca(Set<String> biblio1, Set<String> biblio2){

    }

    @Override
    public int cantJuegos() {
        return 0;
    }

    @Override
    public void queJuegosTenes() {
        System.out.println("si");
    }

    @Override
    public List<String> filtroNombre(String nombreJuego) {
        return List.of();
    }

    @Override
    public List<String> filtroGenero(String nombreGenero) {
        return List.of();
    }
}
