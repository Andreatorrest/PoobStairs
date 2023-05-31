package Domain;

public class Serpiente implements Item{
	
	private Casilla cola;
	private Casilla cabeza;
	
	public Serpiente(Casilla cola, Casilla cabeza) {
		
		this.cola = cola;
		this.cabeza = cabeza;
		
	}
	
	public Casilla getCola() {
		
		return cola;
		
	}
	
	public Casilla getCabeza() {
		
		return cabeza;
		
	}
}
