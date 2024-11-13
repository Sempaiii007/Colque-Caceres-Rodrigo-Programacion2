package FiltroDeObjetos;

import java.util.ArrayList;
import java.util.List;

public class MainInventario {
    private List<Objeto> objetos = new ArrayList<>();

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public List<Objeto> filtrarObjetos(FiltroObjeto filtro) {
        List<Objeto> resultado = new ArrayList<>();
        for (Objeto objeto : objetos) {
            if (filtro.filtrar(objeto)) {
                resultado.add(objeto);
            }
        }
        return resultado;
    }
}
