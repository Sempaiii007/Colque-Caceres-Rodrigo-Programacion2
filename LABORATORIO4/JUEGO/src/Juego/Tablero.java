package Juego;//by ELRODRIGOADDDDD :)

public class Tablero {
    private final Ficha[][] tablero; // Se hace final :)

    public Tablero(int filas, int columnas) {
        tablero = new Ficha[filas][columnas];
        // Inicializar todas las posiciones del tablero
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = null; // Inicializar con null o con una ficha vacía:)
            }
        }
    }

    // Método para agregar una ficha en una posición:)
    public void agregarFicha(Ficha ficha) {
        tablero[ficha.getFila()][ficha.getColumna()] = ficha;
    }

    // Método para obtener una ficha en una posición específica:)
    public Ficha obtenerFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    // Método para imprimir el tablero usando un bucle mejorado:)
    public void imprimirTablero() {
        for (Ficha[] fila : tablero) {
            for (Ficha ficha : fila) {
                if (ficha != null) {
                    System.out.print(ficha.getValor() + " ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
