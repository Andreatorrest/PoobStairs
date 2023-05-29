package Domain;

import java.awt.Color;

import javax.swing.text.StyledEditorKit.BoldAction;

public abstract class  Casilla {

	 private int color;
	 private String tipo;
	    private int casilla, fila, columna;


	    public void setCasilla(int newCasilla) {
	        this.casilla =newCasilla;
	    }


	    public int getCasilla() {
	        return casilla;
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

	    
	  
	}