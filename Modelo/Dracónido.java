package Modelo;

public class Drac�nido implements TamaState
{
	private static String nombre;
	
	public Drac�nido() {
		
		nombre="Drac�nido";
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
