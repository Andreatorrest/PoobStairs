package Domain;

public class Serpiente implements Item{
	
	private Casilla cola;
	private Casilla cabeza;
	
	public Serpiente(Casilla cola, Object object) {
		
		this.cola = cola;
		this.cabeza = object;
		
	}

}
