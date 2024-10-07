package Borderlands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class BorderlandsLootSystem {
    
    private static final String[] TIPOS = {"Arma", "Escudo", "Modificador"};
    private static final String[] RAREZAS = {"Común", "Poco Común", "Raro", "Épico", "Legendario"};
    
    public static Map<String, Object> generarBotin() {
        Random random = new Random();
        
        String tipo = TIPOS[random.nextInt(TIPOS.length)];
        
        String rareza = RAREZAS[random.nextInt(RAREZAS.length)];
        
        Map<String, Object> botin = new HashMap<>();
        botin.put("tipo", tipo);
        botin.put("rareza", rareza);
        
        switch (tipo) {
            case "Arma":
                botin.put("daño", random.nextInt(10, 101)); // Daño entre 10 y 100
                botin.put("munición", random.nextInt(1, 101)); // Munición entre 1 y 100
                break;
            case "Escudo":
                botin.put("absorción", random.nextInt(5, 101)); // Absorción entre 5 y 100
                botin.put("durabilidad", random.nextInt(20, 201)); // Durabilidad entre 20 y 200
                break;
            case "Modificador":
                botin.put("mejora de habilidad", random.nextInt(1, 11)); // Mejora de habilidad entre 1 y 10
                botin.put("duración", random.nextInt(30, 181)); // Duración entre 30 y 180 segundos
                break;
        }
        
        return botin;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Map<String, Object>> lootList = new ArrayList<>();
        
        boolean continuar = true;
        
        System.out.println("¡Bienvenido al sistema de botín de Borderlands!");
        
        while (continuar) {
           
            System.out.println("Has derrotado a un enemigo... ¡Buscando botín!");
            Map<String, Object> botin = generarBotin();
            lootList.add(botin);
        
            System.out.println("¡Has encontrado un botín!");
            System.out.println("Tipo: " + botin.get("tipo"));
            System.out.println("Rareza: " + botin.get("rareza"));
            
            switch ((String) botin.get("tipo")) {
                case "Arma":
                    System.out.println("Daño: " + botin.get("daño"));
                    System.out.println("Munición: " + botin.get("munición"));
                    break;
                case "Escudo":
                    System.out.println("Absorción: " + botin.get("absorción"));
                    System.out.println("Durabilidad: " + botin.get("durabilidad"));
                    break;
                case "Modificador":
                    System.out.println("Mejora de habilidad: " + botin.get("mejora de habilidad"));
                    System.out.println("Duración: " + botin.get("duración"));
                    break;
            }
            
           
            System.out.print("¿Deseas seguir enfrentándote a enemigos para obtener más botín? (s/n): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
        
      
        System.out.println("\nResumen del botín obtenido:");
        for (Map<String, Object> loot : lootList) {
            System.out.println("Tipo: " + loot.get("tipo") + ", Rareza: " + loot.get("rareza"));
        }
        
        scanner.close();
        System.out.println("¡Gracias por jugar!");
    }
}
