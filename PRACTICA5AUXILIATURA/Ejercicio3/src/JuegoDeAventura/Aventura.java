package JuegoDeAventura;

import java.util.ArrayList;
import java.util.List;

public class Aventura {
    private List<Tarea> tareas = new ArrayList<>();

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void iniciar() {
        for (Tarea tarea : tareas) {
            tarea.ejecutar();
        }
    }
}
