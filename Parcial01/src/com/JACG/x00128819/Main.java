package com.JACG.x00128819;

import java.awt.image.ImagingOpException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Empresa empresa = new Empresa("Coca cola");
        Empleado empleadoBuscar = null;
        byte op;
        String nombre, puesto;
        double salario;
        boolean seguir = false;

        String menu = "----------Menú----------\n" +
                "1. Agregar empleado\n" +
                "2. Despedir empleado\n" +
                "3. Ver lista de empleados\n" +
                "4. Calcular sueldo\n" +
                "5. Mostrar totales\n" +
                "0. Salir";

        Boolean error;
        do {
            error = false;
            try {

                do {
                    System.out.println(menu);
                    op = in.nextByte();
                    in.nextLine();

                    switch (op) {
                        case 0:
                            System.out.println("Saliendo...");
                            break;

                        case 1:

                            System.out.println("Nombre: ");
                            nombre = in.nextLine();
                            System.out.println("Ingrese el puesto:");
                            puesto = in.nextLine();
                            System.out.println("Salario: ");
                            salario = in.nextDouble();
                            in.nextLine();
                            while (!seguir) {
                                System.out.println("Ingrese tipo de empleo\n" +
                                        "1. Servicio profesional\n" +
                                        "2. Plaza fija");
                                op = in.nextByte();
                                in.nextLine();
                                if (op > 0 && op < 3) {
                                    seguir = true;
                                } else {
                                    System.out.println("Ingrese una opción válida");
                                }
                            }
                            if (op == 1) {//Servicio profesional
                                int mesesContrato;
                                System.out.println("Meses contratados: ");
                                mesesContrato = in.nextInt();
                                in.nextLine();
                                empresa.addEmpleado(new ServicioProfesional(nombre, puesto, salario, mesesContrato));
                            } else {//plaza fija
                                int extension;
                                System.out.println("Numero de telefono de su oficina: ");
                                extension = in.nextInt();
                                in.nextLine();
                                empresa.addEmpleado(new PlazaFija(nombre, puesto, salario, extension));
                            }
                            seguir = false;
                            break;

                        case 2:
                            System.out.println("Empleado a despedir: ");
                            nombre = in.nextLine();
                            empresa.quitEmpleado(nombre);
                            break;

                        case 3:

                            if (empresa.getPlanilla().isEmpty()) {
                                System.out.println("Debe agregar empleados primero");
                            } else {
                                for (Empleado i : empresa.getPlanilla()
                                ) {
                                    System.out.println(i);
                                }
                            }
                            break;

                        case 4:
                            if (empresa.getPlanilla().isEmpty()) {
                                System.out.println("Debe agregar empleados primero");
                            } else {
                                System.out.println("Calculando...");
                                for (Empleado i : empresa.getPlanilla()
                                ) {
                                    System.out.println("El sueldo de " + i.getNombre() + " es de $"
                                            + CalculadoraImpuestos.calcularPago(i));
                                }
                            }
                            break;

                        case 5:
                            System.out.println(CalculadoraImpuestos.mostrarTotales());
                            break;
                        default:
                            System.out.println("Opción inválida, por favor introduzca una opción listada");
                            break;
                    }
                } while (op != 0);
            } catch (InputMismatchException a) {
                System.out.println("debe ingresar los datos correspondientes o una opcion valida"); in.nextLine();
                error = true;
            }
        }while (error);


    }
}
