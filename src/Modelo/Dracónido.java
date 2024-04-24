package Modelo;

public class Dracónido implements TamaState
{
	private static String nombre;
	
	public Dracónido() {
		
		nombre="Dracónido";
	}

	@Override
	public int getHambre() {
		
		return 7;
	}
	
	public int getAburrimiento() {
		
		return 7;
	}
	@Override
	public String getNombreTama() {
		
		return nombre;
	}
	
	

}
