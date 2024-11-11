package JuegoDeCarreras;

public class Moto extends Vehiculo {
    public Moto(String marca, String modelo, int velocidadMaxima) {
        super(marca, modelo, velocidadMaxima);
    }

    @Override
    public void acelerar() {
        if (velocidadActual < velocidadMaxima) {
            velocidadActual += 15;
            System.out.println("La moto está acelerando... Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("La moto ha alcanzado su velocidad máxima.");
        }
    }

    @Override
    public void activarTurbo() {
        velocidadActual += 30;
        if (velocidadActual > velocidadMaxima) velocidadActual = velocidadMaxima;
        System.out.println("Turbo activado en la moto! Velocidad actual: " + velocidadActual + " km/h");
    }
}



