package Domain;

import java.awt.Color;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class Tablero {

	   private Casilla[][] board;
	   public int[][] tableroposicionesvisuales;

	   private  int tamaño;
	   private int especiales;
	   	  	
	   public Tablero(int tamaño, int casillaspeciales, int aparicion){
		   
		   this.tamaño=tamaño;
		   this.especiales=casillaspeciales;
	        board = new Casilla[tamaño][tamaño];
	        
	        posicionesvisuales(tamaño);
	        llenartablerodecasillas();
	        generarSerpientesEscaleras(aparicion);
	        if (casillaspeciales!=0) {
	        	
	        	añadircasillasespeciales(this.especiales, tamaño);
	        	
	        }
	        
	   }
	   
	   private void posicionesvisuales (int tamaño) {
			 int filas =  tamaño;
		     int columnas = tamaño;

		     int[][] matriz = new int[filas][columnas];

		     for (int i = 0; i < filas; i++) {
		         if (i % 2 == 0) {
		             for (int j = 0; j < columnas; j++) {
		                 matriz[i][j] = (i * columnas) + j + 1;
		             }
		         } else {
		             for (int j = columnas - 1; j >= 0; j--) {
		                 matriz[i][j] = (i * columnas) + (columnas - j);
		             }
		         }
		     }
		    tableroposicionesvisuales = new int[filas][columnas];
		     for (int i = 0; i < filas; i++) {
		         for (int j = 0; j < columnas; j++) {
		        	 tableroposicionesvisuales[i][j] = matriz[filas - 1 - i][j];
		         }
		     }
		     
		 
		}
	  
	 
	   
	   public void llenartablerodecasillas() {
		   
		  		   
		   for (int i = 0; i < board.length; i++) {
			    for (int j = 0; j < board[i].length; j++) {
			    	int n=tableroposicionesvisuales[i][j];
			    	Casilla casilla = new CasillaNormal();
			    	casilla.setCasilla(n);
			    	casilla.setfila(i);
			    	casilla.setcolumna(j);
	                board[i][j]=casilla;
	                
			    }
			}
	   }
	   public Casilla[][] arrayTablero() {
		   return board;
	   }
	   
	   public void generarSerpientesEscaleras(int aparicion) {
		   
		   Double  numerocasillasespeciales =(double) (((double)aparicion)/100) * (double) (tamaño*tamaño);
		   int numeroSerpEscaleras = (int) Math.round(numerocasillasespeciales);
		   ArrayList<Casilla> casillas = obtenerCasillasNormales(aparicion, 1, tamaño*tamaño-1);
		   
		   List<Casilla> cabeza = casillas.subList(0,(casillas.size()/2));
		   List<Casilla> cola = casillas.subList((casillas.size()/2), casillas.size());
		   
		   for (int i = 0; i < (casillas.size()/2); i++) {
			   
			   Random random = new Random();
			   int valor = random.nextInt(2) + 1;
			   if(valor == 1) {
				   
				   if(cola.get(i).getCasilla() > cabeza.get(i).getCasilla()) {
					   
					   cola.get(i).addSerpiente(cabeza.get(i));
				   
				   }
				   else {
					   
					   cabeza.get(i).addSerpiente(cola.get(i));
					   
				   }
			   }
			   else {
				   
				   if(cola.get(i).getCasilla() > cabeza.get(i).getCasilla()) {
					   
					   cabeza.get(i).addEscalera(cola.get(i));
				   
				   }
				   else {
					   
					   cola.get(i).addEscalera(cabeza.get(i));
					   
				   }
				   
				   
			   }
			   
		   }
		   
	   }
	   
	   public void añadircasillasespeciales(int porcentaje, int tamaño) {
		   
		    Double porcentajeEsp = (double) porcentaje;
			Double  numerocasillasespeciales =(double) (porcentajeEsp/100) * (double) (tamaño*tamaño);
			Casilla casilla;
			int numerocasillas = (int) Math.round(numerocasillasespeciales);
       

			int[] posicionesCEspeciales=generarNumerosAleatoriosSinRepeticiones(numerocasillas, 2, tamaño*tamaño-1);
			for (int i = 0; i < posicionesCEspeciales.length; i++) {
				

				Random random = new Random();
				int valor = random.nextInt(2) + 1;
				if (valor==1) {
		    	 casilla = new CasillaMortal();
		    	int[] posiciones =obtenervalorcfilacolumna(posicionesCEspeciales[i]);	    	
		        board[posiciones[0]][posiciones[1]]=casilla;
		    	casilla.setCasilla(posicionesCEspeciales[i]);
		    	casilla.setfila(posiciones[0]);
		    	casilla.setcolumna(posiciones[1]);
				}else {
					
			    	casilla = new CasillaSaltarina();
			    	int[] posiciones =obtenervalorcfilacolumna(posicionesCEspeciales[i]);	    	
			        board[posiciones[0]][posiciones[1]]=casilla;
			    	casilla.setCasilla(posicionesCEspeciales[i]);
			    	casilla.setfila(posiciones[0]);
			    	casilla.setcolumna(posiciones[1]);
				
				
				}
			}
		   
	   }
	   
	   /**
	    * Obtiene un ArrayList de casillas normales paara las serpientes y escaleras
	    * @param cantidad cantidad de casillas normales que se requiere
	    * @param minimo valor minimo para generar las casilla aleatoria
	    * @param maximo valor maximo para generar las casilla aleatoria
	    * @return ArrayList de casillas normales
	    */
	   private ArrayList<Casilla> obtenerCasillasNormales(int cantidad, int minimo, int maximo) {
		   
		   ArrayList<Casilla> casillasSerpienteEscaleras = new ArrayList<>();
		   int cantidadTotal = cantidad * 2;
		   Casilla casillaAleatoria = obtenerCasillaNormal(minimo, maximo);

		   while(cantidadTotal != 0 && !casillasSerpienteEscaleras.contains(casillaAleatoria)) {
			 
			   casillasSerpienteEscaleras.add(casillaAleatoria);
			   cantidadTotal--;
		   }
		  
		  return casillasSerpienteEscaleras;
		   
	   }
	   
	   /**
	    * Obtiene una casilla normal aleatoria
	    * @param minimo valor minimo para generar las casilla aleatoria
	    * @param maximo valor maximo para generar las casilla aleatoria
	    * @return casilla normal aleatoria
	    */
	   private Casilla obtenerCasillaNormal(int minimo, int maximo) {
		   
		   Random random = new Random();
		   int numeroAleatorio = random.nextInt(maximo - minimo + 1) + minimo;
		   int[] posicion = obtenervalorcfilacolumna(numeroAleatorio);
		   
		   while(!(board[posicion[0]][posicion[1]] instanceof CasillaNormal)) {
			   
			   numeroAleatorio = random.nextInt(maximo - minimo + 1) + minimo;
			   posicion = obtenervalorcfilacolumna(numeroAleatorio);
			   
		   }
		   
		   return board[posicion[0]][posicion[1]];
	   }
	   
	   public static int[] generarNumerosAleatoriosSinRepeticiones(int cantidad, int minimo, int maximo) {
	        
	        int[] numeros = new int[cantidad];
	        Set<Integer> numerosGenerados = new HashSet<>();
	        Random random = new Random();
	        
	        int contador = 0;
	        while (contador < cantidad) {
	            int numeroAleatorio = random.nextInt(maximo - minimo + 1) + minimo;
	            if (!numerosGenerados.contains(numeroAleatorio)) {
	                numeros[contador] = numeroAleatorio;
	                numerosGenerados.add(numeroAleatorio);
	                contador++;
	            }
	        }
	        
	        return numeros;
	    }
		  
	   
	   public  int[] obtenervalorcfilacolumna(int valor) {
		   
	       int[] posicion = new int[2];

	       for (int fila = 0; fila < board.length; fila++) {
	           for (int columna = 0; columna < board[fila].length; columna++) {
	               if (board[fila][columna].getCasilla() == valor) {
	                   posicion[0] = fila;
	                   posicion[1] = columna;
	                   break;
	               }
	           }
	       }

	       return posicion;
	   } 
	   
	   public  int obtenervalorcasilla(int filas, int columnas) {
			   
	       int casilla = 1;
	       casilla = board[filas][columnas].getCasilla();
	       return casilla;
	       
	   }
	   
	   public  int obtenertipocasilla(int filas, int columnas) {
		   
	       int casilla = 1;
	        casilla = board[filas][columnas].getCasilla();
	       return casilla;
	       
	   }
	   
	   public  Color Color(int filas, int columnas) {
		   
	       Color color = board[filas][columnas].getcolor();
	       return color;
	       
	   } 
   
}
