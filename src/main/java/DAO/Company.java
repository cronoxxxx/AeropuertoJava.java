package DAO;

public class Company {
    private String nombre;
    private Vuelo [] listaVuelos= new Vuelo[100];

    private int numVuelos = 0; //valor de 0 inicial al crear la compañia

    public Company(String nombre) {
        this.nombre = nombre;
    }

    public Company(String nombre, Vuelo []asignado ) {
        this.nombre = nombre;
        listaVuelos=asignado;
        numVuelos=asignado.length; //asigna cantidad de vuelos que asignaremos al momento de crear la compañia
    }

    public void insertarVuelo(Vuelo vuelo){
        listaVuelos[numVuelos]=vuelo; //se aumenta, ya que empieza de asignado.length, y su limite sera el asignado.lenght
        numVuelos++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumVuelos() {
        return numVuelos;
    }

    public void setNumVuelos(int numVuelos) {
        this.numVuelos = numVuelos;
    }
    public Vuelo obtenerVuelo (int id){
        return listaVuelos[id];
    }
    public Vuelo obtenerVuelo (String id){
        boolean encontrado=false;
        Vuelo posibleVuelo = null;
        for (int i = 0; i < listaVuelos.length && !encontrado; i++) {
            if (listaVuelos[i]!=null){
                if (id.trim().equalsIgnoreCase(listaVuelos[i].getIdentificador())){
                    encontrado=true;
                    posibleVuelo=listaVuelos[i];
                }
            }
        }
        return posibleVuelo;
    }
}
