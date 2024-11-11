package SimulacionDeGranja;

public abstract class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public abstract void hacerSonido();
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + " años");
    }

    public abstract void realizarTrucoEspecial();
}
