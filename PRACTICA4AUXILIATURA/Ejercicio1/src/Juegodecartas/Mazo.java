package Juegodecartas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
    private List<Carta> cartasNormales = new ArrayList<>();
    private List<Carta> cartasEspeciales = new ArrayList<>();
    
    public Mazo() {
        String[] palos = {"Corazones", "Diamantes", "Picas", "Tréboles"};
        String[] valoresNormales = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] valoresEspeciales = {"Rey", "Reina", "Príncipe", "As"};
        
        // Crear cartas normales
        for (String palo : palos) {
            for (String valor : valoresNormales) {
                cartasNormales.add(new CartaNormal(valor, palo));
            }
        }
        
        // Crear cartas especiales
        for (String palo : palos) {
            for (String valor : valoresEspeciales) {
                cartasEspeciales.add(new CartaEspecial(valor, palo));
            }
        }
        
        // Barajar ambas listas de cartas
        Collections.shuffle(cartasNormales);
        Collections.shuffle(cartasEspeciales);
    }

    // Obtener una mano de 5 cartas, mezclando normales y especiales
    public List<Carta> obtenerMano() {
        List<Carta> mano = new ArrayList<>();
        // Tomamos 3 cartas normales y 2 especiales (como ejemplo)
        for (int i = 0; i < 3; i++) {
            mano.add(cartasNormales.remove(0));
        }
        for (int i = 0; i < 2; i++) {
            mano.add(cartasEspeciales.remove(0));
        }
        Collections.shuffle(mano); // Mezclamos la mano para que no se vea ordenada
        return mano;
    }
}

