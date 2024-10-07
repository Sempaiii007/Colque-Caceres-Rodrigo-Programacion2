package Juego;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        Mago mago = new Mago("Mago", random.nextInt(10) + 1, 100, 50);
        Jefe jefe = new Jefe("Jefe", 150, 15, 1.5);

        jefe.hablar();

        while (mago.getPuntosDeVida() > 0 && jefe.estaVivo()) {
            System.out.println("Elige una acción: 1. Lanzar hechizo 2. Curar 3. Mostrar estado");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    mago.lanzarHechizo();
                    int dañoMago = random.nextInt(11) + 10;
                    jefe.recibirDaño(dañoMago);
                    System.out.println("El mago inflige " + dañoMago + " de daño al jefe.");
                    break;
                case 2:
                    mago.curar();
                    break;
                case 3:
                    mago.mostrarEstado();
                    break;
                default:
                    System.out.println("Acción no válida.");
            }

            if (jefe.estaVivo()) {
                int dañoJefe = jefe.atacar();
                mago.recibirDaño(dañoJefe);
                System.out.println("El jefe inflige " + dañoJefe + " de daño al mago.");
            }

            mago.mostrarEstado();
            if (!jefe.estaVivo()) {
                System.out.println("¡Has derrotado al jefe!");
            }
        }

        if (mago.getPuntosDeVida() <= 0) {
            System.out.println("El mago ha sido derrotado.");
        }
    }
}