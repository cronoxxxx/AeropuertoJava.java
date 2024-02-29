package DAO.Aeropuertos;
import DAO.*;

public class AeropuertoPrivado extends Aeropuerto {
    private String [] empresas = new String[10];
    private int numEmpresas;
    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Company[] asignadas, String [] empresas) {
        super(nombre, ciudad, pais, asignadas);
        this.empresas=empresas;
        numEmpresas=empresas.length;
    }
    public void insertarEmpresas(String [] empresas){ //insertar empresas en conjunto
        this.empresas=empresas;
        this.numEmpresas=empresas.length;
    }
    public void insertarEmpresa (String empresa){ //insertar 1 x 1
        empresas[numEmpresas]=empresa;
        numEmpresas++;
    }

    public String[] getEmpresas() {
        return empresas;
    }

    public void setEmpresas(String[] empresas) {
        this.empresas = empresas;
    }

    public int getNumEmpresas() {
        return numEmpresas;
    }

    public void setNumEmpresas(int numEmpresas) {
        this.numEmpresas = numEmpresas;
    }
}
