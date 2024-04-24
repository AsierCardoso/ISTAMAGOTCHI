package Modelo;

public class AlaVeloz implements TamaState{
	
	private static String nombre;
	
	public AlaVeloz() {
		
		nombre="AlaVeloz";
		
	}

	@Override
	public int getHambre() {
		
		return 1;
	}
	
	public int getAburrimiento() {
		
		return 1;
	}
	@Override
	public String getNombreTama() {
		
		return nombre;
	}
	

}
