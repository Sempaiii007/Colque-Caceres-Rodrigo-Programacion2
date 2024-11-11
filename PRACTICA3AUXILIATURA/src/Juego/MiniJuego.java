package Juego;

import java.util.Random;
import java.util.Scanner;

public class MiniJuego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("¡Bienvenido al Laverinto!");
        System.out.println("Elige la clase de tu personaje: 1. Mago 2. Guerrero 3. Arquero");
        int opcionPersonaje = scanner.nextInt();

        Personaje personaje;

        switch (opcionPersonaje) {
            case 1:
                personaje = new Mago("Mago", random.nextInt(10) + 1, 150, 50);
                break;
            case 2:
                personaje = new Guerrero("Guerrero", random.nextInt(10) + 1, 200, 30);
                break;
            case 3:
                personaje = new Arquero("Arquero", random.nextInt(10) + 1, 140, 40);
                break;
            default:
                System.out.println("Opción no válida, serás un Mago por defecto.");
                personaje = new Mago("Mago", random.nextInt(10) + 1, 150, 50);
                break;
        }

        int nivel = 1;
        boolean juegoActivo = true;

        while (juegoActivo) {
            Enemigo enemigo;

            
            switch (nivel) {
                case 1:
                    enemigo = new Zombie();
                    System.out.println("¡Has entrado en el nivel 1! Te encontraste a un Zombie.");
                    break;
                case 2:
                    enemigo = new Vampiro();
                    System.out.println("¡Has entrado en el nivel 2! Te encontraste a un Vampiro.");
                    break;
                case 3:
                    enemigo = new Jefe("Jefe", 150, 15, 1.5);
                    System.out.println("¡Has entrado en el nivel 3! Te encontraste con Bahamut jefe del laverinto.");
                    break;
                default:
                    enemigo = null;
                    break;
            }

            if (enemigo instanceof Jefe) {
                ((Jefe) enemigo).hablar();
            }

            while (personaje.getPuntosDeVida() > 0 && enemigo.estaVivo()) {
                System.out.println("\nElige una acción: 1. Atacar 2. Curar 3. Mostrar estado 4. Agregar ítem 5. Mostrar inventario");
                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        if (personaje instanceof Mago) {
                            ((Mago) personaje).lanzarHechizo();
                        } else if (personaje instanceof Guerrero) {
                            ((Guerrero) personaje).atacar();
                        } else if (personaje instanceof Arquero) {
                            ((Arquero) personaje).dispararFlecha();
                        }

                        int dañoPersonaje = random.nextInt(11) + 10;
                        enemigo.recibirDaño(dañoPersonaje);
                        System.out.println(personaje.getNombre() + " inflige " + dañoPersonaje + " de daño al enemigo.");
                        System.out.println("Vida del enemigo: " + enemigo.getPuntosDeVida()); 
                        break;
                    case 2:
                        personaje.curar();
                        break;
                    case 3:
                        personaje.mostrarEstado();
                        enemigo.mostrarEstado();
                        break;
                    case 4:
                        System.out.println("Escribe el nombre del ítem que quieres equipar:");
                        scanner.nextLine();
                        String item = scanner.nextLine();
                        personaje.agregarItem(item);
                        break;
                    case 5:
                        personaje.mostrarItems();
                        break;
                    default:
                        System.out.println("Acción no válida.");
                }

                if (enemigo.estaVivo()) {
                    int dañoEnemigo = enemigo.atacar();
                    personaje.recibirDaño(dañoEnemigo);
                    System.out.println("El enemigo inflige " + dañoEnemigo + " de daño a " + personaje.getNombre() + ".");
                }

                if (!enemigo.estaVivo()) {
                    System.out.println("¡Has derrotado al enemigo!");
                    nivel++;
                    break;
                }
            }

            if (personaje.getPuntosDeVida() <= 0) {
                System.out.println(personaje.getNombre() + " ha sido derrotado.");
                juegoActivo = false;
            }

            
            if (nivel > 3) {
                System.out.println("¡Felicidades! Has completado todos los niveles.");
                juegoActivo = false;
            }
        }

        scanner.close();
    }
}
