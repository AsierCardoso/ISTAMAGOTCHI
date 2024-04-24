package Modelo;

public class Candy implements Comida {
	
	private static int potencia=10;
     
	
	public Candy() {}
	@Override
	public boolean darComida() {
		// TODO Auto-generated method stub
		boolean sePasa = false;
		sePasa = Tamagotchi.getTamagotchi().cuidar(potencia);
		return sePasa;
	}
	

}
