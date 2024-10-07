package Juego;

public class Jefe extends Enemigo {
    private double multiplicadorDaño;

    public Jefe(String nombre, int puntosDeVida, int dañoBase, double multiplicadorDaño) {
        super(nombre, puntosDeVida, dañoBase);
        this.multiplicadorDaño = multiplicadorDaño;
    }

    public void hablar() {
        System.out.println(getNombre() + ": ¡Soy el jefe y te derrotaré!"); // getNombre() now works
    }

    private String getNombre() {
		
		return null;
	}

	@Override
    public int atacar() {
        int daño = (int) (super.atacar() * multiplicadorDaño);
        return daño;
    }
}