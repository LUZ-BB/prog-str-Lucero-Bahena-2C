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

        System.out.println("¿eres estudiante? (true/false) : ");
        esEstudiante = leer.nextBoolean();

        if (edad < 12) {
            tarifa = 50;
        }
        else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        }
        else if (edad >= 18) {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("tu edad es: "+ edad);
        System.out.println("tu tarifa es: "+ tarifa);
        System.out.println("indicaste que: "+esEstudiante);


    }



}


