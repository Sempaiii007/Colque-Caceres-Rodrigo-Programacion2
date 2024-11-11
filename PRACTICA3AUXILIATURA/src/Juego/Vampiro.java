package Juego;

class Vampiro extends Enemigo {
    private static final int VIDA_ROBADA = 5;

    public Vampiro() {
        super("Vampiro", 50, 10);
    }

    @Override
    public int atacar() {
        int daño = super.atacar();
        this.recibirDaño(-VIDA_ROBADA);
        return daño;
    }
}
