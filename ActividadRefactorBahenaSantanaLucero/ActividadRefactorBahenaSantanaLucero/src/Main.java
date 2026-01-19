import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int calificacionA = pedirEntero(scanner,"ingresa la primera calificacion (a): ");
        int calificacionB = pedirEntero(scanner, "ingresa segunda calificacion (b): ");
        int calificacionC = pedirEntero(scanner,"ingresala tercera calificacion (c): ");

        int suma = calcularSuma(calificacionA, calificacionB, calificacionC);
        double promedio = calcularPromedio(suma, 3);

        mostrarResultados( suma, promedio);
        scanner.close();
    }
    public static int pedirEntero(Scanner scanner, String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * hace la suma de las calificaciones
     * @param calificacionA -> primera calificacion
     * @param calificacionB -> segunda calificacion
     * @param calificacionC -> tercera calificacion
     * @return suma de las 3 calificaciones
     */
    public static int calcularSuma(int calificacionA,int calificacionB, int calificacionC){
        return (calificacionA + calificacionB + calificacionC);
    }

    /**
     * calcula el promedio de las 3 calificaciones
     * @param sumatotal -> suma de los 3 calificaciones
     * @param numeroDeCalf -> cuantas calificaciones son
     * @return el promedio
     */
    public static double calcularPromedio(int sumatotal, int numeroDeCalf){
        return sumatotal/numeroDeCalf;
    }

    /**
     * muestra los resultados de las sumas de las 3 calificaciones y el promedio
     * @param suma -> muestra suma de las 3 calificaciones
     * @param promedio -> muestra el promedio
     */
    public static void mostrarResultados( int suma, double promedio){
        System.out.println("suma de calificaciones: " + suma);
        System.out.println("promedio: " + promedio);
    }


    }

