import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SistemaNotasArchivo {
    public static void main(String[] args) {
        File archivo = new File("/Users/macbook/proyectos/tarea1/estudiantes.txt");
        if (!archivo.exists()) {
            System.out.println("Error: el archivo no existe.");
            return;
        }

        int total = 0, aprobados = 0;
        double suma = 0;

        try {
            try (Scanner lector = new Scanner(archivo)) {
                while (lector.hasNext()) {
                    String nombre = lector.next();
                    double n1 = lector.nextDouble();
                    double n2 = lector.nextDouble();
                    double n3 = lector.nextDouble();
                    double promedio = (n1 + n2 + n3) / 3.0;
                    
                    String estado;
                    if (promedio >= 9)       estado = "Excelente";
                    else if (promedio >= 7)  estado = "Bueno";
                    else                     estado = "Reprobado";
                    
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Promedio: " + promedio);
                    System.out.println("Estado: " + estado);
                    System.out.println("----------------------------");
                    
                    if (promedio >= 7) aprobados++;
                    suma += promedio;
                    total++;
                }
            }

            System.out.println("Total estudiantes: " + total);
            System.out.println("Total aprobados: " + aprobados);
            System.out.printf("Promedio general: %.2f%n", suma / total);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}