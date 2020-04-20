package com.JACG.x00128819;

public class PlazaFija extends Empleado {
    private int extension;//numero telefonico de su oficina

    public PlazaFija(String nombre, String puesto, double salario, int extension) {
        super(nombre, puesto, salario);
        this.extension = extension;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "PlazaFija\n" +
                  nombre +
                " con el puesto de " + puesto +
                " puede ser contactado atraves del numero telefonico " + extension +
                " y su salario es " + salario ;
    }
}
