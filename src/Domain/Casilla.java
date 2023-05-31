package Domain;

import java.awt.Color;

import javax.swing.text.StyledEditorKit.BoldAction;

public abstract class  Casilla {

	private int color;
	private String tipo;
    private int casilla, fila, columna;
    private Item item;
    
    /**
     * Asigna un valor a la casilla
     * @param newCasilla valor que se le va a dar a la casilla
     */
    public void setCasilla(int newCasilla) {
        this.casilla =newCasilla;
    }

    /**
     * Retorna el valor de la casilla
     * @return valor de la casilla
     */
    public int getCasilla() {
        return casilla;
    }
    
    /**
     * Añade una nueva serpiente a la casilla
     * @param cola casilla donde termina la serpiente
     */
    public void addSerpiente(Casilla cola) {
    	
    	item = new Serpiente(this, cola);
    	
    }
    
    /**
     * Añade una nueva escalera a la casilla
     * @param cola casilla donde termina la escalera
     */
    public void addEscalera(Casilla cabeza) {
    	
    	item = new Escalera(this, cabeza);
    	
    }
    
    public int getfila() {
        return fila;
    }

    public int getcolumna() {
        return columna;
    }

    public void setfila(int fila) {
        this.fila = fila;
    }

    public void setcolumna(int columna) {
        this.columna = columna;
    }

    public abstract Boolean activar();
    public abstract Color  getcolor();
    public abstract int  casillaespecial();

	public Item getItem() {
		
		return item;
		
	}

	    
	  
	}