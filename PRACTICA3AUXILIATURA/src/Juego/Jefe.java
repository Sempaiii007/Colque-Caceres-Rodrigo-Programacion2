package Juego;

public class Jefe extends Enemigo {
    private double fuerzaExtra;

    public Jefe(String nombre, int puntosDeVida, int dañoBase, double fuerzaExtra) {
        super(nombre, puntosDeVida, dañoBase);
        this.fuerzaExtra = fuerzaExtra;
    }

    @Override
    public int atacar() {
        return (int) (super.atacar() * fuerzaExtra);
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Fuerza Extra: " + fuerzaExtra);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public void hablar() {
        System.out.println("Soy Bahamut Jefe del laverinto, ¡prepárate para BATALLA!");
    }
}
