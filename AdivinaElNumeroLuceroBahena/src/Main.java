import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int numSecreto = (int) (Math.random() * 100) + 1;
        int intentosRestantes = 7;
        boolean gano = false;
        int fueraRango = 0;
        int entradasNoNumericas=0;

        System.out.println("Bienvenido al juego adivina el numero!");
        System.out.println("pense en un numero del 1 al 100, tienes 7 intentos para adivinar que numero es");

        while (intentosRestantes > 0 && !gano) {
            System.out.println("Intentos restantes: " + intentosRestantes);
            System.out.println("Introduce un numero: ");

            if (!leer.hasNextInt()) {
                System.out.println("Error. No es un numero");
                entradasNoNumericas++;
                leer.next();
                continue;
            }
            int intentoUsuario = leer.nextInt();

            if (intentoUsuario < 1 || intentoUsuario > 100) {
                System.out.println("error. el numero tiene que ser entre el 1 y el 100");
                fueraRango++;
                continue;
            }
            if (intentoUsuario == numSecreto) {
                gano = true;
            } else {
                intentosRestantes--;
                if (intentoUsuario < numSecreto) {
                    System.out.println("el numero secreto es mayor");
                } else {
                    System.out.println("el numero secreto es menor");
                }
            }
        }
        if (gano) {
            System.out.println("ganaste! adivinaste el numero");
        }else {
            System.out.println("te quedaste sin intentos ");
            System.out.println("el numero secreto era: "+numSecreto);
        }
        System.out.println("RESUMEN");
        System.out.println("Entradas no numericas: "+entradasNoNumericas);
        System.out.println("numeros fuera del rango: "+ fueraRango);
    }
}

