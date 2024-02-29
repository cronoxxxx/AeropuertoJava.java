package DAO;

public class Aeropuerto {
    private String nombre,ciudad,pais;
    private Company []companies = new Company[20];

    private int numCompanies;

    public Aeropuerto(String nombre, String ciudad, String pais) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.numCompanies=0;
    }

    public Aeropuerto(String nombre, String ciudad, String pais, Company[] asignadas) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        companies=asignadas;
        numCompanies=asignadas.length;
    }

    public void insertarCompany(Company nueva){
        companies[numCompanies]=nueva;
        numCompanies++;
    }

    public Company obtenerCompany (int posArray){
        return companies[posArray];
    }
    public Company obtenerCompany (String nombre){
        boolean encontrado=false;
        Company posibleCompany = null;
        for (int i = 0; i < companies.length && !encontrado; i++) {
            if (companies[i]!=null){
                if (nombre.trim().equalsIgnoreCase(companies[i].getNombre())){
                    encontrado=true;
                   posibleCompany=companies[i];
                }
            }
        }
        return posibleCompany;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }

    public int getNumCompanies() {
        return numCompanies;
    }

    public void setNumCompanies(int numCompanies) {
        this.numCompanies = numCompanies;
    }
}
