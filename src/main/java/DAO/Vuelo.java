package DAO;

public class Vuelo {
    private String identificador, ciudadOrigen, ciudadDestino;
    private double precio;
    private int numMaxPasajeros, numActualPasajeros;
    private Pasajero[]listaPasajeros;

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int numMaxPasajeros) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.numMaxPasajeros = numMaxPasajeros;
        this.numActualPasajeros=0;
        this.listaPasajeros=new Pasajero[numMaxPasajeros];
    }

    public Vuelo(String ciudadOrigen, String ciudadDestino) {
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNumMaxPasajeros() {
        return numMaxPasajeros;
    }

    public void setNumMaxPasajeros(int numMaxPasajeros) {
        this.numMaxPasajeros = numMaxPasajeros;
    }

    public int getNumActualPasajeros() {
        return numActualPasajeros;
    }

    public void setNumActualPasajeros(int numActualPasajeros) {
        this.numActualPasajeros = numActualPasajeros;
    }

    public Pasajero obtenerPasajero (int id){
        return listaPasajeros[id];
    }
    public Pasajero obtenerPasajero (String pasaporte){
        Pasajero pasajeroPosible = null;
        boolean encontrado = false;
        for (int i = 0; i < listaPasajeros.length && !encontrado; i++) {
            if (listaPasajeros[i]!=null){
                if (pasaporte.trim().equalsIgnoreCase(listaPasajeros[i].getPasaporte())){
                    pasajeroPosible=listaPasajeros[i];
                    encontrado=true;

                }
            }
        }
        return pasajeroPosible;
    }

    public void setListaPasajeros(Pasajero[] listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    public void insertarPasajero (Pasajero nuevo){
        listaPasajeros[numActualPasajeros]=nuevo;
        numActualPasajeros++;
    }

}
