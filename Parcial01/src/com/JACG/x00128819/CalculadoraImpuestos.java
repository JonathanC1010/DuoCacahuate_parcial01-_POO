package com.JACG.x00128819;

public class CalculadoraImpuestos {
    private static double totalRenta = 0, totalISSS = 0, totalAFP = 0;

    private CalculadoraImpuestos() {
    }

    public static double calcularPago(Empleado sujeto){
        double AFP = 0, ISSS = 0, renta = 0, restante = 0, pago = 0;

        if(sujeto instanceof PlazaFija){
            AFP = 0.0625 * sujeto.getSalario();
            ISSS = 0.03 * sujeto.getSalario();
            restante = sujeto.getSalario() - AFP - ISSS;
            if (restante>0 && restante<=472){//Rango A
                renta = 0;
            }
            if (restante>472 && restante<=895.24){//Rango B
                renta = 0.1 * (restante - 472) + 17.67;
            }
            if (restante>895.24 && restante<=2038.10){//Rango C
                renta = 0.2 * (restante - 895.24) + 60;
            }
            if (restante>2038.10){//Rango D
                renta = 0.3 * (restante - 2038.10) + 288.57;
            }

            pago = restante - renta;
        }
        else if (sujeto instanceof ServicioProfesional){
            renta = 0.1 * sujeto.getSalario();
            pago = sujeto.getSalario() - renta;
        }
        totalAFP += AFP;
        totalRenta += renta;
        totalISSS += ISSS;
        return pago;
    }

    public static String mostrarTotales(){
        return "\nTotal renta: " + totalRenta +
                "\nTotal ISSS:" + totalISSS +
                "\nTotal AFP: " + totalAFP;
    }

}
