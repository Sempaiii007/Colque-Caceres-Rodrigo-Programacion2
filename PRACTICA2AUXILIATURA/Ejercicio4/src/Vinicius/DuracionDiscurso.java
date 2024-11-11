package Vinicius;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DuracionDiscurso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        int K = 0;
        boolean entradaValida = false;

      
        while (!entradaValida) {
            try {
                System.out.print("Introduce el número de directores (N): ");
                N = scanner.nextInt();
                if (N < 1 || N > 100) {
                    System.out.println("Por favor, introduce un número de directores válido entre 1 y 100.");
                    continue;
                }
                entradaValida = true; 
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ser un número entero.");
                scanner.next(); 
            }
        }

        entradaValida = false; 

      
        while (!entradaValida) {
            try {
                System.out.print("Introduce la duración máxima de la reunión (K): ");
                K = scanner.nextInt();
                if (K < 1 || K > 1000) {
                    System.out.println("Por favor, introduce una duración válida entre 1 y 1000.");
                    continue;
                }
                entradaValida = true; 
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Debe ser un número entero.");
                scanner.next(); 
            }
        }

        int maxDuration = (K - (N - 1)) / N; 
        if (maxDuration < 1) {
            maxDuration = 1; 
        }

        System.out.println("La duración máxima del discurso de cada director es: " + maxDuration + " minutos.");
        scanner.close();
    }
}
