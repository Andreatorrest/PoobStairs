package Domain;

public class Escalera implements Item{
	
	private Casilla cola;
	private Casilla cabeza;
	
	public Escalera(Casilla cola, Casilla cabeza) {
		
		this.cola = cola;
		this.cabeza = cabeza;
		
	}
	
}
