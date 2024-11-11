package JuegoDeCarreras;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int velocidadMaxima;
    protected int velocidadActual;

    public Vehiculo(String marca, String modelo, int velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
    }

    // Método abstracto para acelerar (cada vehículo lo implementa de forma diferente)
    public abstract void acelerar();
    
    // Método para frenar
    public void frenar() {
        if (velocidadActual > 0) {
            velocidadActual -= 10;
            System.out.println("Frenando... Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("El vehículo ya está detenido.");
        }
    }

    // Método para activar el turbo (se puede sobrecargar en las clases derivadas)
    public void activarTurbo() {
        System.out.println("El vehículo no tiene turbo.");
    }

    // Método para mostrar la información del vehículo
    public void mostrarInfo() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Velocidad Máxima: " + velocidadMaxima);
    }
}


