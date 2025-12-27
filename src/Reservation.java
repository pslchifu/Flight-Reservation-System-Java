public class Reserva {
    private String nombrePasajero, numeroPasaporte;
    private Vuelo vuelo;

    //CONSTRUCTOR
    public Reserva(String nombrePasajero, String numeroPasaporte, Vuelo vuelo){
        this.nombrePasajero = nombrePasajero;
        this.numeroPasaporte = numeroPasaporte;
        this.vuelo = vuelo;
    }
    
    //GETS Y SETTERS
    public String getNombrePasajero(){
        return nombrePasajero;
    }
    public String getNumeroPasaporte(){
        return numeroPasaporte;
    }
    public Vuelo getVuelo(){
        return vuelo;
    }

    public void setNombrePasajero(String nombrePasajero){
        this.nombrePasajero = nombrePasajero;
    }
    public void setNumeroPasaporte(String numeroPasaporte){
        this.numeroPasaporte = numeroPasaporte;
    }
    public void setVuelo(Vuelo vuelo){
        this.vuelo = vuelo;
    } 

    //MÉTODOS
    public void mostrarInformacionReserva(){
        System.out.println("=== RESERVA ===");
        System.out.println("Nombre de pasajero: "+nombrePasajero);
        System.out.println("Numero de pasaporte: "+numeroPasaporte);
        System.out.println("=== VUELO ===\n"+vuelo.mostrarInformacionVuelo());
    }

    


}
