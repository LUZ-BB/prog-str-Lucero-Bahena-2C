import java.util.Scanner;
public class Main{
    public static void main(String[]args){
        int numeroLimite = pedirEntero();
        int sumaTotal = sumarHastaN(numeroLimite);
        mostrarResultado(sumaTotal);
    }

    /**
     * Solicita un numero entero
     * @return numero ingresado por el usuario
     */
    public static int pedirEntero() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Igresa un número entero: ");
        int numero = entrada.nextInt();
        return numero;
    }
    /**
     * Calcula la suma acumulada desde 1 hasta el numero limite
     * @param limite -> numero hasta donde se realiza la suma
     * @return eltotal de la suma
     */
    public static int sumarHastaN(int limite) {
        int sumaAcumulada = 0;
        for (int i = 1; i <= limite; i++) {
            sumaAcumulada += i;
        }
        return sumaAcumulada;
    }

    /**
     * muestra el resultado
     * @param resultado
     */
    public static void mostrarResultado(int resultado) {
        System.out.println("La suma de los números es: " + resultado);
    }
}