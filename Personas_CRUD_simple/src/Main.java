import java.util.Scanner;
public class Main {
    public static void main(String[] args) {


        PersonaService[] personas = new PersonaService[20];
        Scanner sc = new Scanner(System.in);
        PersonaService personaService= new PersonaService();
        int opcion=0;

        do {
            System.out.println("MENU");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("6) Salir");
            System.out.println("Ingresa una opcion (0-5): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                System.out.println("Error. Ingresa una opcion valida.");
                sc.next();
                continue;
            }

            switch (opcion){
                case 1:

                case 2:


                case 3:

                case 4:

                case 5:

                case 6:

                default:
                    System.out.println("Error. Opcion no valida.");


            }
        } while (opcion != 6);



    }
}