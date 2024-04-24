package Vista;

import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.AlaMuerta;
import Modelo.AlaVeloz;
import Modelo.Comida;
import Modelo.Dracónido;
import Modelo.GestorEventosTama;
import Modelo.Huevo;
import Modelo.Lagarto;
import Modelo.ListaAlimentos;
import Modelo.Sopa;
import Modelo.Candy;
import Modelo.Tablero;
import Modelo.Tamagotchi;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;


public class PantallaJuego extends JFrame implements Observer {

	Tamagotchi Tama = Tamagotchi.getTamagotchi();
	
	
	private static PantallaJuego miPantallaJuego = new PantallaJuego();
	
	private JPanel contentPane;
	private JPanel Arriba;
	private JPanel Izq;
	private JPanel Dcha;
	private JPanel Centro;
	private JLabel NombreTama;
	private JLabel Score;
	private JButton BotónSalir;
	private JLabel NumeroCoras;
	private JLabel NumeroSopas;
	private JButton BotónTama;
	private JPanel Abajo;
	private JButton BotónCandy;
	private JButton BotónSoup;
	private Controler controler = null;
	private JPanel CentroIzq;
	private JButton EnfermoBotón;
	private JButton SucioBotón;
	private JPanel panel_Candys;
	private JPanel panel_Sopas;
	private JLabel Label_Candy1;
	private JLabel Label_Candy2;
	private JLabel Label_Candy3;
	private JLabel Label_Sopa1;
	private JLabel Label_Sopa2;
	private JLabel Label_Sopa3;
	
