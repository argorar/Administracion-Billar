package gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import clases.HiloManejaEquipos;
/**
 * @author Sebastián
 */
public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel panelEquipos;
	BotonInfo equipo1, equipo2, equipo3, equipo4, equipo5;
	int nequiposconectados = 0;
	ArrayList<BotonInfo> equiposconectados;
	HiloManejaEquipos hme;
	private JButton btnNewButton;

	public Principal() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		/*
		 * Evento para el boton cerrar(x)
		 */
//		addWindowListener(new java.awt.event.WindowAdapter() {
//			@Override
//			public void windowClosing(java.awt.event.WindowEvent e) {
//				int seleccion = JOptionPane.showOptionDialog(null,
//						"¿Esta seguro que quiere salir?",
//						"Atención!", 1, 3, null, new Object[] { "Si", "No" }, "Si");
//
//				switch (seleccion) {
//				case 0:// Si elegimos "Si"
//					System.exit(0);// Y cerramos el programa
//					break;
//				case 1:// Si elegimos "No"
//					System.out.println("ffffffff");
//					break;
//				}
//			}
//		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				Principal.class.getResource("/lib/Billar.png")));
		setTitle("Administraccion Billar");
	
		ColocarSkin();

		JMenuBar barra = new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenuItem añadirUsuario = new JMenuItem("Info");
		añadirUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameInfo a = new FrameInfo();
				a.setSize(230,315);
				a.setVisible(true);
			}

		});
		JMenuItem salir = new JMenuItem("Salir");
		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

		});
		// JMenu
		archivo.add(añadirUsuario);
		archivo.add(salir);

		barra.add(archivo);

		setJMenuBar(barra);

		equiposconectados = new ArrayList<BotonInfo>();

		equipo1 = new BotonInfo("Mesa1");
		equipo2 = new BotonInfo("Mesa2");
		equipo3 = new BotonInfo("Mesa3");
		equipo4 = new BotonInfo("Mesa4");
		equipo5 = new BotonInfo("Mesa4");

		equiposconectados.add(equipo1);
		equiposconectados.add(equipo2);
		equiposconectados.add(equipo3);
		equiposconectados.add(equipo4);
		equiposconectados.add(equipo5);

		panelEquipos = new JPanel(new GridLayout(2, 3));

		panelEquipos.add(equipo1);
		panelEquipos.add(equipo2);
		panelEquipos.add(equipo3);
		panelEquipos.add(equipo4);
		panelEquipos.add(equipo5);

		hme = new HiloManejaEquipos(this);
		hme.start();
		getContentPane().add(panelEquipos);

		btnNewButton = new JButton(
				"<html> <p> <H1> Sebastián A. </H1> </p> </p>  <FONT COLOR=BLUE> © copyright 2015</FONT> </html>");
		panelEquipos.add(btnNewButton);
		
		
	}

	public static void main(String[] args) {
		Principal p = new Principal();
		p.setBounds(0, 0, 600, 400);
		p.setLocationRelativeTo(null);
		p.setVisible(true);
		p.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void ColocarSkin() {
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	
	public HiloManejaEquipos getHme() {
		return hme;
	}

	public void setHme(HiloManejaEquipos hme) {
		this.hme = hme;
	}

	public JPanel getPanelEquipos() {
		return panelEquipos;
	}

	public void setPanelEquipos(JPanel panelEquipos) {
		this.panelEquipos = panelEquipos;
	}

	public BotonInfo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(BotonInfo equipo1) {
		this.equipo1 = equipo1;
	}

	public BotonInfo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(BotonInfo equipo2) {
		this.equipo2 = equipo2;
	}

	public BotonInfo getEquipo3() {
		return equipo3;
	}

	public void setEquipo3(BotonInfo equipo3) {
		this.equipo3 = equipo3;
	}

	public BotonInfo getEquipo4() {
		return equipo4;
	}

	public void setEquipo4(BotonInfo equipo4) {
		this.equipo4 = equipo4;
	}

	public BotonInfo getEquipo5() {
		return equipo5;
	}

	public void setEquipo5(BotonInfo equipo5) {
		this.equipo5 = equipo5;
	}

	
	public int getNequiposconectados() {
		return nequiposconectados;
	}

	public void setNequiposconectados(int nequiposconectados) {
		this.nequiposconectados = nequiposconectados;
	}

	public ArrayList<BotonInfo> getEquiposconectados() {
		return equiposconectados;
	}

	public void setEquiposconectados(ArrayList<BotonInfo> equiposconectados) {
		this.equiposconectados = equiposconectados;
	}

}
