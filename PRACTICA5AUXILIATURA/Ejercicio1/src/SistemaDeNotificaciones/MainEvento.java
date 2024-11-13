package SistemaDeNotificaciones;

public class MainEvento {
    public static void main(String[] args) {
        Evento evento = new Evento("Lanzamiento de Fuego");

        evento.registrarNotificacion(mensaje -> System.out.println("Notificación recibida: " + mensaje));
        evento.registrarNotificacion(mensaje -> System.out.println("Otra notificación: " + mensaje));

        evento.activar();
    }
}
