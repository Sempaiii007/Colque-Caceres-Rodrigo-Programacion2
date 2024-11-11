package JuegoDeCarreras;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainGUI {
    public static void main(String[] args) {
   
        JFrame frame = new JFrame("Simulación de Vehículos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);  

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(6, 1));

        JLabel labelInfo = new JLabel("Elija un vehículo:");
        panel.add(labelInfo);

        Vehiculo vehiculo;
        String tipoVehiculo = JOptionPane.showInputDialog("Escriba 'Coche' o 'Moto' para elegir el vehículo:");

       
        if ("Coche".equalsIgnoreCase(tipoVehiculo)) {
            vehiculo = new Coche("HONDA", "NSX1999", 180);
        } else if ("Moto".equalsIgnoreCase(tipoVehiculo)) {
            vehiculo = new Moto("YAMAHA", "YZF", 220);
        } else {
            JOptionPane.showMessageDialog(frame, "Tipo de vehículo no válido. Saliendo del programa.");
            return; 
        }


        JLabel marcaModeloLabel = new JLabel("Marca: " + vehiculo.marca + ", Modelo: " + vehiculo.modelo);
        panel.add(marcaModeloLabel);

        JLabel velocidadLabel = new JLabel("Velocidad actual: 0 km/h");
        panel.add(velocidadLabel);


        JButton acelerarButton = new JButton("Acelerar");
        panel.add(acelerarButton);
        acelerarButton.addActionListener(e -> {
            vehiculo.acelerar();
            velocidadLabel.setText("Velocidad actual: " + vehiculo.velocidadActual + " km/h");
        });


        JButton frenarButton = new JButton("Frenar");
        panel.add(frenarButton);
        frenarButton.addActionListener(e -> {
            vehiculo.frenar();
            velocidadLabel.setText("Velocidad actual: " + vehiculo.velocidadActual + " km/h");
        });


        JButton turboButton = new JButton("Activar Turbo");
        panel.add(turboButton);
        turboButton.addActionListener(e -> {
            vehiculo.activarTurbo();
            velocidadLabel.setText("Velocidad actual: " + vehiculo.velocidadActual + " km/h");
        });
        JButton resetButton = new JButton("Resetear");
        panel.add(resetButton);
        resetButton.addActionListener(e -> {
            vehiculo.velocidadActual = 0; // Resetear la velocidad del vehículo
            velocidadLabel.setText("Velocidad actual: " + vehiculo.velocidadActual + " km/h");
        });


        frame.setVisible(true);
    }
}


