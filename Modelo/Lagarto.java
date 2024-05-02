package Modelo;

public class Lagarto implements TamaState{
	
	private static String nombre;

	public Lagarto() {
		
		nombre="Lagarto";
	}
	
	
	@Override
	public int getHambre() {
		
		return 5;
	}
	
	public int getAburrimiento() {
		
		return 2;
	}
	@Override
	public String getNombreTama() {
		
		return nombre;
	}

	
	
}
