package SistemaDeNotificaciones;

@FunctionalInterface
public interface EventoNotificacion {
    void notificar(String mensaje);
}
