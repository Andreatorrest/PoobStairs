package Domain;

public class PoobStairsException extends Exception{
	
	public static final String DATOS_FALTANTES = "Aun faltan datos por rellenar";
	public static final String COLOR_REPETIDO = "Ese color ya lo seleccionó el otro jugador";
	
	public PoobStairsException(String message) {
		
		super(message);
		
	}
	
}
