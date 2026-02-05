import java.util.Scanner;
public class ShippingCalculator {
   public double subtotal;
   public double total;
   public double iva;

    public double calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota){
        double monto=0;
        if (tipoServicio == 2) {
            monto += 90.0;
        } else {
            monto += 50.0;
        }
        monto += (pesoKg*12.0);

        if (distanciaKm <= 50){
            monto += 20;
        } else if (distanciaKm<=200) {
            monto +=60;
        }else{
            monto += 120;
        }

        if (zonaRemota){
            monto *= 1.10;
        }
        this.subtotal = monto;
        return this.subtotal;

    }

    public double calcularIVA(double subtotal) {
        this.iva = subtotal * 0.16;
        return this.iva;
    }

    public double calcularTotal(double subtotal, double iva) {
        this.total = subtotal + iva;
        return this.total;
    }

}
