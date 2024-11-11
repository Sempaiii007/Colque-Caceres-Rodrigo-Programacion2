package JuegoDeCarreras;

public class Coche extends Vehiculo {
    public Coche(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        if (velocidadActual < velocidadMaxima) {
            velocidadActual += 10;
            System.out.println("El coche está acelerando... Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("El coche ha alcanzado su velocidad máxima.");
        }
    }

    @Override
    public void activarTurbo() {
        velocidadActual += 20;
        if (velocidadActual > velocidadMaxima) velocidadActual = velocidadMaxima;
        System.out.println("Turbo activado en el coche! Velocidad actual: " + velocidadActual + " km/h");
    }
}




