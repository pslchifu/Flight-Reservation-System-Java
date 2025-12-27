public class Vuelo {
    
    private String numeroVuelo, origen, destino;
    private int asientosDisponibles;

    //CONSTRUCTOR
    public Vuelo(String numero, String origen, String destino, int asientosDisponibles){
        this.numeroVuelo = numero;
        this.origen = origen;
        this.destino= destino;
        this.asientosDisponibles = asientosDisponibles;
    }
    //GETS Y SETTERS 
    public String getNumVuelo(){
        return numeroVuelo;
    }
    public String getOrigen(){
        return origen;
    }
    public String getDest(){
        return destino;
    }
    public int getAsienDispo(){
        return asientosDisponibles;
    }

    public void setNumVuelo(String numerovuelo){
        this.numeroVuelo = numerovuelo;    
    }
    public void setOrig(String origen){
        this.origen = origen;
    }
    public void setDest(String destino){
        this.destino = destino;
    }
    public void setAsientDispo(int asientosDisponibles){
        this.asientosDisponibles = asientosDisponibles;
    }

    //MÉTODOS
    public boolean reservarAsiento(){
      if (asientosDisponibles > 0){
        asientosDisponibles--;
        return true;
      }else{
        System.out.println("X Lo sentimos, el vuelo está completo. No hay asientos disponibles.");
        return false;
       }                   
    }

    public String mostrarInformacionVuelo(){
        String informacion = "Número de vuelo: "+numeroVuelo+"\n"+"Origen: "+origen+"\n"+"Destino: "+destino+"\n"+"Asientos disponibles: "+asientosDisponibles;
        return informacion;       
    }

    



}
