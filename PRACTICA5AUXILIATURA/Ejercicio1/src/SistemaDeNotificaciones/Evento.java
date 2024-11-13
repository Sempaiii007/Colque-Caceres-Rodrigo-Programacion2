package SistemaDeNotificaciones;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private List<EventoNotificacion> notificaciones = new ArrayList<>();

    public Evento(String nombre) {
        this.nombre = nombre;
    }

    public void registrarNotificacion(EventoNotificacion notificacion) {
        notificaciones.add(notificacion);
    }

    public void activar() {
        for (EventoNotificacion notificacion : notificaciones) {
            notificacion.notificar("Evento activado: " + nombre);
        }
    }
}
