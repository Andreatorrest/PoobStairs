package Domain;

import java.awt.Color;



public class Humano extends Jugador{
	
    public Humano(String name, String color, int m) {
    	
    	super.turnojugador = turnojugador;
    	super.nombre = name;
    	super.colorficha = color;
    	super.fichaJug = new ficha(colorficha, m);
    }
}
