import java.io.Serializable;


public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L; //SerialVersionIUD cte por si hay distintas versiones del programa "Empleados con Fichero".

    //Atributos
    private int legajo;
    private String apell;
    private String nomb1;
    private String nomb2;
    private String dir;
    private long tel;
    private int dpto;
    private int legajoJefe;
    private String categoria;
    private double sueldo;
    private int hsExtras;

    //Constructor
    public Empleado(int legajo, String apell, String nomb1, String nomb2, String dir, long tel, int dpto, int legajoJefe, String categoria, double sueldo){

        this.legajo = legajo;
        this.apell = apell;
        this.nomb1 = nomb1;
        this.nomb2 = nomb2;
        this.dir = dir;
        this.tel = tel;
        this.dpto = dpto;
        this.legajoJefe = legajoJefe;
        this.categoria = categoria;
        this.sueldo = sueldo;
    }

    @Override
    public String toString(){
        return " Legajo:"+legajo+" Apellido:"+apell+" Nombres:"+nomb1+" "+nomb2+" Dirección: "+dir+" Telefono:"+tel+
                " Departamento:"+dpto+" Legajo jefe:"+legajoJefe+" Categoría:"+categoria+" Sueldo:"+sueldo;
    }

    //Get - Set
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getApell() {
        return apell;
    }

    public void setApell(String apell) {
        this.apell = apell;
    }

    public String getNomb1() {
        return nomb1;
    }

    public void setNomb1(String nomb1) {
        this.nomb1 = nomb1;
    }

    public String getNomb2() {
        return nomb2;
    }

    public void setNomb2(String nomb2) {
        this.nomb2 = nomb2;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public int getDpto() {
        return dpto;
    }

    public void setDpto(int dpto) {
        this.dpto = dpto;
    }

    public int getLegajoJefe() {
        return legajoJefe;
    }

    public void setLegajoJefe(int legajoJefe) {
        this.legajoJefe = legajoJefe;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getHsExtras() {
        return hsExtras;
    }

    public void setHsExtras(int hsExtras) {
        this.hsExtras = hsExtras;
    }
}