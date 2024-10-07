package Juego;

public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int puntosDeVida, int fuerza) {
        super(nombre, nivel, puntosDeVida);
        this.fuerza = fuerza;
    }

    public void atacar() {
        System.out.println(getNombre() + " ha realizado un ataque!");
    }

    public int getFuerza() {
        return fuerza;
    }
}