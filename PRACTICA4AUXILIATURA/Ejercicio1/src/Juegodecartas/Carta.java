package Juegodecartas;

public abstract class Carta {
    protected String palo;
    protected String valor;  // Usamos un String para los valores (puede ser "2", "Reina", "Rey", etc.)

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    // Método abstracto que será implementado por las subclases
    public abstract void jugar();
    
    @Override
    public String toString() {
        return valor + " de " + palo;
    }
}
