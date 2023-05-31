package Domain;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class PoobStairs {
	
	private Dado dado;
	private int Njugadores;
	private static int tamañoTablero;
	private int casillasEspeciales;
	private int modificadores;
	private boolean trasformaciones;
	private int porcentajeEscalerasSerpientes;
    public ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private int turno=1;
    
    private boolean haymodificadores;

	public PoobStairs() {
		
    	jugadores = new ArrayList<>();
    	dado = new Dado();

	}
	
	/**
	 * Añade un nuevo jugador
	 * @param name nombre del jugador
	 * @param color color del jugador
	 */
    public void addplayer(String name, String color) {
    	
 	   Jugador jugador1 = new Humano(name, color, tamañoTablero);
 	   jugadores.add(jugador1);
	
 	 
    }
    
    /**
     * Retorna el tamaño del tablero
     * @return tamaño del tablero
     */
    public int getSize() {
    	
        return tamañoTablero;
        
    }
    
    /**
     * Añade un tablero tomando en cuenta los porcentajes de aparicion de las casila especiales y las serpientes y escalera
     * @param tamañoTablero tamaño del tablero
     * @param casillasEspeciales aparicion de las casillas especiales
     * @param aparicionSerpEscaleras aparicion de las serpiente y escalera
     */
    public void addTablero(int tamañoTablero, int casillasEspeciales, int aparicionSerpEscaleras) {
    	
    	tablero = new Tablero (tamañoTablero,casillasEspeciales, aparicionSerpEscaleras);
    	
    }
    
    public void addMaquina(String name, String color, String tipoMaquina) {
 		
 	   Jugador jugador1 = new Maquina(name, color,tipoMaquina, tamañoTablero);
 	   jugadores.add(jugador1);
 	 
   }
   
    /**
     * Actualiza el estado de los daso, dandole un valor entre 1 y 6 y activando la probabilidad de los modificadores
     */
   public void tirardados() {
	   
	 dado.tirar();
	 dado.probabilidadModificadores(modificadores);
	 haymodificadores= dado.getmodificadores();

   }
    
   /**
    * Verifica si hay un ganador
    * @param turno turno del jugador 1 o 2
    * @return retorn true si hay ganador y false si no lo hay
    */
   public boolean hayGanador(int turno) {
	   
	 boolean hayganador = false;
	
	 int posiblecasilla = jugadores.get(turno-1).getFichaJug().getCasilla();
	    
		if(posiblecasilla == (tamañoTablero*tamañoTablero)) {
			
			hayganador = true;
		}
		
	 return hayganador;
   }
    
   /**
    * Cambia de posicion la ficha segun el turno que haya
    * @param turno turno del jugador 1 o 2
    */
    public void cambioposicion(int turno) {
    	
    	 int varTemCasilla1= jugadores.get(0).getFichaJug().getCasilla();
    	 int varTemCasilla2= jugadores.get(1).getFichaJug().getCasilla();
    	 jugadores.get(0).getFichaJug().newCasilla(varTemCasilla2);
    	 jugadores.get(1).getFichaJug().newCasilla(varTemCasilla1);
    	 
    }
    
    /**
     * 
     * @param turno turno del jugador 1 o 2
     */
    public void bonificacion(int turno) {
    	
    	int fila=0;
    	int columna=0; 
	    int casilla= jugadores.get(turno-1).getFichaJug().getCasilla();
	    
	    if (casilla +1 <=tamañoTablero*tamañoTablero) {
	    	
		   jugadores.get(turno-1).getFichaJug().newCasilla(casilla+1);
		   
	    }
	}
    
    /**
     * Retorna si hay modificadores
     * @return variable haymodificadores
     */
    public boolean haymodificadores() {
    	
    	return haymodificadores;
    	
    }
    
    /**
     * Actualiza el estado de las fichas y el tablero, moviendo las fichas segun el valor del dado
     */
    public void jugar() {	   
 	  
 	   int valor=getValorDado();
 	   
  	   if (turno==1) {
  		   
 			int posiblecasilla =jugadores.get(0).getFichaJug().getCasilla()+valor;
 		
 			if (posiblecasilla  <=tamañoTablero*tamañoTablero) {
 				
  			jugadores.get(0).getFichaJug().setCasilla(valor); 
 			int casillaActual = jugadores.get(0).getFichaJug().getCasilla();
 			//casillasEspeciales( casillaActual, 0);
 			turno ++; 
 			
 			}else {
 				JOptionPane.showMessageDialog(null, "!No te alcanza para ganar!");

 				turno ++; 
 			}
   	   }else {
   		    int posiblecasilla =jugadores.get(1).getFichaJug().getCasilla()+valor;

 			if (posiblecasilla  <=tamañoTablero*tamañoTablero) {
   		   	jugadores.get(1).getFichaJug().setCasilla(valor); 
 			int casillaActual = jugadores.get(1).getFichaJug().getCasilla();	
 			//casillasEspeciales( casillaActual, 1);
 			turno= turno-1;
 			
 			}else {
 				JOptionPane.showMessageDialog(null, "!No te alcanza para ganar!");
 				turno= turno-1;
 			}
   	   } 
    }
    
    /**
     * Verifica si la casilla es especial y activa la funcion de dicha casilla
     * @param turnos turno del jugador
     */
    public void casillasEspeciales1(int turnos) {
    	
    	int turno = turnos-1;
		int casilla = jugadores.get(turno).getFichaJug().getCasilla();	

    	int[] posiciones = obtenercasilla(casilla);
    	Casilla[][] Casillas = tablero.arrayTablero();
    	
    	if (Casillas[posiciones[0]][posiciones[1]] instanceof CasillaMortal) { 
    		
    		jugadores.get(turno).getFichaJug().newCasilla(1);
    		String name = jugadores.get(turno).getNombre();
    		JOptionPane.showMessageDialog(null, "!Te devuelves al inicio del juego" +name+"!" );
    		
    	}else if (Casillas[posiciones[0]][posiciones[1]] instanceof CasillaSaltarina) {

			Random random = new Random();
			int valor = random.nextInt(6) + 1;
    		jugadores.get(turno).getFichaJug().setCasilla(valor);
    		JOptionPane.showMessageDialog(null, "!Avanzas "+valor+" Posiciones Genial!" );
    		String name = jugadores.get(turno).getNombre();
    		JOptionPane.showMessageDialog(null,"!" +name+ " Avanzas "+valor+" Posiciones Genial!" );
    			
    	}
    	
    }   

    /**
     * Retorna la posicion de la fila y la columna de la casilla
     * @param turno turno del jugador
     * @return array con los valores de la filoa y la columna
     */
 	 public  int[] obtenercasillaXY(int turno) {
 		 
 	     int valor = jugadores.get(turno-1).getFichaJug().getCasilla();
 		 int[] posicion = new int[2];
 		 posicion = tablero.obtenervalorcfilacolumna(valor);
 		 return posicion;
 	}
 	 
 	/**
 	 * Retorna el valor del dado
 	 * @return valor del dado
 	 */
	public int getValorDado() {
		
		return dado.getValor();
		
	}
	
	/**
	 * Posicion donde se encuentra la casilla
	 * @param fila fila de la casilla
	 * @param columna columna de la casilla
	 * @return
	 */
	 public  int obtenerposcasillas(int fila, int columna) {
	       
		 int posicion = tablero.obtenervalorcasilla(fila,columna);
	     return posicion;
	     
	 }
	
	 /**
	  * Obtiene la fila y la columna de la casilla
	  * @param valor valor de la casilla
	  * @return array de entero con la fila y la columna de la casilla
	  */
	 public  int[] obtenercasilla(int valor) {
		       
		 int[] posicion = new int[2];
		 posicion = tablero.obtenervalorcfilacolumna(valor);
		 return posicion;
	}
	 
	/**
	 * Obtiene el color
	 * @param fila
	 * @param columna
	 * @return
	 */
	public  Color obtenercolor(int fila,int columna) {
	
	   Color color = tablero.Color(fila, columna);
	   return color;
	   
	}
	
	/**
	 * Asigna un valor al número de jugadores
	 * @param numJugadores numero de jugadores
	 */
	public void setJugadores(int numJugadores) {
		
		Njugadores = numJugadores;
		
	}
	
	/**
	 * Asigna un tamaño al tablero
	 * @param tamano tamno que se quiere asignar al tablero
	 */
	public void setSize(int tamano) {
		
		tamañoTablero = tamano;
		
	}
	
	/**
	 * Asigna el porcentaje de aparicion de casillas especiales
	 * @param casillasEspeciales porcentaje que tiene para las casilla
	 */
	public void setCasillaEspeciales(int casillasEspeciales) {
		
		this.casillasEspeciales = casillasEspeciales;
		
	}
	
	/**
	 * Asigna el porcentaje de aparicion de modificadores
	 * @param modificadores porcentaje de aparicion de los modificadores
	 */
	public void setModificadores(int modificadores) {
		
		this.modificadores = modificadores;
		
	}
	
	/**
	 * Asigna si habran o no transformaciones
	 * @param trasformaciones true si habran transformaciones, false si no habran
	 */
	public void setTransformaciones(boolean trasformaciones) {
		
		this.trasformaciones = trasformaciones;
		
	}
	
	/**
	 * Asigna el porcentaje de aparicion de las serpientes y escaleras
	 * @param porcentajeSerpientesScaleras porcentjae de aparicion de las serpientes y escaleras
	 */
	public void setPorcentajeEspeciales(int porcentajeSerpientesScaleras) {
		
		this.porcentajeEscalerasSerpientes = porcentajeSerpientesScaleras;
		
	}
	
	/**
	 * Retorna el porcentaje de las casillas especiales
	 * @return porcentaje de las casillas especiales
	 */
	public int getCasillasEspeciales() {
	
		return casillasEspeciales;
		
	}
	
	/**
	 * Retorna todas las serpientes y escaleras que hay en el tablero
	 * @return arreglo de serppientes y escaleras
	 */
	public ArrayList<Item> getSerpientesEscaleras(){
		
		return tablero.getItems();
		
	}
	
	/**
	 * Retorna el porcentaje de aparicion de las serpientes y escalera
	 * @return porcentaje de aparicion de escaleras y serpientes
	 */
	public int getEspecial() {

		return porcentajeEscalerasSerpientes;
		
	}

}