package SimulacionDeGranja;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Simulación de Granjas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);

        // Crear un panel donde se colocarán los componentes
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(7, 1));

        JLabel labelInfo = new JLabel("Elija un animal:");
        panel.add(labelInfo);

        // Pedir al usuario que seleccione el tipo de animal
        Animal animal;
        String tipoAnimal = JOptionPane.showInputDialog("Escriba 'Vaca' o 'Oveja' para elegir el animal:");

        // Selección del tipo de animal y creación de instancia
        if ("Vaca".equalsIgnoreCase(tipoAnimal)) {
            animal = new Vaca("Margarita", 5);
        } else if ("Oveja".equalsIgnoreCase(tipoAnimal)) {
            animal = new Oveja("Luna", 3);
        } else {
            JOptionPane.showMessageDialog(frame, "Tipo de animal no válido. Saliendo del programa.");
            return; // Salir si el tipo de animal es incorrecto
        }

        // Mostrar la información del animal (nombre y edad)
        JLabel nombreEdadLabel = new JLabel("Nombre: " + animal.nombre + ", Edad: " + animal.edad + " años");
        panel.add(nombreEdadLabel);

        // Botón para hacer sonido
        JButton sonidoButton = new JButton("Hacer Sonido");
        panel.add(sonidoButton);
        sonidoButton.addActionListener(e -> {
            animal.hacerSonido();
        });

        // Botón para producir (leche o lana)
        JButton producirButton = new JButton("Producir");
        panel.add(producirButton);
        producirButton.addActionListener(e -> {
            if (animal instanceof Productor) {
                ((Productor) animal).producir();
            }
        });
        JButton trucoEspecialButton = new JButton("Realizar Truco Especial");
        panel.add(trucoEspecialButton);
        trucoEspecialButton.addActionListener(e -> {
            animal.realizarTrucoEspecial();
        });


        // Mostrar la ventana
        frame.setVisible(true);
    }
}
