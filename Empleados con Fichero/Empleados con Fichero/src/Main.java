/**
 * Objetivo: Desarrollar una aplicación que permita gestionar legajos de empleados y su salario. Los datos deben persistir.
 *
 * Versión: 1.1| 28/07/2016
 *
 * Autores: DUARTE Alejandra, SEPT Diego, MANSUETO Marina
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner leer = new Scanner(System.in);
    public static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    static int op;

    private static void Menu() {

        System.out.print("\n- EMPRESA CONSTRUCTORA ABC SA - ");
        System.out.print("\n---------------------------------\n");

        System.out.print("\n1 - Cargar empleados");
        System.out.print("\n2 - Modificar datos personales de un empleado");
        System.out.print("\n3 - Cargar horas extras a todos los empleados");
        System.out.print("\n4 - Modificar horas extras a un empleado");
        System.out.print("\n5 - Liquidar sueldos");
        System.out.print("\n6 - Menú datos administrativos");
        System.out.print("\n7 - Mostrar datos de empleados");
        System.out.print("\n0 - Salir del programa");
        System.out.print("\n----------------------");

        System.out.println("\n Opción elegida: ");
    }

    private static void cargarDatos() {
        int legajo;
        String apell;
        String nomb1;
        String nomb2;
        String dir;
        long tel;
        int dpto;
        int legajoJefe;
        String categoria;
        double sueldo;


        System.out.print("\n- EMPRESA CONSTRUCTORA ABC SA - ");
        System.out.print("\n---------------------------------\n");
        System.out.print("Cantidad de empleados a cargar:");//Usuario determina la cantidad total de empleados
        int cantEmpl = leer.nextInt();

        for (int i = 0; i < cantEmpl; i++) {

            System.out.print("\tIngrese Legajo:");
            legajo = leer.nextInt();
            System.out.print("\tIngrese Apellido:");
            apell = leer.next();
            System.out.print("\tIngrese Primer Nombre:");
            nomb1 = leer.next();
            System.out.print("\tIngrese Segundo Nombre:");
            nomb2 = leer.next();
            System.out.print("\tIngrese Dirección:");
            leer.nextLine();
            dir = leer.nextLine();
            System.out.print("\tIngrese Teléfono:");
            tel = leer.nextLong();
            System.out.print(" Ingrese el número de Departamento:");
            System.out.print("\n\t1- Departamento 1\n" + "\t2- Departamento 2\n" + "\t3- Departamento 3");
            dpto = leer.nextInt();
            System.out.print("\tIngrese Legajo del jefe:");
            legajoJefe = leer.nextInt();
            System.out.print(" Indique Categoría:");
            System.out.println("\n\t1- Jefe \n" + "\t2- Encargado \n" + "\t3- Oficial \n" + "\t4- Medio Oficial\n" + "\t5- Peón\n" + "\t6- Otra...");
            int numCategoria = leer.nextInt();
            switch (numCategoria) {       //sueldo-categoría
                case 1:
                    sueldo = 10000;
                    categoria = "Jefe";
                    break;
                case 2:
                    sueldo = 8600;
                    categoria = "Encargado";
                    break;
                case 3:
                    sueldo = 5000;
                    categoria = "Oficial";
                    break;
                case 4:
                    sueldo = 4000;
                    categoria = "Medio Oficial";
                    break;
                case 5:
                    sueldo = 3500;
                    categoria = "Peón";
                    break;
                default:
                    System.out.println("Nombre de categoría:");
                    categoria = leer.next();
                    System.out.println("Sueldo:");
                    sueldo = leer.nextDouble();
                    break;
            }
            try {
                listaEmpleados.add(new Empleado(legajo, apell, nomb1, nomb2, dir, tel, dpto, legajoJefe, categoria, sueldo));
                System.out.println("--EMPLEADO CARGADO EXITOSAMENTE--");
                System.out.println("---------------------------------");

            } catch (Exception e) {
                System.out.print("No se pudo cargar el empleado.");
            }
            guardarDatos();
        }
        Menu();
    }

    private static void modificarDatos() {
        int op;
        System.out.println("MENU MODIFICACIONES");

        System.out.print("Ingrese el n° de legajo del empleado o pulse 0 para salir de este Menú:");
        int legajo = leer.nextInt();
        for (int i = 0; i < listaEmpleados.size(); i++)
            if (legajo == listaEmpleados.get(i).getLegajo()) {

                System.out.println("¿Qué dato desea modificar del empleado?");
                System.out.println("1- Legajo");
                System.out.println("2- Apellido");
                System.out.println("3- 1° Nombre");
                System.out.println("4- 2° Nombre");
                System.out.println("5- Dirección");
                System.out.println("6- Teléfono");
                System.out.println("7- Departamento");
                System.out.println("8- Lejago Jefe");
                System.out.println("9- Sueldo");
                System.out.println("10- Categoría");
                System.out.println("0- Salir de este menú");
                System.out.println("Opción elegida: ");
                op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("Ingrese nuevo legajo:");
                        int leg = leer.nextInt();
                        listaEmpleados.get(i).setLegajo(leg);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 2:
                        System.out.println("Ingrese nuevo apellido:");
                        String apellido = leer.next();
                        listaEmpleados.get(i).setApell(apellido);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 3:
                        System.out.println("Ingrese nuevo primer nombre:");
                        String nombre1 = leer.next();
                        listaEmpleados.get(i).setNomb1(nombre1);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 4:
                        System.out.println("Ingrese nuevo segundo nombre:");
                        String nombre2 = leer.next();
                        listaEmpleados.get(i).setNomb2(nombre2);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 5:
                        System.out.print("Ingrese nueva dirección:");
                        String dir = leer.nextLine();
                        listaEmpleados.get(i).setDir(dir);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 6:
                        System.out.println("Ingrese nuevo teléfono:");
                        long telefono = leer.nextLong();
                        listaEmpleados.get(i).setTel(telefono);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 7:
                        System.out.println("Ingrese nuevo departamento:");
                        int dpto = leer.nextInt();
                        listaEmpleados.get(i).setDpto(dpto);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 8:
                        System.out.println("Ingrese nuevo legajo del jefe:");
                        int legJefe = leer.nextInt();
                        listaEmpleados.get(i).setLegajoJefe(legJefe);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 9:
                        System.out.println("Ingrese nuevo sueldo:");
                        double sueldo = leer.nextDouble();
                        listaEmpleados.get(i).setSueldo(sueldo);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 10:
                        System.out.println("Ingrese nueva categoria:");
                        String categoria = leer.next();
                        listaEmpleados.get(i).setCategoria(categoria);
                        System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                        break;
                    case 0:
                        break;
                    default:
                        System.out.print("OPCIÓN NO VÁLIDA. ELIJA UN NÚMERO DEL MENÚ:");
                        break;
                }
            }
        guardarDatos();
        Menu();
    }

    private static void cargarHsExtras() {
        System.out.println("CARGAR HORAS EXTRAS A TODOS LOS EMPLEADOS");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("Ingrese Hs. Extras para " + listaEmpleados.get(i).getLegajo() + "-" + listaEmpleados.get(i).getApell() +
                    " " + listaEmpleados.get(i).getNomb1() + " " + listaEmpleados.get(i).getNomb2() + ":");
            int hsExtras = leer.nextInt();
            listaEmpleados.get(i).setHsExtras(hsExtras);
            System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
            System.out.println("---------------------------------");
        }
        Menu();
    }

    private static void modificarHsExtras() {
        int legajo;
        System.out.println("MODIFICAR HORAS EXTRAS");
        System.out.println("0 - Salir de este Menú");
        System.out.print("Ingrese el legajo:");
        legajo = leer.nextInt();
        int i = 0;
        while (i < listaEmpleados.size()) {
            if (legajo == listaEmpleados.get(i).getLegajo()) {
                System.out.println("Indique el nuevo valor TOTAL de horas extras:");
                int hsExtras = leer.nextInt();
                listaEmpleados.get(i).setHsExtras(hsExtras);
                System.out.println("NUEVO VALOR CARGADO EXITOSAMENTE");
                System.out.println("---------------------------------");
            }
            i++;
        }
        Menu();
    }

    private static void liquidarSueldos() {
        int mes, anio;
        float porcentaje = 0.01f, remunHsExtras;

        System.out.print("\nIngrese mes de liquidación (1-12):");
        mes = leer.nextInt();

        while (mes > 12 || mes < 1) {
            System.out.print("\nNÚMERO DE MES NO VÁLIDO.");
            System.out.print("\nIngrese mes de liquidación (1-12):");
            mes = leer.nextInt();
        }

        System.out.print("Ingrese año:");
        anio = leer.nextInt();
        System.out.println("----------------------");

        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("-LIQUIDACIÓN MENSUAL-");
            System.out.println("PERIODO: " + mes + "/" + anio);

            System.out.println("Legajo: " + listaEmpleados.get(i).getLegajo() + "-" + listaEmpleados.get(i).getApell() +
                    " " + listaEmpleados.get(i).getNomb1() + " " + listaEmpleados.get(i).getNomb2());
            System.out.println("Categoría: " + listaEmpleados.get(i).getCategoria());
            System.out.println("Sueldo básico = $" + listaEmpleados.get(i).getSueldo());
            System.out.print("Horas Extras: " + listaEmpleados.get(i).getHsExtras() + "hs");

            remunHsExtras = porcentaje * (float) listaEmpleados.get(i).getSueldo() * (float) listaEmpleados.get(i).getHsExtras();

            System.out.print(" = $" + remunHsExtras);
            System.out.print("\n");
            float total = ((float) listaEmpleados.get(i).getSueldo() + remunHsExtras);
            System.out.println("TOTAL = $" + total);
            System.out.println("__________________________________________________________");

        }
        Menu();
    }

    private static void verInformesAdministrativos() {
        int op = 1;

        while (op != 0) {
            System.out.print("INFORMES ADMINISTRATIVOS" + "" +
                    "\n1- Promediar sueldos" +
                    "\n2- Ver el sueldo de un determinado empleado" +
                    "\n3- Listado de empleados por departamento y promedio de sueldos" +
                    "\n4- Listado de horas extras por empleado" +
                    "\n0- Ir al menú principal");

            System.out.print("\nOpción elegida:");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    promediarSueldos();
                    break;
                case 2:
                    verSueldo();
                    break;
                case 3:
                    datosDepartamentos();
                    break;
                case 4:
                    verHsExtras();
                    break;
                case 0:
                    Menu();
                    break;
                default:
                    System.out.print("OPCIÓN NO VÁLIDA. ELIJA UN NÚMERO DEL MENÚ:");
                    break;
            }
        }
    }

    private static void promediarSueldos() {
        float sumarSueldos = 0, promSueldos;
        for (int i = 0; i < listaEmpleados.size(); i++) {
            sumarSueldos += (float) listaEmpleados.get(i).getSueldo();
        }
        promSueldos = sumarSueldos / listaEmpleados.size();
        System.out.println("Promedio de sueldos: $" + promSueldos);
        System.out.println("___________________________________");
    }

    private static void verSueldo() {

        int i, legajo;
        System.out.println("Ingrese el legajo:");
        legajo = leer.nextInt();
        for (i = 0; i < listaEmpleados.size(); i++) {
            if (legajo == listaEmpleados.get(i).getLegajo())
                System.out.println(" El empleado" + listaEmpleados.get(i).getLegajo() + "-" + listaEmpleados.get(i).getApell() + " " + listaEmpleados.get(i).getNomb1() + " "
                        + listaEmpleados.get(i).getNomb2() + " tiene un sueldo básico de $" + listaEmpleados.get(i).getSueldo());
        }
    }

    private static void datosDepartamentos() {
        int depto1 = 0, depto2 = 0, depto3 = 0, suma1 = 0, suma2 = 0, suma3 = 0;
        float promedio1, promedio2, promedio3;

        int i = 0;
        while (i < listaEmpleados.size()) {
            if (listaEmpleados.get(i).getDpto() == 1) {
                depto1++;
                suma1 += listaEmpleados.get(i).getSueldo();
            }
            if (listaEmpleados.get(i).getDpto() == 2) {
                depto2++;
                suma2 += listaEmpleados.get(i).getSueldo();
            }
            if (listaEmpleados.get(i).getDpto() == 3) {
                depto3++;
                suma3 += listaEmpleados.get(i).getSueldo();
            }
            i++;
        }
        System.out.println("DATOS POR DEPARTAMENTO");
        System.out.println("Cantidad de empleados Depto 1: " + depto1);
        System.out.println("Cantidad de empleados Depto 2: " + depto2);
        System.out.println("Cantidad de empleados Depto 3: " + depto3);

        if (depto1 != 0) {
            promedio1 = suma1 / depto1;
            System.out.println("El promedio de sueldos del departamento 1: $" + promedio1);
        }

        if (depto2 != 0) {
            promedio2 = suma2 / depto2;
            System.out.println("El promedio de sueldos del departamento 2: $" + promedio2);
        }

        if (depto3 != 0) {
            promedio3 = suma3 / depto3;
            System.out.println("El promedio de sueldos del departamento 3: $" + promedio3);
        }
    }

    private static void verHsExtras() {

        for (int i = 0; i < listaEmpleados.size(); i++) {
            System.out.println("Legajo: " + listaEmpleados.get(i).getLegajo());
            System.out.println("Hs. Extras: " + listaEmpleados.get(i).getHsExtras());
            System.out.print("\n");
        }
    }

    private static void mostrarDatos() throws IOException {

        for (int i = 0; i < listaEmpleados.size(); i++) {

            System.out.print("\t Legajo: " + listaEmpleados.get(i).getLegajo());
            System.out.print("\t Apellido: " + listaEmpleados.get(i).getApell());
            System.out.print("\t Nombres: " + (listaEmpleados.get(i).getNomb1()) + " " + (listaEmpleados.get(i).getNomb2()));
            System.out.print("\t Dirección: " + listaEmpleados.get(i).getDir());
            System.out.print("\t Teléfono: " + listaEmpleados.get(i).getTel());
            System.out.print("\t Depto: " + listaEmpleados.get(i).getDpto());
            System.out.print("\t Legajo del jefe: " + listaEmpleados.get(i).getLegajoJefe());
            System.out.print("\t Sueldo: " + listaEmpleados.get(i).getSueldo());
            System.out.print("\t Categoría: " + listaEmpleados.get(i).getCategoria());
            System.out.print("\t Hs Extras: " + listaEmpleados.get(i).getHsExtras());
            System.out.print("\n");//salto de linea para mostrar un solo empleado por fila
        }
        Menu();
    }

    public static void main(String[] args) throws IOException {
        if(listaEmpleados.isEmpty()) {
            leerDatos();
        }
        Menu();
        while (op>=0 && op<8) {
            op = leer.nextInt();
            switch (op) {
                case 1:
                    cargarDatos();
                    break;
                case 2:
                    modificarDatos();
                    break;
                case 3:
                    cargarHsExtras();
                    break;
                case 4:
                    modificarHsExtras();
                    break;
                case 5:
                    liquidarSueldos();
                    break;
                case 6:
                    verInformesAdministrativos();
                    break;
                case 7:
                    mostrarDatos();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.print("OPCIÓN NO VÁLIDA. ELIJA UN NÚMERO DEL MENÚ:\n");
                    break;
            }
        }

    }
    public static void guardarDatos(){
        FileWriter oFileWriter = null;
        PrintWriter oPrintWriter = null;
        try {
            oFileWriter = new FileWriter("fichero.txt");
            oPrintWriter = new PrintWriter(oFileWriter);

            for (int i = 0; i < listaEmpleados.size(); i++) {

                oPrintWriter.append(listaEmpleados.get(i).getLegajo()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getApell()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getNomb1()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getNomb2()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getDir()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getTel()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getDpto()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getLegajoJefe()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getCategoria()+"\t");

                oPrintWriter.append(listaEmpleados.get(i).getSueldo()+"\t");

                oPrintWriter.append("\n");

            }
        } catch (Exception e1) {

        } finally {
            try {

                if (oFileWriter != null) {
                    oPrintWriter.close();
                }
            } catch (Exception e2) {

            }
        }
    }

    public static void leerDatos(){

        FileReader oFileReader = null;
        BufferedReader oBufferedReader = null;

        try {

            oFileReader = new FileReader(new File("fichero.txt"));
            oBufferedReader = new BufferedReader(oFileReader);

            String linea;
            int legajo = 0;
            String apellido = "";
            String nombre1 = "";
            String nombre2 = "";
            String direccion = "";
            String telefono = "";
            String legajo_jefe="";
            String departamento = "";
            String categoria="";
            String sueldo="";

            while ((linea = oBufferedReader.readLine()) != null) {
                int campo = 0;
                String cadena = "";
                int i = 0;
                while (i < linea.length()) {
                    if (!linea.substring(i, i + 1).equals("\t")) {
                        cadena = cadena + linea.substring(i, i + 1);
                    } else {
                        campo++;
                        switch (campo) {
                            case 1:
                                legajo = Integer.parseInt(cadena.trim());
                                cadena = "";
                                break;
                            case 2:
                                apellido = cadena;
                                cadena = "";
                                break;
                            case 3:
                                nombre1 = cadena;
                                cadena = "";
                                break;
                            case 4:
                                nombre2 = cadena;
                                cadena = "";
                                break;
                            case 5:
                                direccion = cadena;
                                cadena = "";
                                break;
                            case 6:
                                telefono = cadena;
                                cadena = "";
                                break;
                            case 7:
                                departamento = cadena;
                                cadena = "";
                                break;
                            case 8:
                                legajo_jefe = cadena;
                                cadena="";
                                break;
                            case 9:
                                categoria=cadena;
                                cadena="";
                                break;
                            case 10:
                                sueldo=cadena;
                                cadena="";
                                break;
                        }
                    }
                    i++;
                }
                listaEmpleados.add(new Empleado(legajo, apellido, nombre1,
                        nombre2, direccion, Long.parseLong(telefono),
                        Integer.parseInt(departamento),Integer.parseInt(legajo_jefe),categoria,Double.parseDouble(sueldo)));
            }
        } catch (Exception e) {

        } finally {

            try {
                if (oFileReader != null) {
                    oFileReader.close();
                }
            } catch (Exception e2) {

            }
        }

    }
}