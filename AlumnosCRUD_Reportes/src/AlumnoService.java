import java.util.Scanner;

public class AlumnoService {
    public static void alta(Scanner sc, Alumno[] alumnos) {
        int id = -1;
        while (true) {
            System.out.println("Dame el ID (debe ser mayor a 0): ");
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                sc.nextLine();
                if (id > 0) break;
                else System.out.println("Error. El ID debe ser mayor a 0");
            } else {
                System.out.println("Error, debe ser un numero ");
                sc.next();
            }

        }


        if (verificarIdRepetido(id, alumnos)) {
            System.out.println("El ID esta repetido");
            return;
        }

        String nombre = "";
        while (nombre.isEmpty()) {
            System.out.println("Dame el nombre: ");
            nombre = sc.nextLine();
            if (nombre.isEmpty()) System.out.println("Error. El nombre no puede estar vacio ");
        }

        double promedio = 0;
        while (true) {
            System.out.println("Dame el promedio (0.0 a 10.0): ");
            if (sc.hasNextDouble()) {
                promedio = sc.nextDouble();
                sc.nextLine();
                if (promedio >= 0 && promedio <= 10) {
                    break;
                } else {
                    System.out.println("Error. el promedio debe estar entre 0 y 10");
                }
            } else {
                System.out.println("Error. ingresa un numero valido para el promedio ");
                sc.next();
                sc.nextLine();
            }
        }

        int indice = obtenerIndice(alumnos);
        if (indice == -1) {
            System.out.println("El arreglo esta lleno");
            return;
        }

        alumnos[indice] = new Alumno(id, nombre, promedio);
        System.out.println("Alta exitosa ");
    }

    public static void buscarPorId(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa el ID a buscar: ");
        int id = sc.nextInt();
        for (Alumno p : alumnos) {
            if (p != null && p.getId() == id && p.isActivo()) {
                System.out.println("Encontrado: " + p.getNombre());
                return;
            }
        }
        System.out.println("No se encontro o esta inactivo ");
    }

    public static void bajaLogica(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa el ID para dar de baja: ");
        int id = sc.nextInt();
        for (Alumno p : alumnos) {
            if (p != null && p.getId() == id) {
                p.setActivo(false);
                System.out.println("Alumno dado de baja ");
                return;
            }
        }
        System.out.println("No se encontro el ID");
    }

    public static void listarActivas(Alumno[] alumnos) {
        System.out.println("Lista de alumnos activos:");
        boolean hayAlumnos = false;
        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                System.out.println("ID: " + a.getId() + " Nombre: " + a.getNombre() + "  Promedio: " + a.getPromedio());
                hayAlumnos = true;
            }
        }
        if (!hayAlumnos) {
            System.out.println("No hay alumnos registrados o activos actualmente.");
        }
    }

    public static void actualizarPromedio(Scanner sc, Alumno[] alumnos) {
        System.out.println("Ingresa el ID para actualizar el promedio: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id && a.isActivo()) {
                System.out.println("Nuevo promedio (0-10): ");
                double nuevoPromedio = sc.nextDouble();
                if (nuevoPromedio >= 0 && nuevoPromedio <= 10) {
                    a.setPromedio(nuevoPromedio);
                    System.out.println("Promedio actualizado ");
                }else {
                    System.out.println("promedio fuera de rango");
                }
                return;
            }
        }
        System.out.println("No se puede actualizar ");
    }

    public static boolean verificarIdRepetido(int id, Alumno[] alumnos) {
        for (Alumno a : alumnos) {
            if (a != null && id == a.getId()) {
                return true;
            }
        }
        return false;
    }

    public static int obtenerIndice(Alumno[] alumnos) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) return i;
        }
        return -1;
    }
}