	/////////////////////   NUNCA SE EJECUTA ///////////////////

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaJuego frame = new PantallaJuego();
					frame.setVisible(true);
					GestorEventosTama.getGestorEventosTama();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	///////////////////////////////////////////////////////////
	
	
	/**
	 * Create the frame.
	 */
	private PantallaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getArriba(), BorderLayout.NORTH);
		contentPane.add(getIzq(), BorderLayout.WEST);
		contentPane.add(getDcha(), BorderLayout.EAST);
		contentPane.add(getCentro(), BorderLayout.CENTER);
		contentPane.add(getAbajo(), BorderLayout.SOUTH);
		
		ListaAlimentos.getListaAlimentos().addObserver(this);
		Tamagotchi.getTamagotchi().addObserver(this);
		GestorEventosTama.getGestorEventosTama().addObserver(this);
			
	}
	
	
	
	public static PantallaJuego getPantallaJuego() {
		return miPantallaJuego;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		int[] array = (int[]) arg;
		
		if (o instanceof GestorEventosTama && array[0] == 1) {
			setVisible(false);
			Minijuego minijuego = new Minijuego();
			minijuego.setVisible(true);
		}
		
		if(o instanceof GestorEventosTama && array[0] == 3) {
			Score.setText("Score: " + array[1]);
		}

		
		if (o instanceof ListaAlimentos) {

			int candy = array[0];
			int sopa = array[1];

			if (candy==0 && sopa==0) {
				this.quitarIconsAlimentos();
			}else {
				this.añadirIconCandy(candy);
				this.añadirIconSopa(sopa);
			}
             
			}
	
		if(o instanceof Tamagotchi) {
			
			if(array[0]==4) {
				if(array[1] == 0) {
					BotónTama.setOpaque(false);
					BotónTama.setOpaque(false);
					ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Egg1.png");
					BotónTama.setIcon(icon);
					NombreTama.setText("Huevo");
					
				}
				else if(array[1] == 1) {
					
					BotónTama.setOpaque(false);
					ImageIcon icon1 = new ImageIcon("");
					BotónTama.setIcon(icon1);
					ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Gudetama1.png");
					BotónTama.setIcon(icon);
					NombreTama.setText("Lagarto");
					
				}
				else if(array[1] == 2) {
					
					BotónTama.setOpaque(false);
					ImageIcon icon1 = new ImageIcon("");
					BotónTama.setIcon(icon1);
					ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Kuchipatchi1.png");
					BotónTama.setIcon(icon);
					NombreTama.setText("Dracónido");
					
				}
				else if(array[1] == 3) {
					
					BotónTama.setOpaque(false);
					ImageIcon icon1 = new ImageIcon("");
					BotónTama.setIcon(icon1);
					ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Maskutchi1.png");
					BotónTama.setIcon(icon);
					NombreTama.setText("AlaMuerta");
					
				}
				else if(array[1] == 4) {
					
					BotónTama.setOpaque(false);
					ImageIcon icon1 = new ImageIcon("");
					BotónTama.setIcon(icon1);
					ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Marutchi1.png");
					BotónTama.setIcon(icon);
					NombreTama.setText("AlaVeloz");
					
				}
				
				
			}
			else {
			
			
			
			int vivo = array[0];
			int apetito = array[2];
			int corazones = array[1];
			int enfermo = array[3];
			int sucio = array[4];
			
			NumeroSopas.setText(apetito + "");
			NumeroCoras.setText(corazones + "");
			
			
			if(enfermo == 1) {
				ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/Virus.png");
				EnfermoBotón.setIcon(icon);
			}
			else {
				ImageIcon icon = new ImageIcon("");
				EnfermoBotón.setIcon(icon);
			}
			if(sucio == 1) {
				ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/kk.png");
				SucioBotón.setIcon(icon);
			}
			else {
				ImageIcon icon = new ImageIcon("");
				SucioBotón.setIcon(icon);
			}

			if(vivo == 0) {				
				setVisible(false);
				Muerte.getMuerte().setVisible(true);
			}
			
			}
			
		}
		
	}
	
	
	

	private JPanel getArriba() {
		if (Arriba == null) {
			Arriba = new JPanel();
			FlowLayout flowLayout = (FlowLayout) Arriba.getLayout();
			flowLayout.setHgap(82);
			Arriba.add(getNombreTama());
			Arriba.add(getScore());
			Arriba.add(getBotónSalir());
			Arriba.setBackground(Color.black);
		}
		return Arriba;
	}
	private JPanel getIzq() {
		if (Izq == null) {
			Izq = new JPanel();
			FlowLayout flowLayout = (FlowLayout) Izq.getLayout();
			flowLayout.setVgap(82);
			Izq.add(getNumeroCoras());
			Izq.setBackground(Color.black);
			Izq.setForeground(new Color(255, 255, 255));
		}
		return Izq;
	}
	private JPanel getDcha() {
		if (Dcha == null) {
			Dcha = new JPanel();
			FlowLayout flowLayout = (FlowLayout) Dcha.getLayout();
			flowLayout.setVgap(82);
			Dcha.add(getNumeroSopas());
			Dcha.setBackground(Color.black);
			Dcha.setForeground(new Color(255, 255, 255));
		}
		return Dcha;
	}
	private JPanel getCentro() {
		if (Centro == null) {
			Centro = new JPanel();
			Centro.setLayout(new GridLayout(1, 2, 0, 0));
			Centro.add(getBotónTama());
			Centro.add(getCentroIzq());
			Centro.setBackground(Color.black);
			
		}
		return Centro;
	}
	private JLabel getNombreTama() {
		if (NombreTama == null) {
			NombreTama = new JLabel("Huevo");
			NombreTama.setForeground(new Color(255, 255, 255));
		}
		return NombreTama;
	}
	private JLabel getScore() {
		if (Score == null) {
			Score = new JLabel("Score: 0");
			Score.setForeground(new Color(255, 255, 255));
		}
		return Score;
	}
	private JButton getBotónSalir() {
		if (BotónSalir == null) {
			BotónSalir = new JButton("Salir");
		}
		BotónSalir.addActionListener(getControler());
		return BotónSalir;
	}
	private JLabel getNumeroCoras() {
		if (NumeroCoras == null) {
			NumeroCoras = new JLabel("40");
			NumeroCoras.setForeground(new Color(255, 255, 255));
		}
		return NumeroCoras;
	}
	private JLabel getNumeroSopas() {
		if (NumeroSopas == null) {
			NumeroSopas = new JLabel("40");
			NumeroSopas.setForeground(new Color(255, 255, 255));
		}
		return NumeroSopas;
	}
	private JButton getBotónTama() {
		if (BotónTama == null) {
			BotónTama = new JButton("");		
		}
		BotónTama.addActionListener(getControler());
		BotónTama.setBorderPainted(false);
		BotónTama.setBorderPainted(false);
		BotónTama.setBackground(Color.black);
		BotónTama.setContentAreaFilled(false);
		BotónTama.setFocusPainted(false);
		
		
		
		
		
		return BotónTama;
	}
	private JPanel getAbajo() {
		if (Abajo == null) {
			Abajo = new JPanel();
			Abajo.setLayout(new GridLayout(2, 2, 0, 0));
			Abajo.add(getBotónCandy());
			Abajo.add(getBotónSoup());
			Abajo.setBackground(Color.black);
			Abajo.add(getPanel_Candys());
			Abajo.add(getPanel_Sopas());
		}
		return Abajo;
	}
	private JButton getBotónCandy() {
		if (BotónCandy == null) {
			BotónCandy = new JButton("Candy");
			BotónCandy.setBorderPainted(false);
			BotónCandy.setBorderPainted(false);
			BotónCandy.setBackground(Color.black);
			BotónCandy.setContentAreaFilled(false);
			BotónCandy.setFocusPainted(false);
			BotónCandy.setForeground(new Color(255, 255, 255));
		}
		
		BotónCandy.addActionListener(getControler());
		return BotónCandy;
	}
	private JButton getBotónSoup() {
		if (BotónSoup == null) {
			BotónSoup = new JButton("Sopa");
			BotónSoup.setBorderPainted(false);
			BotónSoup.setBorderPainted(false);
			BotónSoup.setBackground(Color.black);
			BotónSoup.setContentAreaFilled(false);
			BotónSoup.setFocusPainted(false);
			BotónSoup.setForeground(new Color(255, 255, 255));
			
		}
		BotónSoup.addActionListener(getControler());
		return BotónSoup;
	}
	
	
	private JPanel getCentroIzq() {
		if (CentroIzq == null) {
			CentroIzq = new JPanel();
			CentroIzq.setBackground(new Color(0, 0, 0));
			CentroIzq.setLayout(new GridLayout(2, 1, 0, 0));
			CentroIzq.add(getEnfermoBotón());
			CentroIzq.add(getSucioBotón());
		}
		return CentroIzq;
	}
	private JButton getEnfermoBotón() {
		if (EnfermoBotón == null) {
			EnfermoBotón = new JButton("");
			EnfermoBotón.setBorderPainted(false);
			EnfermoBotón.setBorderPainted(false);
			EnfermoBotón.setBackground(Color.black);
			EnfermoBotón.setContentAreaFilled(false);
			EnfermoBotón.setFocusPainted(false);
			EnfermoBotón.setForeground(Color.black);
		}
		EnfermoBotón.addActionListener(getControler());
		return EnfermoBotón;
	}
	private JButton getSucioBotón() {
		if (SucioBotón == null) {
			SucioBotón = new JButton("");
			SucioBotón.setBorderPainted(false);
			SucioBotón.setBorderPainted(false);
			SucioBotón.setBackground(Color.black);
			SucioBotón.setContentAreaFilled(false);
			SucioBotón.setFocusPainted(false);
			SucioBotón.setForeground(Color.black);
		}
		SucioBotón.addActionListener(getControler());
		return SucioBotón;
	}
	public String getNombreTamagotchi(){	
		return NombreTama.getText();
	}
	private void añadirIconCandy(int contIconCandy) {
		ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/candy.png");
		
		if (contIconCandy==1) {
			this.Label_Candy3.setIcon(icon);
			
		}else if(contIconCandy==2) {
			this.Label_Candy2.setIcon(icon);
			
		}else if(contIconCandy==3) {
			this.Label_Candy1.setIcon(icon);
			
		}
		
	}
    private void añadirIconSopa(int contIconSopa) {
    	ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/spoon.png");
    	
        if (contIconSopa==1) {
        	this.Label_Sopa3.setIcon(icon);
			
		}else if(contIconSopa==2) {
			this.Label_Sopa2.setIcon(icon);
			
		}else if(contIconSopa==3) {
			this.Label_Sopa1.setIcon(icon);
			
		}
		
	}
    private void quitarIconsAlimentos(){
    	ImageIcon icon = new ImageIcon("");
    	this.Label_Candy1.setIcon(icon);
    	this.Label_Candy2.setIcon(icon);
    	this.Label_Candy3.setIcon(icon);
    	this.Label_Sopa1.setIcon(icon);
    	this.Label_Sopa2.setIcon(icon);
    	this.Label_Sopa3.setIcon(icon);
    	
    }
	
	
	
