package SimulacionDeGranja;

public class Oveja extends Animal implements Productor {

    public Oveja(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("La oveja hace: Beee!");
    }

    @Override
    public void producir() {
        System.out.println("La oveja está produciendo lana.");
    }

    @Override
    public void realizarTrucoEspecial() {
        System.out.println("La oveja realiza un giro en el aire!");
    }
}
