package Juego;

class Zombie extends Enemigo {
    public Zombie() {
        super("Zombie", 50, 10);
    }

    @Override
    public int atacar() {
        int daño = super.atacar();
        recibirDaño(-5); // Regenerar 5 puntos de vida
        return daño;
    }
}