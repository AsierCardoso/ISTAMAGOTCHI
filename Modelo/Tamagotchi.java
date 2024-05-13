package Modelo;

import java.util.Observable;

public class Tamagotchi extends Observable {
	
	private static Tamagotchi miTama;
	
	private TamaState state;
	private SaludState saludState;
	
	private int vivo;
	private int corazones;
	private int apetito;
	private String nombre;
	

	
	public Tamagotchi() {
		
		reset();
		
	}
	
	public void reset() {
		
		
		corazones = 40;
		apetito = 40;
		vivo = 1;
		
		saludState=new Sano();
		
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, 0, 0});
		changeState(new Huevo());
	}
	
	public static Tamagotchi getTamagotchi() {
		if (miTama==null) {
			miTama=new Tamagotchi();
		}
		return miTama;
		
	}
	
	public void changeState(TamaState pState) {
		
		int num= 0;
		state = pState;
		GestorEventosTama.getGestorEventosTama().actualizarOro(15);
		if(state instanceof Huevo) {
			nombre=state.getNombreTama();
			num = 0;
			
		}
		else if(state instanceof Lagarto) {
			nombre=state.getNombreTama();
			num = 1;
		
		}
		else if(state instanceof Dracónido) {
			nombre=state.getNombreTama();
			num = 2;
			
		}
		else if(state instanceof AlaMuerta) {
			nombre=state.getNombreTama();
			num = 3;
			
		}
		else if(state instanceof AlaVeloz) {
			nombre=state.getNombreTama();
			num = 4;
					}
		else if(state instanceof DragonAvaricioso) {
			nombre=state.getNombreTama();
			num = 5;
					}
		else if(state instanceof DragonNormal) {
			nombre=state.getNombreTama();
			num = 6;
					}
		
		setChanged();
		notifyObservers(new int[] {4, num});
		
	}
	
   public void setHambreYAburrimiento(int pAburrido,int pHambre) {
	    corazones = corazones - pAburrido;
		apetito = apetito + pHambre;
	   
   }
	
	
	
	public void aburrirYDarHambre() {
		 int enfermo=0;
		 int sucio=0;
		 int i=this.saludState.afectar();	
	     if(i==1) {
	    	 enfermo=1;
			 sucio=0;
	     }else if (i==2){
	    	 enfermo=0;
			 sucio=1;
	     }
		 if (!this.estaSucioOEnfermo()) {
			apetito = apetito - state.getHambre();
		 }	
		 corazones = corazones - state.getAburrimiento();
			
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
		saludState=new Enfermo();
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito,1, 0});
	}
	
	public void ponerSucio() {
		saludState=new Sucio();
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, 0, 1});
	}
	
	public void curar() {
		saludState= new Sano();
		GestorEventosTama.getGestorEventosTama().setChiv(false);
		GestorEventosTama.getGestorEventosTama().actualizarOro(10);
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, 0, 0});
	}
	
	public void limpiar() {
		saludState= new Sano();
		GestorEventosTama.getGestorEventosTama().setChiv(false);
		GestorEventosTama.getGestorEventosTama().actualizarOro(10);
		setChanged();
		notifyObservers(new int[] {vivo, corazones, apetito, 0, 0});
	}
	
	
	
	
	
	public boolean estaVivo() {
		
		return vivo == 1;
	}

	public boolean estaSucioOEnfermo() {
		boolean chiv=true;
		if(saludState instanceof Sano) {
			chiv=false;
		}
		return (chiv);
	}
	
	public TamaState getState() {
		
		return state;
	}
	
	public boolean cuidar (int pPotencia) {
		 int enfermo=0;
		 int sucio=0;
		if(saludState instanceof Enfermo) {
			enfermo=1;
			
			
		}
		
		if(saludState instanceof Sucio) {
			sucio=1;
			
		}

		
		boolean sePasa = false;

		corazones = corazones + pPotencia;

		

		if (corazones > 40) {

		sePasa = true;
		corazones = 40;
		}
		 
		GestorEventosTama.getGestorEventosTama().actualizarOro(1);
		  setChanged();
		  notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		  return sePasa;
	}
	
	
	  public boolean comer (int pPotencia) {
		     int enfermo=0;
			 int sucio=0;
			if(saludState instanceof Enfermo) {
				enfermo=1;
				
				
			}
			
			if(saludState instanceof Sucio) {
				sucio=1;
				
			}


		  
		  boolean sePasa = false;

		  apetito = apetito + pPotencia;

		  


		  if (apetito > 40) {

		  sePasa = true;
		  apetito = 40;
		  }
	
		  
		  GestorEventosTama.getGestorEventosTama().actualizarOro(1);
		  setChanged();
		  notifyObservers(new int[] {vivo, corazones, apetito, enfermo, sucio});
		  
		  return sePasa;
		  
	  }
	
}
