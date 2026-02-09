import java.util.Scanner;
 class GradeService {
     double calcularPromedio(double a, double b, double c){
         return (a+b+c)/3;
     }
     double calcularFinal(double promedio, int asistencia){
         return (promedio * 0.7) + (asistencia * 0.3);

     }
     String determinarEstado(double notaFinal, int asistencia, boolean entregoProyecto){
         if (asistencia<80){
             return  "Reprobado por asistencia";
         }
         if (!entregoProyecto) {
             return "REPROBADO por proyecto";
         }

         if (notaFinal>=70){
             return "APROBADO";
         }else{
            return "REPROBADO por calificación";
         }


     }

}
