package Grades;

import Grades.GradeManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear una instancia de GradeManager
        GradeManager gradeManager = new GradeManager();
        Scanner scanner = new Scanner(System.in);

        // Este bucle mantiene activo el menú del programa, permitiendo al usuario interactuar 
        // continuamente hasta que decida salir. Anteriormente, en clase, utilizamos una bandera (flag) 
        // para controlar la finalización del programa. Sin embargo, en este caso, hemos optado por 
        // finalizar la ejecución de la aplicación de manera explícita utilizando System.exit(0), 
        // lo que asegura una terminación inmediata y ordenada.
        
        while (true) {
            // Mostrar el menú al usuario
            System.out.println("\nMenu:");
            System.out.println("1. Add grade");
            System.out.println("2. View average grade");
            System.out.println("3. View number of passing grades");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            // Leer la opción elegida por el usuario
            Integer choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Agregar una nueva nota
                    System.out.print("Enter a grade: ");
                    Double grade = scanner.nextDouble();
                    gradeManager.addGrade(grade);
                    break;
                case 2:
                    System.out.println("Average grade: " + gradeManager.calculateAverage());
                    break;
                case 3:
                    System.out.println("Number of passing grades: " + gradeManager.countPassingGrades());
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

