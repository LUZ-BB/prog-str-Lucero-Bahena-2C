import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        double resultado = 0;

        do {
            System.out.println("MENÚ");
            System.out.println("1. Convertir °C a °F");
            System.out.println("2. Convertir °F a °C");
            System.out.println("3. Convertir Km a Millas");
            System.out.println("4. Convertir Millas a Km");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opcion: ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();
            } else {
                System.out.println("Error. Ingresa una opcion valida.");
                leer.next();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa los grados Celsius: ");
                    if (leer.hasNextDouble()) {
                        double celsius = leer.nextDouble();
                        resultado = (celsius * 1.8) + 32;
                        System.out.println("Resultado (°C a °F): " + resultado);
                        c1++;
                    } else {
                        System.out.println("Error: El valor debe ser numerico.");
                        leer.next();
                    }
                    break;

                case 2:
                    System.out.print("Ingresa los grados Fahrenheit: ");
                    if (leer.hasNextDouble()) {
                        double fahrenheit = leer.nextDouble();
                        resultado = (fahrenheit - 32) * 5 / 9;
                        System.out.println("Resultado (°F a °C): " + resultado);
                        c2++;
                    } else {
                        System.out.println("Error: El valor debe ser numerico.");
                        leer.next();
                    }
                    break;

                case 3:
                    System.out.print("Ingresa los kilometros: ");
                    if (leer.hasNextDouble()) {
                        double km = leer.nextDouble();
                        resultado = km * 0.621371;
                        System.out.println("Resultado (Km a Millas): " + resultado);
                        c3++;
                    } else {
                        System.out.println("Error: El valor debe ser numerico.");
                        leer.next();
                    }
                    break;

                case 4:
                    System.out.print("Ingresa las millas: ");
                    if (leer.hasNextDouble()) {
                        double millas = leer.nextDouble();
                        resultado = millas * 1.60934;
                        System.out.println("Resultado (Millas a Km): " + resultado);
                        c4++;
                    } else {
                        System.out.println("Error: El valor debe ser numerico.");
                        leer.next();
                    }
                    break;

                case 5:
                    int total = c1 + c2 + c3 + c4;
                    System.out.println("RESUMEN");
                    System.out.println("Conversiones de °C a °F: " + c1);
                    System.out.println("Conversiones de °F a °C: " + c2);
                    System.out.println("Conversiones de Km a Millas: " + c3);
                    System.out.println("Conversiones de Millas a Km: " + c4);
                    System.out.println("Total de conversiones: " + total);
                    System.out.println("Saliendo del programa");
                    break;

                default:
                    System.out.println("Error. Opcion no valida.");
            }
        } while (opcion != 5);

        leer.close();
    }
}



