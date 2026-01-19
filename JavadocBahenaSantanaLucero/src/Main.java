import java.util.Scanner;

/**
 * es la clase principal donde estan las opciones para hacerlos calculos
 */
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("MENÚ");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opcion: ");

            if (leer.hasNextInt()) {
                opcion = leer.nextInt();

            }else{
                System.out.println("Error. Ingresa una opcion valida: ");
                leer.next();
                continue;
            }


            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su peso en kg: ");
                    double peso = leer.nextDouble();
                    System.out.println("Ingrese su altura en metros: ");
                    double altura = leer.nextDouble();
                    System.out.println("Tu IMC es:" + calcularIMC(peso, altura));
                    break;
                case 2:
                    System.out.println("Ingresa la base: ");
                    double base = leer.nextDouble();
                    System.out.println("ingresa la altura: ");
                    double alturaRectangulo = leer.nextDouble();
                    System.out.println("El area del rectangulo es: " + areaRectangulo(base, alturaRectangulo));
                    break;

                case 3:
                    System.out.println("Ingresa los grados Celsius:");
                    double celsius = leer.nextDouble();
                    System.out.println("grados Celsius a Fahrenheit: " + convertirCelsiusAFahrenheit (celsius));
                    break;

                case 4:
                    System.out.println("Ingresa el radio del circulo: ");
                    double radio = leer.nextDouble();
                    System.out.println("El area del circulo es: " + AreaCirculo ( radio));
                    break;

                case 5:
                    System.out.println("Saliendo del programa :D ");
                    break;

                default:
                    System.out.println("error. Intentelo de nuevo :c ");

            }
            System.out.println();

        } while (opcion != 5) ;

        leer.close();


    }

    /**
     * clacula el indice de masa corporal con el peso y altura de una persona
     * formula: peso / altura^2
     * @param peso -> peso de la persona em kilogramos
     * @param altura -> altura de la persona en metros
     * @return el valor del IMC calculado
     */


        public static double calcularIMC ( double peso, double altura){
        return peso / (altura * altura);
          }

    /**
     *calcula el area de un rectangulo con su base y altura
     * formula: base * altura
     * @param base -> medida de la base del rectangulo
     * @param alturaRectangulo -> medida de la altura del rectangulo
     * @return el area del rectangulo
     */
        public static double areaRectangulo (double base, double alturaRectangulo){
            return base * alturaRectangulo;
        }

    /**
     * hace la conversion de grados celsius a fahrenheint
     * formula: (C * 1.8) + 32
     * @param celsius -> grados celsius que se convertiran
     * @return convierte grados celsius a fahrenheint
     */
        public static double convertirCelsiusAFahrenheit (double celsius){
            return (celsius * 1.8) + 32;
        }

    /**
     * calcula el area de un circulo
     * formula: A = πr²
     * @param radio -> radio del circulo
     * @return area del circulo
     */
    public static double AreaCirculo (double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
}
