package DAO.Aeropuertos;

import DAO.Aeropuerto;
import DAO.Company;

public class AeropuertoPublico extends Aeropuerto {
    private double subvencion;

    public AeropuertoPublico(String nombre, String ciudad, String pais, double subvencion) {
        super(nombre, ciudad, pais);
        this.subvencion = subvencion;
    }

    public AeropuertoPublico(String nombre, String ciudad, String pais, Company[] asignadas, double subvencion) {
        super(nombre, ciudad, pais, asignadas);
        this.subvencion = subvencion;
    }

    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);

    }

    public double getSubvencion() {
        return subvencion;
    }

    public void setSubvencion(double subvencion) {
        this.subvencion = subvencion;
    }
}
