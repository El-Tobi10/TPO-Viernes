import java.util.List;

public interface Biblioteca {
    public int cantJuegos();
    public void queJuegosTenes();
    public List<String> filtroNombre(String nombreJuego);
    public List<String> filtroGenero(String nombreGenero);
}
