package Juego;

import java.util.ArrayList;

public class Inventario {
    private ArrayList<String> items;

    public Inventario() {
        items = new ArrayList<>();
    }

    public void agregarItem(String item) {
        items.add(item);
        System.out.println(item + " ha sido agregado al inventario.");
    }

    public void mostrarItems() {
        System.out.println("Ítems en el inventario:");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }
}
