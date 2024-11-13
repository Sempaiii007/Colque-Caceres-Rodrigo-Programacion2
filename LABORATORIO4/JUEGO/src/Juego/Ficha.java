//by ELRODRIGOADDDDD :)
package Juego;


public class Ficha {
    private final String valor;  // Campo que almacena el valor de la ficha
    private final int fila;      // Campo que almacena la fila de la ficha
    private final int columna;   // Campo que almacena la columna de la ficha

    // Constructor
    public Ficha(String valor, int fila, int columna) {
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

    // Getter para el valor
    public String getValor() {
        return valor;
    }

    // Getter para la fila
    public int getFila() {
        return fila;
    }

    // Getter para la columna
    public int getColumna() {
        return columna;
    }

    // Método toString() para representar la ficha como cadena
    @Override
    public String toString() {
        return "Ficha{" +
               "valor='" + valor + '\'' +
               ", fila=" + fila +
               ", columna=" + columna +
               '}';
    }
}