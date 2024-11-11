package Juego;

public class Mago extends Personaje {
    private int mana;

    public Mago(String nombre, int nivel, int puntosDeVida, int mana) {
        super(nombre, nivel, puntosDeVida);
        this.mana = mana;
    }

    public void lanzarHechizo() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(getNombre() + " ha lanzado un hechizo!");
        } else {
            System.out.println("No hay suficiente mana para lanzar el hechizo.");
        }
    }

    public int getMana() {
        return mana;
    }
}