package Modelo;

public class AlaMuerta implements TamaState{
	
	private static String nombre;
	
	public AlaMuerta() {
		
		nombre="AlaMuerta";
	}

	@Override
	public int getHambre() {
		
		return 14;
	}
	
	public int getAburrimiento() {
		
		return 3;
	}
	@Override
	public String getNombreTama() {
		
		return nombre;
	}
	
	
	

}
