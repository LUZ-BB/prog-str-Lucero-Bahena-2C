import java.util.Scanner;
public class Inputvalidator {
public double leerDoubleEnRango(Scanner sc, String msg, double min, double max){
    double valor;
    while (true) {
        System.out.println(msg);
        if (sc.hasNextDouble()){
            valor = sc.nextDouble();
            if (valor >=min && valor <=max){
                return valor;
            }
        }else {
            System.out.println("el valor no es numerico");
            sc.next();
        }
    }
}

public int  leerIntEnRango(Scanner sc, String msg, int min, int max){
    int valor;
    while (true) {
        System.out.println(msg);
        if (sc.hasNextInt()) {
            valor = sc.nextInt();
            if (valor >= min && valor <= max) {
                return valor;
            }
        } else {
            System.out.println("el valor no es un numero entero");
            sc.next();
        }
    }
}

public boolean leerBoolean(Scanner sc, String msg) {
while (true){
    System.out.println(msg);
    String input = sc.next();
    if (input.equals("true")){
        return true;
    }if (input.equals("false")){
        return false;
    }else {
        System.out.println("responda con (true/false)");
    }
}

}
}
