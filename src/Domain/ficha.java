package Domain;

import java.awt.*;

public class ficha {
	
    private String color;
    private int casilla, fila, columna;
    private int EscalerasRecorridas=0;
    private int SerpientesRecorridas=0;
    
    public ficha(String color, int m){
        
    	casilla = 1;
        this.color = color;
        fila = m-1;
        columna = 0;
    }

    public void setCasilla(int newCasilla) {
        this.casilla =this.casilla+ newCasilla;
    }
    public void newCasilla(int newCasilla) {
        this.casilla = newCasilla;
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
    
    
    public int getSerpientesRecorridas(){
        return SerpientesRecorridas;
    }

    public int getEscalerasRecorridas() {
        return EscalerasRecorridas;
    }
    
    public void setSerpientesRecorridas(int contador) {
        this.SerpientesRecorridas = SerpientesRecorridas+contador;
    }

    public void setEscalerasRecorridas(int contador) {
        this.EscalerasRecorridas =EscalerasRecorridas +contador;
    }
    
}