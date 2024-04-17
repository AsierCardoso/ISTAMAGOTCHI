package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class ListaAlimentos extends Observable {
	
	
	private static ListaAlimentos milistaComida= new ListaAlimentos();
	private ArrayList<Comida> listaC=new ArrayList<Comida>();
	private int numeroCandy;
	private int numeroSopa;
	
	private ListaAlimentos() {}
	
	public static ListaAlimentos getListaAlimentos() {return milistaComida;}
	
	public void añadirComida(Comida pComida) {
		if (pComida instanceof Candy) {
			if (numeroCandy<3) {
			listaC.add(pComida);
			numeroCandy++;
			}
		}
		else if (pComida instanceof Sopa) {
			if (numeroSopa<3) {
			listaC.add(pComida);
			numeroSopa++;
			}
		}
		setChanged();
		notifyObservers(new int[] {numeroCandy, numeroSopa});
	}
	public void darComida() {
		
		boolean sePaso = false;
		boolean sePasa = false;
		int puntos = (this.numeroSopa+numeroCandy)*(this.numeroSopa+numeroCandy)*3;
		 
		
		int i=listaC.size()-1;
		while(listaC.size()>0 ) {
    	  
    	  Comida pComida=listaC.get(i);
    	  sePasa = pComida.darComida();
    	  
    	  if(sePasa) {
    		  
    		  sePaso = true;
    		  
    	  }
    	  
    	  listaC.remove(pComida);
    	  i--;
    	  
      }
		
		numeroSopa = 0;
		numeroCandy = 0;
		if(sePaso) {
			
			GestorEventosTama.getGestorEventosTama().aumentarPuntuacion(-5); 
		}
		else {
			
			GestorEventosTama.getGestorEventosTama().aumentarPuntuacion(puntos); 
		}
		
	
     
      setChanged();
	  notifyObservers(new int[] {numeroCandy, numeroSopa});
	}
	
	

}
