package Modelo;

public class Sopa implements Comida {
	
	private static int potencia=10;
    public Sopa() {}
	@Override
	public boolean darComida() {
		// TODO Auto-generated method stub
		boolean sePasa = false;
		sePasa=Tamagotchi.getTamagotchi().comer(potencia);
		return sePasa;
	}

}
