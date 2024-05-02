package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.GestorEventosTama;
import Modelo.ListaAlimentos;
import Modelo.Tamagotchi;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Muerte extends JFrame {

	private static Muerte miMuerte = new Muerte();
	
	/**
	 * 
	 */
	private JPanel contentPane;
	private JPanel Centro;
	private JLabel Mensaje;
	private JButton Bot�nVolver;
	
	private Controler controler = null;

	/////////////////////// NUNCA SE EJECUTA //////////////
	
	/**
	 * Launch the application.
	 */
	
	
	////////////////////////////////////////////////////////

	/**
	 * Create the frame.
	 */
	private Muerte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getCentro(), BorderLayout.CENTER);
	}
	
	public static Muerte getMuerte() {
		
		return miMuerte;
	}

	private JPanel getCentro() {
		if (Centro == null) {
			Centro = new JPanel();
			Centro.setBackground(new Color(0, 0, 0));
			Centro.setLayout(new GridLayout(2, 1, 0, 0));
			Centro.add(getMensaje());
			Centro.add(getBot�nVolver());
		}
		return Centro;
	}
	private JLabel getMensaje() {
		if (Mensaje == null) {
			Mensaje = new JLabel("Game Over");
			Mensaje.setForeground(new Color(255, 255, 255));
			Mensaje.setHorizontalAlignment(SwingConstants.CENTER);
			ImageIcon icon = new ImageIcon("C:/Users/34608/Desktop/wsjava/IS_Tamagochi/src/imagenes/death.gif");
			Mensaje.setIcon(icon);
			Mensaje.setIconTextGap(10);
		}
		return Mensaje;
	}
	private JButton getBot�nVolver() {
		if (Bot�nVolver == null) {
			Bot�nVolver = new JButton("Volver a la Pantalla de Inicio");
			Bot�nVolver.setBackground(Color.black);
			Bot�nVolver.setContentAreaFilled(false);
			Bot�nVolver.setFocusPainted(false);
			Bot�nVolver.setForeground(Color.red);
		}
		Bot�nVolver.addActionListener(getControler());
		return Bot�nVolver;
	}
	
	
	
	
	
	
////////////////CONTROLADOR	 ////////////////////////////////////////////////////////////
	
	
private Controler getControler() {
if (controler == null) {
controler = new Controler();
}
return controler;
}

private class Controler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource().equals(Bot�nVolver)){
			
			int puntos = GestorEventosTama.getGestorEventosTama().getPuntos();
			PantallaInicio.getPantallaInicio().modificarTabla(puntos);
			
			ListaAlimentos.getListaAlimentos().resetear();
			setVisible(false);
			PantallaInicio.getPantallaInicio().setVisible(true);
			
			
			
			
		}
		
	
	}
	
}


	
	
	
	
}