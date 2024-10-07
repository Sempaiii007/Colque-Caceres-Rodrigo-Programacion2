package Joyero;

import java.util.Scanner;

public class JoyeroNLogonia {

  
    public static int[][] rotarAntihorario(int[][] matriz) {
        int N = matriz.length;
        int[][] nuevaMatriz = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nuevaMatriz[N - j - 1][i] = matriz[i][j];
            }
        }
        return nuevaMatriz;
    }

    public static boolean matricesIguales(int[][] original, int[][] actual) {
        int N = original.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (original[i][j] != actual[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Introduce el número de filas y columnas (N): ");
        int N = scanner.nextInt();

        int[][] matrizOriginal = new int[N][N];
        int[][] matrizActual = new int[N][N];

      
        System.out.println("Introduce los valores de la matriz (de arriba hacia abajo, de izquierda a derecha):");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("Introduce el valor en la posición [" + i + "][" + j + "]: ");
                matrizOriginal[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            System.arraycopy(matrizOriginal[i], 0, matrizActual[i], 0, N);
        }

    
        int rotaciones = 0;

        while (rotaciones < 4) {
            if (matricesIguales(matrizOriginal, matrizActual)) {
                break; 
            }
            matrizActual = rotarAntihorario(matrizActual);
            rotaciones++;
        }

        System.out.println("Número de rotaciones en sentido antihorario necesarias: " + rotaciones);
        scanner.close();
    }
}

