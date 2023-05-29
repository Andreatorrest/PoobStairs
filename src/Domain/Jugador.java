package Domain;

import java.util.ArrayList;
import java.awt.Color;

public abstract class Jugador {
	
	protected String nombre;
    protected String colorficha;
    protected ficha fichaJug;
    protected boolean isWinner;
    protected int turnojugador;

    public String getColorficha() {
        return colorficha;
    }

    public ficha getFichaJug() {
        return fichaJug;
    }

    public int turnojugador() {
        return turnojugador;
    }

    public void ganador(){
        isWinner = true;
    }

    public String getNombre() {
        return nombre;
    }
}





