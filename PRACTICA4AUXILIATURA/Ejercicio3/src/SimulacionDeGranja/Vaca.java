package SimulacionDeGranja;

public class Vaca extends Animal implements Productor {

    public Vaca(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println("La vaca hace: Muuu!");
    }

    @Override
    public void producir() {
        System.out.println("La vaca está produciendo leche.");
    }

    @Override
    public void realizarTrucoEspecial() {
        System.out.println("La vaca realiza un salto espectacular!");
    }
}
