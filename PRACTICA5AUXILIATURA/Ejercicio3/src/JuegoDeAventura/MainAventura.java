package JuegoDeAventura;

public class MainAventura {
    public static void main(String[] args) {
        Aventura aventura = new Aventura();

        aventura.agregarTarea(() -> System.out.println("Tarea 1: Recoger el arma."));
        aventura.agregarTarea(() -> System.out.println("Tarea 2: Derrotar al enemigo."));
        aventura.agregarTarea(() -> System.out.println("Tarea 3: Abrir el cofre."));

        aventura.iniciar();
    }
}
