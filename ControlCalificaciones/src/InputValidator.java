import java.util.Scanner;
public class InputValidator {

    public String leerTextoNoVacio (Scanner sc, String msg){
        System.out.println(msg);
        String texto = sc.nextLine();
        while(texto.trim().isEmpty()){
            System.out.println("No puede estar vacio " + msg);
            texto = sc.nextLine();
        }
        return texto;

    }
    public double leerDoubleEnRango (Scanner sc, String msg,double min, double max){
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                if (val >= min && val <= max) {
                    sc.nextLine();
                    return val; }
            }
            sc.nextLine();
            System.out.println("Error: Rango inválido.");
        }
    }
    public int leerIntEnRango (Scanner sc, String msg,int min, int max){
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if (val >= min && val <= max) {
                    sc.nextLine();
                    return val; }
            }
            sc.nextLine();
            System.out.println("rango invalido.");
        }

    }
    public boolean leerBoolean (Scanner sc, String msg){
        while (true) {
            System.out.println(msg + " (true/false)");
            if (sc.hasNextBoolean()) {
                boolean val = sc.nextBoolean();
                sc.nextLine();
                return val;
            }
            sc.nextLine();
            System.out.println("responda con true o false.");

        }
    }
}
