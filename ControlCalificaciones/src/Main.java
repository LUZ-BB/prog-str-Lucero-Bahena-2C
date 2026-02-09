import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GradeService service = new GradeService();
        ReporteFinal reporte= new ReporteFinal();
        InputValidator validador = new InputValidator();

        String nombre= validador.leerTextoNoVacio(sc,"Ingresa el nombre del alumno: ");
        double p1= validador.leerDoubleEnRango(sc,"Ingresa la calificacion del parcial 1 (0-100): ",0, 100);
        double p2= validador.leerDoubleEnRango(sc,"Ingresa la calificacion del parcial 2 (0-100): ",0, 100);
        double p3= validador.leerDoubleEnRango(sc,"Ingresa la calificacion del parcial 3 (0-100):",0, 100);
        int asistencia = validador.leerIntEnRango(sc, "Porcentaje asistencia (0-100): ", 0, 100);
        boolean proyecto = validador.leerBoolean(sc, "¿Entrego proyecto?: ");

        double promedioParciales = service.calcularPromedio(p1, p2, p3);
        double calificacionFinal = service.calcularFinal(promedioParciales, asistencia);

        String estado = service.determinarEstado(calificacionFinal, asistencia, proyecto);

        reporte.imprimirReporte(nombre, p1, p2, p3, promedioParciales, asistencia, proyecto, calificacionFinal, estado);


    }
}
