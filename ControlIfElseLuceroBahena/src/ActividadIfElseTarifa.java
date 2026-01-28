import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        int edad;
        boolean esEstudiante;
        int tarifa = 0;

        System.out.println("ingresa tu edad: ");
        edad = leer.nextInt();

        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.println("¿eres estudiante?");
        esEstudiante = leer.nextBoolean();

        if (edad < 12) {
            System.out.println("la tarifa = 50");

        } else if (edad >= 12 || edad <= 17) {
        }
        if (esEstudiante) {
            System.out.println("la tarifa =60");
        } else {
            System.out.println("la tarifa es 80");
        }else if (edad>=18){
            if (esEstudiante) {
                System.out.println("la tarifa es 90");
            }else {
                System.out.println("la tarifa es 120");
            }


    }



    }

    }
}