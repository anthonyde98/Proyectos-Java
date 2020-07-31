import java.util.Scanner;

public class Ejercicio9 {

// Nombre Autor: Anthony Delanoy Peralta Perez
// Matricula: 100430840
// Asignatura: Lenguaje de Programacion 2 (INF-514)
// Seccion: Z01
// Fecha realizado: 07/04/2019
// Hora realizado: 8:17 PM
// Profesor: Angel Asencio

    public static void main (String [] args){
		
		int articulo = 0;
		double litros = 0;
		double precioLitro = 0;
		double cantidadLitrosVentdidosA1 = 0;
		int cantidadFacturasMayor6k = 0;
		

        Factura factura [] = new Factura [5];
		
		Scanner entrada = new Scanner(System.in);
    
		System.out.print("Ingresa 5 facturas: \n");
		
		for(int i = 0; i <5; i++){
					
			System.out.print("\nArticulo: ");
			articulo = entrada.nextInt();
			
			System.out.print("\nLitros vendidos: ");
			litros = entrada.nextDouble();
			
			System.out.print("Precio por litro: ");
			precioLitro = entrada.nextDouble();
			
			factura[i] = new Factura(articulo, litros, precioLitro);
		}
		
		for(int i = 0; i < 5; i++){
			
			System.out.print("\nMonto de la factura " + (i + 1) + ": RD$ " + factura[i].MontoTotal());
            
			if(factura[i].MontoTotal() > 6000)
				cantidadFacturasMayor6k++;
			
		}
		
		for(Factura fact : factura){
			
			if(fact.getCodigoArticulo() == 1)
				cantidadLitrosVentdidosA1 += fact.getLitros();
		}
		
		System.out.print("\n\nCantidad de litros vendidos del articulo 1: " + cantidadLitrosVentdidosA1);
		System.out.print("\nCantidad de facturas mayor a RD$ 6,000: " + cantidadFacturasMayor6k + "\n");
		
    }
}

class Factura{ 

    private int codigoArticulo;
	private double litros;
	private double precioLitros;
	
	public Factura(int cA, double l, double precioL){		
		
		codigoArticulo = cA;
		litros = l;
		precioLitros = precioL;
	}
	
	public int getCodigoArticulo(){
		
		return codigoArticulo;
	}
	
	public double getLitros(){
		
		return litros;
	}
	
	public double getPrecioLitros(){
		
		return precioLitros;
	}
	
	public double MontoTotal(){
		
		return (litros * precioLitros);
	}
}
