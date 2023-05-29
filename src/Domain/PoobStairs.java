package Domain;

import java.awt.Color;
import java.util.ArrayList;

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

	public PoobStairs() {
		
    	jugadores = new ArrayList<>();
    	dado = new Dado();

	}
 
    public void addplayer(String name, String color) {
    	
 	   Jugador jugador1 = new Humano(name, color, tamañoTablero);
 	   jugadores.add(jugador1);
	
 	 
    }
    
    public int getSize() {
    	
        return tamañoTablero;
        
    }
    
    public void addTablero(int tamañoTablero, int casillasEspeciales) {
    	
    	tablero = new Tablero (tamañoTablero,casillasEspeciales);
    	
    }
    
    public void addMaquina(String name, String color, String tipoMaquina) {
 		
 	   Jugador jugador1 = new Maquina(name, color,tipoMaquina, tamañoTablero);
 	   jugadores.add(jugador1);
 	 
   }
   
    public void jugar() {	   
 	   dado.tirar();
 	   int valor=getValorDado();
 	   
  	   if (turno==1) {
 			int posiblecasilla =jugadores.get(0).getFichaJug().getCasilla()+valor;
 			
 			if(posiblecasilla==(tamañoTablero*tamañoTablero)) {
 				JOptionPane.showMessageDialog(null, "!Felicidades Ganaste"+ jugadores.get(0).getNombre()+"!");
 			}
 			
 			if (posiblecasilla  <=tamañoTablero*tamañoTablero) {
  			jugadores.get(0).getFichaJug().setCasilla(valor); 
 			int casillaActual = jugadores.get(0).getFichaJug().getCasilla();
 			turno ++; 
 			}else {
 				JOptionPane.showMessageDialog(null, "!No te alcanza para ganar!");

 				turno ++; 
 			}
   	   }else {
   		    int posiblecasilla =jugadores.get(1).getFichaJug().getCasilla()+valor;
   		    
   			if(posiblecasilla==(tamañoTablero*tamañoTablero)) {
 				JOptionPane.showMessageDialog(null, "!Felicidades Ganaste"+ jugadores.get(1).getNombre()+"!");
 			}
   		    
   		    
 			if (posiblecasilla  <=tamañoTablero*tamañoTablero) {
   		   	jugadores.get(1).getFichaJug().setCasilla(valor); 
 			int casillaActual = jugadores.get(1).getFichaJug().getCasilla();	
 			turno= turno-1;
 			}else {
 				JOptionPane.showMessageDialog(null, "!No te alcanza para ganar!");
 				turno= turno-1;
 			}
   	   } 
    }
    
    
 	 public  int[] obtenercasillaXY(int turno) {
 		 
 	     int valor=jugadores.get(turno-1).getFichaJug().getCasilla();
 		 int[] posicion = new int[2];
 		 posicion = tablero.obtenervalorcfilacolumna(valor);
 		 return posicion;
 	}

	public int getValorDado() {
		
		return dado.getValor();
		
	}
	
	
	 public  int obtenerposcasillas(int fila,int columna) {
	       
		 int posicion = tablero.obtenervalorcasilla(fila,columna);
	     return posicion;
	     
	 }
	
	 public  int[] obtenercasilla(int valor) {
		       
		 int[] posicion = new int[2];
		 posicion = tablero.obtenervalorcfilacolumna(valor);
		 return posicion;
	}
	 
	public  Color obtenercolor(int fila,int columna) {
	
	   Color color = tablero.Color(fila, columna);
	   return color;
	   
	}

	public void setJugadores(int numJugadores) {
		
		Njugadores = numJugadores;
		
	}

	public void setSize(int tamano) {
		
		tamañoTablero = tamano;
		
	}

	public void setCasillaEspeciales(int casillasEspeciales) {
		
		this.casillasEspeciales = casillasEspeciales;
		
	}

	public void setModificadores(int modificadores) {
		
		this.modificadores = modificadores;
		
	}

	public void setTransformaciones(boolean trasformaciones) {
		
		this.trasformaciones = trasformaciones;
		
	}

	public void setPorcentajeEspeciales(int porcentajeSerpientesScaleras) {
		
		this.porcentajeEscalerasSerpientes = porcentajeSerpientesScaleras;
		
	}

	public int getCasillasEspeciales() {
	
		return casillasEspeciales;
		
	}
	
	
	
	
}