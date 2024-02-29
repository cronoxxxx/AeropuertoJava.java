import DAO.*;
import DAO.Aeropuertos.*;

import java.util.Scanner;

public class Tester {
    static Scanner entrada = new Scanner(System.in);
    final static int cantidadAeropuertos = 4;
    static Aeropuerto[] aeropuertos = new Aeropuerto[4];

    public static void main(String[] args) {
        insertarDatosAeropuertos(aeropuertos);
        caseMenu();
    }

    private static void caseMenu() {
        String nombreAeropuerto,company,ciudadDestino, ciudadOrigen;
        int opcion;
        Aeropuerto recibido=null;
        Company implemented;
        Vuelo asignado = null;
        do {
            System.out.println("MENU\n" +
                    "1. Ver aeropuertos gestionados (Publicos o privados)\n" +
                    "2. Ver empresas(solo privados) o subvencion(solo publicos)\n" +
                    "3. Lista compañias de un aeropuerto\n" +
                    "4. Listas de vuelo por compañia\n" +
                    "5. Listar posibles vuelos de origen a destino (cuantos hay)\n" +
                    "6. Salir");
            System.out.println("Ingrese la opcion:");
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println(" ");
                    mostrarDatosAeropuertos(aeropuertos);
                    break;
                case 2:
                mostrarDatosHerenciaAeropuerto(aeropuertos);
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del aeropuerto");
                    nombreAeropuerto= entrada.nextLine();

                recibido=getAeropuertoenBusqueda(aeropuertos,nombreAeropuerto);
                if (recibido!=null){
                    mostrarCompanies(recibido);
                } else {
                    System.err.println("Aeropuerto no existe");
                }
                    break;
                case 4:
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del aeropuerto");
                    nombreAeropuerto= entrada.nextLine();

                    recibido=getAeropuertoenBusqueda(aeropuertos,nombreAeropuerto);
                    if (recibido!=null){
                        mostrarCompanies(recibido);
                        System.out.println("Ingrese el nombre de la compañia: ");
                        company= entrada.nextLine();
                        implemented=recibido.obtenerCompany(company);
                        mostrarVuelos(implemented);
                    } else {
                        System.err.println("El aeropuerto no existe");
                    }
                    break;
                case 5:
                    entrada.nextLine();
                    System.out.println("Ingrese la ciudad origen: ");
                    ciudadOrigen=entrada.nextLine();
                    System.out.println("Ingrese la ciudad destino: ");
                    ciudadDestino=entrada.nextLine();
                    mostrarVuelosOrigenDestino(ciudadOrigen,ciudadDestino,aeropuertos);
                    break;
                case 6:
                    System.out.println("VUELVA PRONTO ! ! !");
                    break;
                default:
                    System.err.println("Opcion equivocada");
            }
        } while (opcion != 6);


    }


    private static void insertarDatosAeropuertos(Aeropuerto[] datosAeropuertos) {
        datosAeropuertos[0] = new AeropuertoPublico("Barajas", "Madrid", "España", 800000);
        datosAeropuertos[0].insertarCompany(new Company("LAN"));
        datosAeropuertos[0].insertarCompany(new Company("Iberia"));
        datosAeropuertos[0].obtenerCompany("LAN").insertarVuelo(new Vuelo("AS12", "Madrid", "Lima", 2000, 150));
        datosAeropuertos[0].obtenerCompany("LAN").insertarVuelo(new Vuelo("IB21", "Lima", "CABA", 500, 120));
        datosAeropuertos[0].obtenerCompany("Iberia").insertarVuelo(new Vuelo("EE21", "Barcelona", "Berlín", 300, 76));
        datosAeropuertos[0].obtenerCompany("LAN").obtenerVuelo("AS12").insertarPasajero(new Pasajero("Adrian", "118822045", "Perukistaní"));
        datosAeropuertos[0].obtenerCompany("LAN").obtenerVuelo("IB21").insertarPasajero(new Pasajero("Mirko", null, "Española"));
        datosAeropuertos[0].obtenerCompany("Iberia").obtenerVuelo("EE21").insertarPasajero(new Pasajero("Maksim", "xxxxxx", "Rusa"));
        //Aeropuerto 1:
        datosAeropuertos[1] = new AeropuertoPrivado("Teterboro", "Kentucky", "EE.UU.");
        datosAeropuertos[1].insertarCompany(new Company("Qatar"));
        datosAeropuertos[1].insertarCompany(new Company("Fly Emirates"));
        String[] empresas = {"Arona", "Portillo S.A."};
        if (datosAeropuertos[1] instanceof AeropuertoPrivado) {
            ((AeropuertoPrivado) datosAeropuertos[1]).insertarEmpresas(empresas);
        }
        datosAeropuertos[1].obtenerCompany("Qatar").insertarVuelo(new Vuelo("AA11", "Kentucky", "Los Angeles", 200, 100));
        datosAeropuertos[1].obtenerCompany("Fly Emirates").insertarVuelo(new Vuelo("AA12", "Los Angeles", "Rio Grande do Sul", 1200, 250));
        datosAeropuertos[1].obtenerCompany("Qatar").obtenerVuelo("AA11").insertarPasajero(new Pasajero("Pepe", "1234", "Mexicana"));
        datosAeropuertos[1].obtenerCompany("Fly Emirates").obtenerVuelo("AA12").insertarPasajero(new Pasajero("Juan", "5678", "Guatemalteco"));

        datosAeropuertos[2] = new AeropuertoPublico("Heathrow", "Londres", "Reino Unido", 1000000);
        datosAeropuertos[2].insertarCompany(new Company("British Airways"));
        datosAeropuertos[2].insertarCompany(new Company("Virgin Atlantic"));
        datosAeropuertos[2].obtenerCompany("British Airways").insertarVuelo(new Vuelo("BA123", "Londres", "Nueva York", 1500, 200));
        datosAeropuertos[2].obtenerCompany("Virgin Atlantic").insertarVuelo(new Vuelo("VA456", "Nueva York", "Londres", 1800, 180));
        datosAeropuertos[2].obtenerCompany("British Airways").obtenerVuelo("BA123").insertarPasajero(new Pasajero("Emma", "56789", "Británica"));
        datosAeropuertos[2].obtenerCompany("Virgin Atlantic").obtenerVuelo("VA456").insertarPasajero(new Pasajero("James", "98765", "Estadounidense"));

        // Aeropuerto 3 (posición 3):
        datosAeropuertos[3] = new AeropuertoPrivado("Le Bourget", "París", "Francia");
        datosAeropuertos[3].insertarCompany(new Company("Air France"));
        datosAeropuertos[3].insertarCompany(new Company("Lufthansa"));
        String[] empresasAeropuerto3 = {"Airbus", "Boeing"};
        if (datosAeropuertos[3] instanceof AeropuertoPrivado) {
            ((AeropuertoPrivado) datosAeropuertos[3]).insertarEmpresas(empresasAeropuerto3);
        }
        datosAeropuertos[3].obtenerCompany("Air France").insertarVuelo(new Vuelo("AF789", "París", "Frankfurt", 300, 150));
        datosAeropuertos[3].obtenerCompany("Lufthansa").insertarVuelo(new Vuelo("LH456", "Frankfurt", "Nueva York", 2200, 180));
        datosAeropuertos[3].obtenerCompany("Air France").obtenerVuelo("AF789").insertarPasajero(new Pasajero("Sophie", "112233", "Francesa"));
        datosAeropuertos[3].obtenerCompany("Lufthansa").obtenerVuelo("LH456").insertarPasajero(new Pasajero("Max", "445566", "Alemán"));
    }

    private static void mostrarDatosAeropuertos(Aeropuerto[] asignados) {
        for (int i = 0; i < asignados.length; i++) {
            if (asignados[i] != null) {
                if (asignados[i] instanceof AeropuertoPrivado) {
                    System.out.println("Aeropuerto privado");
                    System.out.println("Nombre del aeropuerto: " + asignados[i].getNombre());
                    System.out.println("Ciudad: " + asignados[i].getCiudad());
                    System.out.println("Pais: " + asignados[i].getPais());
                    System.out.println();
                } else {
                    System.out.println("Aeropuerto publico");
                    System.out.println("Nombre del aeropuerto: " + asignados[i].getNombre());
                    System.out.println("Ciudad: " + asignados[i].getCiudad());
                    System.out.println("Pais: " + asignados[i].getPais());
                    System.out.println();
                }
            }
        }
    }

    private static void mostrarDatosHerenciaAeropuerto (Aeropuerto[]asignados){
        String[]empresas = null;
        for (int i = 0; i < asignados.length; i++) {
            if (asignados[i]!=null){
                if (asignados[i] instanceof AeropuertoPrivado){
                    System.out.println("Aeropuerto privado: "+asignados[i].getNombre());
                    empresas=((AeropuertoPrivado)asignados[i]).getEmpresas();
                    for (int j = 0; j < empresas.length; j++) {
                        if (empresas[j]!=null){
                            System.out.println("Empresa "+(j+1)+": "+empresas[j]);
                        }
                    }
                    System.out.println(" ");
                } else {
                    System.out.println("Aeropuerto publico: "+asignados[i].getNombre());
                    System.out.println(((AeropuertoPublico)asignados[i]).getSubvencion());
                    System.out.println(" ");
                }
            }
        }
    }
    private static Aeropuerto getAeropuertoenBusqueda(Aeropuerto[]asignados, String nombreAeropuerto){
        boolean encontrado=false;
        Aeropuerto buscado = null;
        for (int i = 0; i < asignados.length && !encontrado; i++) {
            if (asignados[i]!=null){
                if (nombreAeropuerto.trim().equalsIgnoreCase(asignados[i].getNombre())){
                    buscado=asignados[i];
                    encontrado=true;
                }
            }
        }
        return buscado;
    }

    private static void mostrarCompanies (Aeropuerto asignado){
        System.out.println("Las compañias son : "+asignado.getNombre());
        for (int i = 0; i < asignado.getNumCompanies(); i++) {
            System.out.println(asignado.obtenerCompany(i).getNombre());
        }
    }
    private static void mostrarVuelos (Company asignada) {
        for (int i = 0; i < asignada.getNumVuelos(); i++) {
            System.out.println(asignada.obtenerVuelo(i).getIdentificador());
        }
    }

    private static void mostrarVuelosOrigenDestino (String origen, String destino, Aeropuerto []aeropuerto){
        Vuelo[]vuelos;
        vuelos=buscarVuelosOrigenDestino(origen,destino,aeropuerto);
        if (vuelos.length==0){
            System.err.println("No existen vuelos de esa ciudad origen a destino");
        } else {
            System.out.println("Vuelos encontrados");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("Identificador de vuelo: "+vuelos[i].getIdentificador());
                System.out.println("Ciudad origen: "+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad origen: "+vuelos[i].getCiudadDestino());
                System.out.println("Precio: "+vuelos[i].getPrecio());
            }
        }
    }

    private static Vuelo[] buscarVuelosOrigenDestino (String origen, String destino, Aeropuerto []aeropuerto){
        Vuelo vuelo;
        int contador = 0;
        Vuelo []listaVuelos;
        for (int i = 0; i < aeropuerto.length; i++) { //Recorremos los aeropuertos
            for (int j = 0; j < aeropuertos[i].getNumCompanies(); j++) { //Recorremos las compañias
                for (int k = 0; k < aeropuertos[i].obtenerCompany(j).getNumVuelos(); k++) {
                    vuelo=aeropuerto[i].obtenerCompany(j).obtenerVuelo(k);
                    if (origen.equals(vuelo.getCiudadOrigen()) && (destino.equals(vuelo.getCiudadDestino()))){
                        contador++;
                    }


                }
            }
        }
        listaVuelos=new Vuelo[contador];
        int q = 0;

        for (int i = 0; i < aeropuerto.length; i++) {
            for (int j = 0; j < aeropuerto[i].getNumCompanies(); j++) {
                for (int k = 0; k < aeropuerto[i].obtenerCompany(j).getNumVuelos(); k++) {
                    vuelo = aeropuerto[i].obtenerCompany(j).obtenerVuelo(k);
                    if (origen.equals(vuelo.getCiudadOrigen()) && destino.equals(vuelo.getCiudadDestino())){
                        listaVuelos[q]=vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelos;
    }



}
