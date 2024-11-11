package Juegodecartas;

public class CartaNormal extends Carta {
    
    public CartaNormal(String valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("Carta normal jugada: " + this);
    }
}



