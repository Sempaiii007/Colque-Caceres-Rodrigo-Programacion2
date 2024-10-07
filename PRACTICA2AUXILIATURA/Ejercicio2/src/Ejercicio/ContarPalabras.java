package Ejercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContarPalabras {

    public static int contarPalabrasConLetra(List<String> palabras, char letra) {
        int contador = 0;
        letra = Character.toLowerCase(letra);
        for (String palabra : palabras) {
            if (palabra != null && !palabra.isEmpty() && Character.toLowerCase(palabra.charAt(0)) == letra) {
                contador++;
            }
        }

        return contador;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listaDePalabras = new ArrayList<>();
        String palabra;

        System.out.println("Introduce las palabras (escribe 'fin' para terminar):");
        
        while (true) {
            palabra = scanner.nextLine();
            if (palabra.equalsIgnoreCase("fin")) {
                break; 
            }
            listaDePalabras.add(palabra); 
        }

       
        System.out.print("Introduce la letra con la que deben comenzar las palabras: ");
        char letraBuscada = scanner.nextLine().charAt(0);

        int cantidad = contarPalabrasConLetra(listaDePalabras, letraBuscada);
        System.out.println("Cantidad de palabras que comienzan con '" + letraBuscada + "': " + cantidad);
        
        scanner.close(); 
    } 
}
