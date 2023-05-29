package Domain;

import java.awt.Color;

public class Maquina extends Jugador{
	
    private String tipo;

    public Maquina(String name, String  color,  String tipo, int m) {
    	
    	super.turnojugador = turnojugador;
    	super.nombre = name;
    	super.colorficha = color;
    	super.fichaJug = new ficha(colorficha, m);
        this.tipo = tipo;
    }

}
