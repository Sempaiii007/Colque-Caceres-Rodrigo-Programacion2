package Seven;

import java.util.Scanner;

public class MaximaLexicografica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Mensaje al usuario para introducir el número de elementos
        System.out.println("Introduce el número de elementos en la lista (N): ");
        int N = scanner.nextInt(); // Número de elementos en la lista
        
        // Crear la lista
        int[] lista = new int[N];
        int totalBits = 0;  // Suma de todos los bits de la lista

        // Mensaje al usuario para introducir los números de la lista
        System.out.println("Introduce los " + N + " números separados por espacios: ");
        for (int i = 0; i < N; i++) {
            lista[i] = scanner.nextInt();
            totalBits |= lista[i]; // Sumar los bits de todos los números usando OR bit a bit
        }

        // Maximizar los números lexicográficamente
        for (int i = 0; i < N; i++) {
            lista[i] = totalBits;  // Maximizar cada número con los bits disponibles
            totalBits &= ~lista[i];  // Eliminar los bits usados
        }

        // Imprimir el resultado
        System.out.println("Lista máxima lexicográficamente:");
        for (int i = 0; i < N; i++) {
            System.out.print(lista[i] + " ");
        }

        scanner.close();
    }
}

