package Juego;

public class Arquero extends Personaje {
    private int destreza;

    public Arquero(String nombre, int nivel, int puntosDeVida, int destreza) {
        super(nombre, nivel, puntosDeVida);
        this.destreza = destreza;
    }

    public void dispararFlecha() {
        System.out.println(getNombre() + " ha disparado una flecha!");
    }

    public int getDestreza() {
        return destreza;
    }
}