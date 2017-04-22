package gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Escritor;
import clases.ValidacionUtils;
import exception.ExcepcionPersonalizada;

public class AgregarProducto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textDes;
	private JTextField textCant;
	private JTextField textPrec;
	public String desc, cant, pre;
	public ValidacionUtils utils = new ValidacionUtils();
	public BotonInfo botonInfo = new BotonInfo(null); 

	/**
	 * Create the frame.
	 * @param botonInfo 
	 */
	public AgregarProducto(BotonInfo botonInfo) {
		this.botonInfo=botonInfo;
		setTitle("Agregar Producto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				AgregarProducto.class.getResource("/lib/Billar.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 414, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDescripcinProducto = new JLabel("Descripci\u00F3n Producto :");
		lblDescripcinProducto.setBounds(36, 35, 147, 23);
		contentPane.add(lblDescripcinProducto);

		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setBounds(36, 67, 88, 16);
		contentPane.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio :");
		lblPrecio.setBounds(36, 95, 68, 16);
		contentPane.add(lblPrecio);

		textDes = new JTextField();
		textDes.setBounds(171, 32, 178, 28);
		contentPane.add(textDes);
		textDes.setColumns(10);

		textCant = new JTextField();
		textCant.setText("1");
		textCant.setBounds(171, 61, 40, 28);
		contentPane.add(textCant);
		textCant.setColumns(10);

		textPrec = new JTextField();
		textPrec.setBounds(171, 89, 178, 28);
		contentPane.add(textPrec);
		textPrec.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AgregarProducto.class
				.getResource("/lib/bar.png")));
		lblNewLabel.setBounds(36, 134, 147, 96);
		contentPane.add(lblNewLabel);

		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					desc = textDes.getText();
					utils.validarDescripcion(desc);
					cant = textCant.getText();
					utils.validarCantidad(cant);
					pre = textPrec.getText();
					utils.validarPrecio(pre);
					String cadena =desc+"............."+pre+".........."+cant;
					Integer preci=Integer.parseInt(botonInfo.lprecio.getText())+(Integer.parseInt(pre)*Integer.parseInt(cant));
		            String prec=""+preci;
		            botonInfo.lprecio.setText(prec);
		            Escritor esc =new Escritor();
		            esc.escribir(botonInfo.getName(), cadena);
					JOptionPane.showMessageDialog(null,
							"Producto agregado con éxito.");
					dispose();

				} catch (ExcepcionPersonalizada e) {
					// Mostramos si hay un error
					JOptionPane.showMessageDialog(null, e.getErrorVo()
							.getMsjError(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregar.setBounds(171, 177, 90, 28);
		contentPane.add(btnAgregar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(276, 177, 90, 28);
		contentPane.add(btnCancelar);
	}
}
