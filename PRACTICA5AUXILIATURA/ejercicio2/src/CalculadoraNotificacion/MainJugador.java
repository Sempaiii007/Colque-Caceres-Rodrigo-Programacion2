package CalculadoraNotificacion;

public class MainJugador {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Alice", 100);

        CalculadoraBonificacion doblePuntos = puntos -> puntos * 2;
        CalculadoraBonificacion bonus10 = puntos -> puntos + 10;

        jugador.aplicarBonificacion(doblePuntos);
        System.out.println("Puntos después del doble: " + jugador.getPuntos());

        jugador.aplicarBonificacion(bonus10);
        System.out.println("Puntos después del bonus de 10: " + jugador.getPuntos());
    }
}
