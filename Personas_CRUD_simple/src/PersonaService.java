import java.util.Scanner;

public class PersonaService {

    public void alta(Scanner sc, Personas[] personas) {
        int id = 0;
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

        if (verificarIdRepetido(id, personas)) {
            System.out.println("El ID esta repetido");
            return;
        }

        String name = "";
        while (name.isEmpty()) {
            System.out.println("Dame el nombre: ");
            name = sc.nextLine();
            if (name.isEmpty()) System.out.println("Error. El nombre no puede estar vacio ");
        }

        int indice = obtenerIndice(personas);
        if (indice == -1) {
            System.out.println("El arreglo esta lleno");
            return;
        }

        personas[indice] = new Personas(id, name);
        System.out.println("Alta exitosa ");
    }

    public void buscarPorId(Scanner sc, Personas[] personas) {
        System.out.println("Ingresa el ID a buscar: ");
        int id = sc.nextInt();
        for (Personas p : personas) {
            if (p != null && p.getId() == id && p.isActive()) {
                System.out.println("Encontrado: " + p.getName());
                return;
            }
        }
        System.out.println("No se encontro o esta inactiva ");
    }

    public void bajaLogica(Scanner sc, Personas[] personas) {
        System.out.println("Ingresa el ID para dar de baja: ");
        int id = sc.nextInt();
        for (Personas p : personas) {
            if (p != null && p.getId() == id) {
                p.setActive(false);
                System.out.println("Persona dada de baja ");
                return;
            }
        }
        System.out.println("No se encontro el ID");
    }

    public void listarActivas(Personas[] personas) {
        System.out.println("Lista de personas activas:");
        for (Personas p : personas) {
            if (p != null && p.isActive()) {
                System.out.println("ID: " + p.getId() + " Nombre: " + p.getName());
            }
        }
    }

    public void actualizarNombre(Scanner sc, Personas[] personas) {
        System.out.println("Ingresa el ID para actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Personas p : personas) {
            if (p != null && p.getId() == id && p.isActive()) {
                System.out.println("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                if (!nuevoNombre.isEmpty()) {
                    p.setName(nuevoNombre);
                    System.out.println("Nombre actualizado ");
                }
                return;
            }
        }
        System.out.println("No se puede actualizar ");
    }

    public boolean verificarIdRepetido(int id, Personas[] personas) {
        for (Personas p : personas) {
            if (p != null && id == p.getId()) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Personas[] personas) {
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) return i;
        }
        return -1;
    }
}


