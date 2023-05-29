package Domain;

import java.util.Random;

public class Dado {
	
	private int valor;
	
	public Dado() {
		
		valor = 0;
		
	}
	
	/**
	 * Da un valor aleatorio entre 1 y 6
	 * @return puntaje obtenido al randomizar
	 */
	public int tirar() {
		
		Random random = new Random();
		valor = random.nextInt(6) + 1;
		
		return valor;
		
	}

	public int getValor() {
		
		return valor;
		
	}
	
}
