import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner kb = new Scanner(System.in); 
    //VUELOS PREDEFINIDOS
    Vuelo v1 = new Vuelo("LATAM458", "Lima", "Madrid", 100);
    Vuelo v2 = new Vuelo("IB891", "Málaga", "Paris", 2);

    //RESERVA INICIALIZADA EN NULL
    Reserva r = new Reserva(null, null, null);
    Random R= new Random();
    
    int opc= -1;
    String reserva = "";
    boolean ReservaActiva = false;
    
    while (opc!= 0){
    

    System.out.println("=== SISTEMA DE GESTIÓN DE VUELOS ===");
    System.out.println("1. Ver vuelos disponibles");
    System.out.println("2. Realizar reserva");
    System.out.println("3. Ver detalles de una reserva");
    System.out.println("4. Cancelar reserva");
    System.out.println("0. Salir");
    System.out.print("Seleccione una opción: ");

    opc = kb.nextInt();
    kb.nextLine(); 
 
    String reservacomprobacion = "";
    switch (opc) {
        case 1:
            System.out.println( "\n======================================\n" );
            System.out.println(v1.mostrarInformacionVuelo());
            System.out.println( "\n======================================\n" );
            System.out.println(v2.mostrarInformacionVuelo());
            System.out.println( "\n======================================\n" );
            break;

        case 2:
    
            if (ReservaActiva) {
                System.out.println("Ya existe una reserva activa. Si continua se borrara la reserva anterior. ¿Desea continuar? (1. si / 2. no): ");
                int continuar = kb.nextInt();
                kb.nextLine();
                if (continuar == 2) {
                    break;
                } else if (continuar == 1) {
                    ReservaActiva = false;
                } else {
                    System.out.println("Opción inválida");
                    break;
                }
            }

            System.out.println( "\n======================================\n" );
            System.out.println(v1.mostrarInformacionVuelo());
            System.out.println( "\n======================================\n" );
            System.out.println(v2.mostrarInformacionVuelo());
            System.out.println( "\n======================================\n" );
            
            //SELECCIÓN DE VUELO
            System.out.println("Seleccione un vuelo (1 o 2)");
            int seleccion = kb.nextInt();
            kb.nextLine();
            if (seleccion == 1){
                r.setVuelo(v1);
            }else if (seleccion == 2) {
                r.setVuelo(v2);
            } else {
              System.out.println("Selección inválida");
              break;
            }
            Vuelo vueloEscogido = r.getVuelo();
            if (!vueloEscogido.reservarAsiento()){
            break;
            }else{
                                             
            //TOMA DE DATOS PARA RESERVA
            System.out.print("Nombre del pasajero: ");
            String nombre = kb.nextLine(); 
            r.setNombrePasajero(nombre);
            System.out.print("Número de pasaporte: ");
            String numPas = kb.nextLine(); 
            r.setNumeroPasaporte(numPas);

            //CONFIRMACIÓN DE LOS DATOS Y CÓDIGO DE RESERVA

            r.mostrarInformacionReserva();
            System.out.println("Los datos son correctos? (1. si / 2. no): ");
            int confirmacion = kb.nextInt();
            kb.nextLine(); 
            if (confirmacion == 2 ){
                System.out.println("Inicie de nuevo el proceso de reserva, por favor.");
                vueloEscogido.setAsientDispo(vueloEscogido.getAsienDispo()+1); //asiento devuelto
                break;
            } else if (confirmacion ==1) {
                reserva = String.format("R"+R.nextInt(0001,1000)); //GENERACIÓN DE CÓDIGO DE RESERVA;
                System.out.println("Reserva exitosa - CÓDIGO DE RESERVA: "+reserva);
                ReservaActiva = true;
            }else{
                System.out.println("Opción inválida");
                break;
            }
            break;
            }

        case 3:
            System.out.print("Introduzca su código de reserva: ");
            reservacomprobacion = kb.nextLine();
            if (reservacomprobacion.equals(reserva)){ //comprobación de código
            r.mostrarInformacionReserva();
            } else{
                System.out.println("No se encontró ninguna reserva con ese código");
            }
            break;

        case 4:

            System.out.print("Introduzca su código de reserva: ");
            reservacomprobacion = kb.nextLine();
            if (reservacomprobacion.equals(reserva)){ //comprobación de código
            //cancelación de reserva
            r.setNombrePasajero(null);
            r.setNumeroPasaporte(null); 
            System.out.println("Su reserva ha sido cancelada con éxito.");
            vueloEscogido = r.getVuelo();
            vueloEscogido.setAsientDispo(vueloEscogido.getAsienDispo()+1); //asiento devuelto
            reserva = "";
            ReservaActiva = false;
            } else{
                System.out.println("No se encontró ninguna reserva con ese código");
            }
            break;
        case 0:
            System.out.println("Gracias por usar el sistema de gestión de vuelos. ¡Hasta luego!");
            break;
        default:
            System.out.println("Numero inválido, por favor intente de nuevo.");
            break;
    }
    }
    kb.close();
        
    }
}