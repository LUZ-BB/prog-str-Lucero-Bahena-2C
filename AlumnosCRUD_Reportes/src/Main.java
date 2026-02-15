import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Alumno[] alumnos = new Alumno[25];
        Scanner sc = new Scanner(System.in);
        AlumnoService personaService= new AlumnoService();
        int opcion=-1;

        do {
            System.out.println("⊹₊˚‧︵‿₊୨MENU୧₊‿︵‧˚₊⊹");
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.println("Ingresa una opcion (0-6): ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Error. Ingresa una opcion valida.");
                sc.next();
                sc.nextLine();
                continue;
            }

            switch (opcion){
                case 0:
                    System.out.println("saliendo del programa");
                    break;

                case 1:
                    AlumnoService.alta(sc, alumnos);
                    break;

                case 2:
                    AlumnoService.buscarPorId(sc, alumnos);
                    break;


                case 3:
                    AlumnoService.actualizarPromedio(sc, alumnos);
                    break;

                case 4:
                    AlumnoService.bajaLogica(sc, alumnos);
                    break;

                case 5:
                    AlumnoService.listarActivas(alumnos);
                    break;

                case 6:
                    Reporte.imprimirReporte(alumnos);
                    break;

                default:
                    System.out.println("Error. Opcion no valida.");


            }
        } while (opcion != 0);


    }
}

