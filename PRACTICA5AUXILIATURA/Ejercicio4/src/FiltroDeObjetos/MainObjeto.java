package FiltroDeObjetos;

import java.util.List;

public class MainInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        inventario.agregarObjeto(new Objeto("Espada", 5));
        inventario.agregarObjeto(new Objeto("Escudo", 10));
        inventario.agregarObjeto(new Objeto("Poción", 1));

        List<Objeto> objetosPesados = inventario.filtrarObjetos(objeto -> objeto.getPeso() > 5);
        System.out.println("Objetos pesados:");
        for (Objeto objeto : objetosPesados) {
            System.out.println(objeto.getNombre());
        }
    }
}
