package Fecha;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FechaConverter {

    public static boolean validarFecha(int dia, int mes, int anio) {
        int[] diasPorMes = {31, (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) ? 29 : 28,
                            31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      
        System.out.println("Validando: " + dia + "/" + mes + "/" + anio);
        System.out.println("Días en mes: " + diasPorMes[mes - 1]);

        return mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    public static int convertirMesANumero(String mesStr) {
        Map<String, Integer> meses = new HashMap<>();
        meses.put("enero", 1);
        meses.put("febrero", 2);
        meses.put("marzo", 3);
        meses.put("abril", 4);
        meses.put("mayo", 5);
        meses.put("junio", 6);
        meses.put("julio", 7);
        meses.put("agosto", 8);
        meses.put("septiembre", 9);
        meses.put("octubre", 10);
        meses.put("noviembre", 11);
        meses.put("diciembre", 12);
        
        return meses.getOrDefault(mesStr.toLowerCase(), -1);
    }

    public static void procesarFecha(String entrada) {
        try {
         
            String[] partes = entrada.split(" de ");
            int dia = Integer.parseInt(partes[0].trim());
            String[] mesAnio = partes[1].split(",");
            String mesStr = mesAnio[0].trim();
            int anio = Integer.parseInt(mesAnio[1].trim());

            int mes = convertirMesANumero(mesStr);
            System.out.println("Mes numérico: " + mes);  // Mensaje de depuración

            
            if (validarFecha(dia, mes, anio)) {
                
                String salida = String.format("%d / %02d / %d", dia, mes, anio);
                System.out.println(salida);
            } else {
                System.out.println("Error: Fecha no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error: Formato de entrada no válido.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fecha;

      
        System.out.println("Introduce fechas en formato 'd de mes, aaaa' :");

        while (true) {
            fecha = scanner.nextLine();
            if (fecha.equalsIgnoreCase("fin")) {
                break; 
            }
            System.out.println("Entrada: " + fecha);
            procesarFecha(fecha);
        }

        scanner.close(); 
    }
}
