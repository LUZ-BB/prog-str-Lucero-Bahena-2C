import java.util.Scanner;

public class Reporte {
    public static void imprimirReporte(Alumno[] alumnos){

        double suma = 0;
        int contActivos = 0;
        int mayoresOcho = 0;
        Alumno mejor = null;
        Alumno peor = null;

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                suma += a.getPromedio();
                contActivos++;

                if (a.getPromedio() >= 8.0) mayoresOcho++;

                if (mejor == null || a.getPromedio() > mejor.getPromedio()) mejor = a;
                if (peor == null || a.getPromedio() < peor.getPromedio()) peor = a;
            }
        }

        if (contActivos == 0) {
            System.out.println("no hay alumnos activos para generar reportes");
            return;
        }

        System.out.println("✦•┈๑⋅⋯ REPORTE FINAL ⋯⋅๑┈•✦");
        System.out.println("Promedio general: " + (suma / contActivos));
        System.out.println("Alumno con mayor promedio: " + mejor.getNombre());
        System.out.println(" Alumno con menor promedio: " + peor.getNombre());
        System.out.println("Alumnos con promedio >= 8.0: " + mayoresOcho);

    }


}
