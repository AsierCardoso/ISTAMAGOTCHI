package Modelo;

import java.util.Observable;

public class Tamagotchi extends Observable {
	
	private static Tamagotchi miTama = new Tamagotchi();
	
	private TamaState state;
	
	private int vivo;
	private int corazones;
	private int apetito;
	private String nombre;
	
	private int enfermo;
	private int sucio;
	

	
	public Tamagotchi() {
		
		reset();
		
	}
	
	public void reset() {
		
		
		corazones = 40;
		apetito = 40;
		vivo = 1;
		enfermo = 0;
		sucio = 0;
		
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		changeState(new Huevo());
	}
	
	public static Tamagotchi getTamagotchi() {
		
		return miTama;
		
	}
	
	public void changeState(TamaState pState) {
		
		int num= 0;
		state = pState;
		
		if(state instanceof Huevo) {
			
			num = 0;
		}
		else if(state instanceof Lagarto) {
			
			num = 1;
		}
		else if(state instanceof Dracónido) {
			
			num = 2;
		}
		else if(state instanceof AlaMuerta) {
			
			num = 3;
		}
		else if(state instanceof AlaVeloz) {
			
			num = 4;
		}
		
		setChanged();
		notifyObservers(new int[] {4, num});
		
	}
	

	
	
	
	public void aburrirYDarHambre() {
			
			
			if(enfermo == 1) {
				
				corazones = corazones - 7;
				apetito = apetito + 5;
				
			}
			
			if(sucio == 1) {
				
				corazones = corazones - 5;
				apetito = apetito + 10;
				
			}
			
			corazones = corazones - state.getAburrimiento();
			apetito = apetito - state.getHambre();
			
			
			if (apetito > 40) {
				
				apetito = 40;
			}
			
			if(apetito <= 0 || corazones <= 0) {
				
				vivo = 0;
				
			}
		
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		
	}
	
	public void ponerEnfermo() {
		
		enfermo = 1;
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
	}
	
	public void ponerSucio() {
		
		sucio = 1;
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
	}
	
	public void curar() {
		
		enfermo = 0;
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
	}
	
	public void limpiar() {
		
		sucio = 0;
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
	}
	
	
	
	public String getNombre() {
		
		return nombre;
	}
	
	public boolean estaVivo() {
		
		return vivo == 1;
	}

	public boolean estaSucioOEnfermo() {
		
		return (enfermo == 1 || sucio == 1);
	}
	
	public TamaState getState() {
		
		return state;
	}
	
	public boolean cuidar (int pPotencia) {

		
		boolean sePasa = false;

		corazones = corazones + pPotencia;

		

		if (corazones > 40) {

		sePasa = true;
		corazones = 40;
		}
		 
		
		  setChanged();
		  notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		  return sePasa;
	}
	
	
	  public boolean comer (int pPotencia) {

		  
		  boolean sePasa = false;

		  apetito = apetito + pPotencia;

		  


		  if (apetito > 40) {

		  sePasa = true;
		  apetito = 40;
		  }
	
		  

		  setChanged();
		  notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		  
		  return sePasa;
		  
	  }
	
}
