package Juego;

class Vampiro extends Enemigo {
    public Vampiro() {
        super("Vampiro", 50, 10);
    }

    @Override
    public int atacar() {
        int daño = super.atacar();
        return daño; // Puede implementar robar vida aquí si se desea
    }
}