import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;
        double resultado;
        double a;
        double b;

        System.out.println("MENU");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println(" 4) Dividir");
        System.out.println("Selecciona una opcion: ");
        opcion = leer.nextInt();



        switch (opcion) {
            case 1:
                System.out.println("SUMA");
                System.out.println("ingresa el primer número: ");
                a = leer.nextDouble();
                System.out.println("ingresa el segundo número: ");
                b = leer.nextDouble();
                resultado = a + b;
                System.out.println("el resultado de la suma es: " + resultado);

                break;

            case 2:
                System.out.println("RESTA");
                System.out.println("ingresa el primer número: ");
                a = leer.nextDouble();
                System.out.println("ingresa el segundo número: ");
                b = leer.nextDouble();
                resultado = a - b;
                System.out.println("el resultado de la resta es: " + resultado);

                break;

            case 3:
                System.out.println("MULTIPLICACIÓN");
                System.out.println("ingresa el primer número: ");
                a = leer.nextDouble();
                System.out.println("ingresa el segundo número: ");
                b = leer.nextDouble();
                resultado = a * b;
                System.out.println("el resultado de la multiplicacion es: " + resultado);

                break;

            case 4:
                System.out.println("DIVISIÓN");
                System.out.println("ingresa el primer número: ");
                a = leer.nextDouble();
                System.out.println("ingresa el segundo número: ");
                b = leer.nextDouble();
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");

                } else {
                    resultado = a / b;
                    System.out.println("el resultado de es: " + resultado);
                }
                break;
            default:
                System.out.println("Opción inválida");


        }



    }

}
