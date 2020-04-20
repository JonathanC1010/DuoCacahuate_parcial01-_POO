package com.JACG.x00128819;

public class ServicioProfesional extends Empleado {
    private int mesesContrato;


    public ServicioProfesional(String nombre, String puesto, double salario, int mesesContrato) {
        super(nombre, puesto, salario);
        this.mesesContrato = mesesContrato;
    }

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    @Override
    public String toString() {
        return "ServicioProfesional\n" +
                "se ha contratadado por " + mesesContrato +
                " meses a " + nombre +
                " en el puesto de " + puesto +
                " por un salario de " + salario + " Dolares";

    }
}
