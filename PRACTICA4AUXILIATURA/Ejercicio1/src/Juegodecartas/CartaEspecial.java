package Juegodecartas;

public class CartaEspecial extends Carta {
    
    public CartaEspecial(String valor, String palo) {
        super(valor, palo);
    }

    @Override
    public void jugar() {
        System.out.println("Carta especial jugada: " + this);
    }
}




