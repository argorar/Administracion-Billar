package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class FrameInfo extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	{
		// Set Look & Feel
		try {
			javax.swing.UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JPanel jPanel1;
	private JButton jButton1;
	private JLabel jLabel5;
	private JLabel jLabel3;
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JLabel jLabel6;

	public FrameInfo() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			this.setResizable(false);
			setIconImage(Toolkit.getDefaultToolkit().getImage(
					Principal.class.getResource("/lib/Billar.png")));
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			this.setTitle("Info");
			
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1);
				jPanel1.setBounds(0, 0, 388, 37);
				jPanel1.setBackground(new java.awt.Color(128, 128, 128));
				jPanel1.setLayout(null);
				{
					jLabel1 = new JLabel();
					jPanel1.add(jLabel1);
					jLabel1.setText("Info Aplicación");
					jLabel1.setBounds(6, 6, 156, 25);
					jLabel1.setForeground(new java.awt.Color(255, 255, 255));
					jLabel1.setFont(new java.awt.Font("Calisto MT", 0, 18));
				}
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("Versión 1.0  ");
				jLabel2.setBounds(12, 43, 93, 16);
			}
			{
				jButton1 = new JButton();
				getContentPane().add(jButton1);
				jButton1.setText("Aceptar");
				jButton1.setBounds(65, 234, 69, 28);
			}
			{
				jLabel3 = new JLabel();
				getContentPane().add(jLabel3);
				jLabel3.setText("Sebastián A.  2015");
				jLabel3.setBounds(12, 65, 135, 16);
			}
			{
				jLabel5 = new JLabel();
				getContentPane().add(jLabel5);
				String cpu = "<html>Sistema Operativo: "
						+ System.getProperty("os.name") + "<br>Arquitectura "
						+ System.getProperty("os.arch") + "<br>Versión "
						+ System.getProperty("os.version") + "<br>"+"User "
						+ System.getProperty("user.name") + "</html>";
				jLabel5.setText(cpu);
				jLabel5.setBounds(12, 120, 186, 114);
			}
			{
				jLabel6 = new JLabel();
				getContentPane().add(jLabel6);
				jLabel6.setText("Informacion de tu CPU:");
				jLabel6.setBounds(12, 98, 152, 16);
			}
			pack();
			this.setSize(140, 153);
			ActionListener aceptar = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			};
			jButton1.addActionListener(aceptar);
		} catch (Exception e) {
			// add your error handling code here
			e.printStackTrace();
		}
	}

}
