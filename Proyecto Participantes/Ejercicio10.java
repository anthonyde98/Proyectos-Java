import java.util.Scanner;

public class Ejercicio10 {

// Nombre Autor: Anthony Delanoy Peralta Perez
// Matricula: 100430840
// Asignatura: Lenguaje de Programacion 2 (INF-514)
// Seccion: Z01
// Fecha realizado: 07/04/2019
// Hora realizado: 12:17 PM
// Profesor: Angel Asencio

    private static Participante participante [] = new Participante[10];
    private static int contador = 0;
    
    public static void main (String [] args){
	
        System.out.println("Programa de gestion de participantes");
        
        Menu();        
    }
    
    public static void Menu(){
        
        Scanner entrada = new Scanner(System.in);
        
        int opcion = 0;
                        
        System.out.println("\nMenu");
        
        if(contador < 10){
            System.out.println("\n1)Inscribir un participante");
        }
        
        System.out.println("\n2)Mostrar listado de datos");
        System.out.println("\n3)Mostrar listado por marcas");
        System.out.println("\n4)Finalizar el programa");
        System.out.println("\n\nSeleccione una opcion: ");
        
        opcion = entrada.nextInt();
        
        switch(opcion){
            
            case 1:
                InscribirParticipante();                
                break;
            case 2:
                MostrarListadoDeDatos();
                break;
            case 3:
                MostrarListadoPorMarcas();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("\nEsta no es una opcion valida. Intentelo de nuevo.");
                Menu();
                break;            
        }        
    }
    
    public static void InscribirParticipante(){
        
        String nombreCompleto;
        double marca2002;
        double marca2001;
        double marca2000;
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nNombre del participante " + (contador + 1));
        nombreCompleto = entrada.nextLine();
        System.out.println("\nMejor marca del 2002");
        marca2002 = entrada.nextDouble();
        System.out.println("\nMejor marca del 2001");
        marca2001 = entrada.nextDouble();
        System.out.println("\nMejor marca del 2000");
        marca2000 = entrada.nextDouble();
        
        participante[contador] = new Participante(nombreCompleto, marca2002, marca2001, marca2000);
        
        contador++;
        
        Menu();
    }
    
    public static void MostrarListadoDeDatos(){
                        
        if(participante[0] == null){
            
            System.out.println("\nNo hay datos para mostrar");
            Menu();
        }
        else{
            
            System.out.println("\nLista de participantes");
            
            for(int i = 0; i < 10; i++)
            {
                if(participante[i] != null){
                    
                    System.out.println("\nParticipante numero " + (i + 1));
                    System.out.println("\nNombre Completo  : " + participante[i].getNombre());
                    System.out.println("\nMejor Marca 2002 : " + participante[i].getMarca2());
                    System.out.println("\nMejor Marca 2001 : " + participante[i].getMarca1());
                    System.out.println("\nMejor Marca 2000 : " + participante[i].getMarca0());
                }
            }
            
            Menu();
        }           
    }
    
    public static void MostrarListadoPorMarcas(){
        
        double orden[] = new double[10];
        
        for(int i = 0; i < 10; i++){
            
            if(participante[i] != null){
                orden[i] = participante[i].getMarca2(); 
            }
        }
        
        for (int i = 0; i < orden.length; i++){
            
            for (int j = 0; j < orden.length - i - 1; j++) {
                if(orden[j] < orden[j+1]){
                    double tmp = orden[j+1];
                    orden[j+1] = orden[j];
                    orden[j] = tmp;
                }
            }
        }
        
        System.out.println("\nMarca 2002 de cada participande de mayor a menor\n");
        
        for(int i = 0; i < orden.length; i++){
            
            if(orden[i] != 0)
            System.out.println((i + 1) + ") " + orden[i]);
        }
        
        Menu();
    }    
}

class Participante{ 

    private String nombreCompleto;
        private double marca2002;
        private double marca2001;
        private double marca2000;
	
	public Participante(String nombre, double marca2, double marca1, double marca0){		
		
		nombreCompleto = nombre;
		marca2002 = marca2;
		marca2001 = marca1;
                marca2000 = marca0;
	}
	
	public String getNombre(){
		
		return nombreCompleto;
	}
	
	public double getMarca2(){
		
		return marca2002;
	}
	
	public double getMarca1(){
		
		return marca2001;
	}
	
	public double getMarca0(){
		
		return marca2000;
	}       
}
