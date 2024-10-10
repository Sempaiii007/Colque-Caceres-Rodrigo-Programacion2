package Juego;

public class Enemigo {
    private String nombre;
    private int puntosDeVida;
    private int dañoBase;
    private static final int VIDA_MAXIMA = 50;
    public Enemigo(String nombre, int puntosDeVida, int dañoBase) {
        this.nombre = nombre;
        this.puntosDeVida = Math.min(puntosDeVida, VIDA_MAXIMA);
        this.dañoBase = dañoBase;
    }

    public int atacar() {
        return dañoBase;
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }

        if (puntosDeVida > VIDA_MAXIMA) {
            puntosDeVida = VIDA_MAXIMA;
        }
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public void mostrarEstado() {
        System.out.println("Enemigo: " + nombre + ", Puntos de Vida: " + puntosDeVida + "/" + VIDA_MAXIMA);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }
}
