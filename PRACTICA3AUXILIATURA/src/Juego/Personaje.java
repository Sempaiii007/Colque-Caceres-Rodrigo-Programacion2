package Juego;

public class Personaje {
    private String nombre;
    private int nivel;
    private int puntosDeVida;
    private Inventario inventario;

    public Personaje(String nombre, int nivel, int puntosDeVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosDeVida = puntosDeVida;
        this.inventario = new Inventario();
    }

    public void mostrarEstado() {
        System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Puntos de Vida: " + puntosDeVida);
    }

    public void recibirDaño(int daño) {
        puntosDeVida -= daño;
        if (puntosDeVida < 0) {
            puntosDeVida = 0;
        }
        System.out.println(nombre + " recibió " + daño + " de daño. Puntos de vida restantes: " + puntosDeVida);
    }

    public void curar() {
        puntosDeVida += 20;
        System.out.println(nombre + " ha sido curado. Puntos de vida actuales: " + puntosDeVida);
    }

    public void agregarItem(String item) {
        inventario.agregarItem(item);
    }

    public void mostrarItems() {
        inventario.mostrarItems();
    }


    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public String getNombre() {
        return nombre;
    }
}