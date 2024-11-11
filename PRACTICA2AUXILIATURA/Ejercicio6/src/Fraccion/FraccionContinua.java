package Fraccion;

import java.util.Scanner;

public class FraccionContinua {

    // Método que calcula el numerador de la fracción continua Pn
    public static int calcularNumerador(int n) {
        int numerador = 1; // Inicializamos el numerador en 1
        int denominador = 1; // Inicializamos el denominador en 1
        
        // Iteramos desde n hacia atrás para calcular la fracción
        for (int i = 1; i <= n; i++) {
            int temp = numerador;
            numerador = denominador;
            denominador = temp + denominador; // La regla recursiva de la fracción
        }
        
        return denominador; // El numerador final es el denominador de la fracción calculada
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Mensaje para que el usuario ingrese el valor de N
        System.out.println("Introduce el valor de N: ");
        int N = scanner.nextInt();
        
        // Llamamos al método para calcular el numerador de la fracción Pn
        int resultado = calcularNumerador(N);
        
        // Imprimir el resultado
        System.out.println("El numerador de la fracción P" + N + " es: " + resultado);
        
        scanner.close();
    }
}
