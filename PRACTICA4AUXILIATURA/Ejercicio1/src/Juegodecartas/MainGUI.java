package Juegodecartas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class MainGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Juego de Cartas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(8, 1));

        JLabel label = new JLabel("Elija una acción:");
        panel.add(label);

        // Botón para obtener una mano de 5 cartas aleatorias
        JButton manoButton = new JButton("Obtener Mano de 5 Cartas");
        panel.add(manoButton);

        JLabel manoLabel = new JLabel("Mano: ");
        panel.add(manoLabel);

        // Instanciamos el mazo y barajamos
        Mazo mazo = new Mazo();
        
        // Variable para la mano
        final List<Carta> mano = new ArrayList<>();
        final JPanel cartasPanel = new JPanel();
        panel.add(cartasPanel);

        manoButton.addActionListener(e -> {
            mano.clear();
            mano.addAll(mazo.obtenerMano());

            // Limpiar el panel de cartas anteriores
            cartasPanel.removeAll();
            cartasPanel.setLayout(new GridLayout(1, mano.size()));  // Ajusta el layout según el número de cartas

            // Mostrar botones para cada carta de la mano
            for (Carta carta : mano) {
                JButton cartaButton = new JButton(carta.toString());

                // Establecer un tamaño más grande para el botón
                cartaButton.setPreferredSize(new Dimension(150, 50)); // Tamaño preferido de 150x50 píxeles

                cartaButton.addActionListener(actionEvent -> {
                    carta.jugar();  // Jugar la carta al hacer clic
                    manoLabel.setText("Carta jugada: " + carta);
                });

                cartasPanel.add(cartaButton);  // Agregar el botón de la carta al panel
            }

            // Actualizar la interfaz
            cartasPanel.revalidate();
            cartasPanel.repaint();
            manoLabel.setText("Mano: " + mostrarMano(mano));
        });

        // Mostrar la interfaz
        frame.setVisible(true);
    }

    // Método para mostrar la mano de cartas en formato de texto
    public static String mostrarMano(List<Carta> mano) {
        StringBuilder manoString = new StringBuilder();
        for (Carta carta : mano) {
            manoString.append(carta).append(", ");
        }
        return manoString.toString();
    }
}