////////////////   CONTROLADOR	 ////////////////////////////////////////////////////////////
	
	
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(BotónCandy)){				   
					Comida c=new Candy();
					ListaAlimentos.getListaAlimentos().añadirComida(c);
				
			}
			if (e.getSource().equals(BotónSoup)){
					Comida s=new Sopa();
					ListaAlimentos.getListaAlimentos().añadirComida(s);
				
				
			}
			if (e.getSource().equals(BotónTama)){
				
				ListaAlimentos.getListaAlimentos().darComida();
				BotónTama.setOpaque(false);
				
			}
			if (e.getSource().equals(BotónSalir)){
				
				System.exit(0);
			}
			if (e.getSource().equals(EnfermoBotón)){
				
				Tama.curar();
			}
			if (e.getSource().equals(SucioBotón)){
				
				Tama.limpiar();
			}
			
			
		}	
	}
	
	
	
	private JPanel getPanel_Candys() {
		if (panel_Candys == null) {
			panel_Candys = new JPanel();
			panel_Candys.setBackground(new Color(0, 0, 0));
			panel_Candys.setForeground(new Color(255, 255, 255));
			panel_Candys.setLayout(new GridLayout(0, 3, 0, 0));
			panel_Candys.add(getLabel_Candy1());
			panel_Candys.add(getLabel_Candy2());
			panel_Candys.add(getLabel_Candy3());
		}
		return panel_Candys;
	}
	private JPanel getPanel_Sopas() {
		if (panel_Sopas == null) {
			panel_Sopas = new JPanel();
			panel_Sopas.setForeground(new Color(255, 255, 255));
			panel_Sopas.setBackground(new Color(0, 0, 0));
			panel_Sopas.setLayout(new GridLayout(0, 3, 0, 0));
			panel_Sopas.add(getLabel_Sopa1());
			panel_Sopas.add(getLabel_Sopa2());
			panel_Sopas.add(getLabel_Sopa3());
		}
		return panel_Sopas;
	}
	private JLabel getLabel_Candy1() {
		if (Label_Candy1 == null) {
			Label_Candy1 = new JLabel("");
			Label_Candy1.setForeground(new Color(255, 255, 255));
			Label_Candy1.setBackground(new Color(0, 0, 0));
		}
		return Label_Candy1;
	}
	private JLabel getLabel_Candy2() {
		if (Label_Candy2 == null) {
			Label_Candy2 = new JLabel("");
			Label_Candy2.setForeground(new Color(255, 255, 255));
			Label_Candy2.setBackground(new Color(0, 0, 0));
		}
		return Label_Candy2;
	}
	private JLabel getLabel_Candy3() {
		if (Label_Candy3 == null) {
			Label_Candy3 = new JLabel("");
			Label_Candy3.setForeground(new Color(255, 255, 255));
			Label_Candy3.setBackground(new Color(0, 0, 0));
		}
		return Label_Candy3;
	}
	private JLabel getLabel_Sopa1() {
		if (Label_Sopa1 == null) {
			Label_Sopa1 = new JLabel("");
			Label_Sopa1.setForeground(new Color(255, 255, 255));
			Label_Sopa1.setBackground(new Color(0, 0, 0));
		}
		return Label_Sopa1;
	}
	private JLabel getLabel_Sopa2() {
		if (Label_Sopa2 == null) {
			Label_Sopa2 = new JLabel("");
			Label_Sopa2.setForeground(new Color(255, 255, 255));
			Label_Sopa2.setBackground(new Color(0, 0, 0));
		}
		return Label_Sopa2;
	}
	private JLabel getLabel_Sopa3() {
		if (Label_Sopa3 == null) {
			Label_Sopa3 = new JLabel("");
			Label_Sopa3.setForeground(new Color(255, 255, 255));
			Label_Sopa3.setBackground(new Color(0, 0, 0));
		}
		return Label_Sopa3;
	}
}
