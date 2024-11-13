package Juego;//by ELRODRIGOADDDDD :)

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Interfaz {
    // Tamaño del tablero
    private static final int SIZE = 3;
    
    // Matriz de botones que representa las casillas del juego
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private String[][] boardState = new String[SIZE][SIZE];  // Matriz para almacenar el estado del tablero
    private char currentPlayer = 'X';  // Jugador actual (X u O)
    private Image xImage, oImage, backgroundImage;  // Imágenes para X, O y fondo
    private boolean gameOver = false;  // Variable para verificar si el juego terminó
    private JButton resetButton;  // Botón para reiniciar el juego
    
    // Constructor de la clase
    public Interfaz() {
        // Cargar las imágenes de X, O y el fondo desde la carpeta 'resources'
        try {
            // Cargar imágenes para X y O
            xImage = ImageIO.read(new File("resources/x_image.png"));
            oImage = ImageIO.read(new File("resources/o_image.png"));
            // Cargar imagen de fondo
            backgroundImage = ImageIO.read(new File("resources/backgroundd.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Crear el marco (ventana) de la interfaz
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(400, 450);  // Aumentamos el tamaño de la ventana para el botón de reinicio
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Establecer la acción de cierre
        frame.setLayout(new BorderLayout());  // Usar BorderLayout para colocar el panel con el fondo

        // Crear un panel para el fondo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo ajustada al tamaño del panel
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);  
            }
        };
        panel.setLayout(new GridLayout(SIZE, SIZE));  // Establecer el layout del panel de fondo
        frame.add(panel, BorderLayout.CENTER);  // Agregar el panel al centro del JFrame

        // Crear los botones para el tablero
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));  // Tamaño de los botones
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));  // Tamaño de la letra para cuando se muestra texto
                buttons[i][j].setContentAreaFilled(false);  // Hacer que el botón sea transparente
                buttons[i][j].setBorder(BorderFactory.createEmptyBorder());  // Quitar el borde del botón
                buttons[i][j].setOpaque(false);  // Hacer que el fondo del botón sea transparente

                // Acción cuando se hace clic en un botón
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) {
                            return;  // Si el juego terminó, no hacer nada
                        }

                        JButton source = (JButton) e.getSource();
                        if (source.getIcon() == null) {  // Solo si el botón no tiene una imagen
                            // Colocar la ficha del jugador actual
                            if (currentPlayer == 'X') {
                                source.setIcon(new ImageIcon(getScaledImage(xImage, source.getWidth(), source.getHeight())));  // Imagen de X
                                boardState[getButtonPosition(source)[0]][getButtonPosition(source)[1]] = "X";  // Guardar en la matriz
                            } else {
                                source.setIcon(new ImageIcon(getScaledImage(oImage, source.getWidth(), source.getHeight())));  // Imagen de O
                                boardState[getButtonPosition(source)[0]][getButtonPosition(source)[1]] = "O";  // Guardar en la matriz
                            }

                            // Comprobar si hay un ganador
                            if (checkWin()) {
                                JOptionPane.showMessageDialog(null, "¡Jugador " + currentPlayer + " ha ganado!", "¡Juego Terminado!", JOptionPane.INFORMATION_MESSAGE);
                                gameOver = true;  // Terminar el juego
                            } else if (isBoardFull()) {
                                JOptionPane.showMessageDialog(null, "¡Es un empate!", "¡Juego Terminado!", JOptionPane.INFORMATION_MESSAGE);
                                gameOver = true;  // Terminar el juego
                            } else {
                                // Cambiar al siguiente jugador
                                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            }
                        }
                    }
                });

                panel.add(buttons[i][j]);  // Agregar los botones al panel de fondo
            }
        }

        // Crear botón de "Jugar de nuevo"
        resetButton = new JButton("Jugar de nuevo");
        resetButton.setPreferredSize(new Dimension(400, 50));  // Ajustar el tamaño del botón
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  // Llamar al método para reiniciar el juego
            }
        });

        frame.add(resetButton, BorderLayout.SOUTH);  // Agregar el botón al borde sur del JFrame
        frame.setVisible(true);  // Hacer visible la ventana
    }

    // Método para redimensionar las imágenes al tamaño del botón
    private Image getScaledImage(Image originalImage, int width, int height) {
        return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // Método para obtener la posición del botón en la matriz
    private int[] getButtonPosition(JButton button) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == button) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};  // Si no se encuentra el botón
    }

    // Verificar si el jugador actual ha ganado
    private boolean checkWin() {
        // Comprobar filas y columnas
        for (int i = 0; i < SIZE; i++) {
            // Verificar filas
            if (boardState[i][0] != null && 
                boardState[i][0].equals(boardState[i][1]) && 
                boardState[i][1].equals(boardState[i][2]) && 
                !boardState[i][0].equals("")) {
                return true;  // Ganador en la fila
            }
            // Verificar columnas
            if (boardState[0][i] != null && 
                boardState[0][i].equals(boardState[1][i]) && 
                boardState[1][i].equals(boardState[2][i]) && 
                !boardState[0][i].equals("")) {
                return true;  // Ganador en la columna
            }
        }

        // Comprobar diagonales
        if (boardState[0][0] != null && 
            boardState[0][0].equals(boardState[1][1]) && 
            boardState[1][1].equals(boardState[2][2]) && 
            !boardState[0][0].equals("")) {
            return true;  // Ganador diagonal (izquierda a derecha)
        }
        if (boardState[0][2] != null && 
            boardState[0][2].equals(boardState[1][1]) && 
            boardState[1][1].equals(boardState[2][0]) && 
            !boardState[0][2].equals("")) {
            return true;  // Ganador diagonal (derecha a izquierda)
        }

        return false;
    }

    // Verificar si el tablero está lleno
    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardState[i][j] == null || boardState[i][j].equals("")) {  // Si alguna casilla está vacía
                    return false;
                }
            }
        }
        return true;
    }

    // Método para reiniciar el juego
    private void resetGame() {
        // Limpiar la matriz de estado
        boardState = new String[SIZE][SIZE];
        gameOver = false;
        currentPlayer = 'X';

        // Limpiar todos los botones
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setIcon(null);  // Quitar las imágenes de los botones
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());  // Crear la interfaz y empezar el juego
    }
} 