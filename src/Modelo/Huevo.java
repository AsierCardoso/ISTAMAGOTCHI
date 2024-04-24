package Modelo;

public class Huevo implements TamaState{
	
	private static String nombre;

	public Huevo() {
		
		nombre="Huevo";
		
	}
	
	@Override
	public int getHambre() {
		
		return 0;
	}
	
	public int getAburrimiento() {
		
		return 0;
	}
	@Override
	public String getNombreTama() {
		
		return nombre;
	}

}


