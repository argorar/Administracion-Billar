package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import clases.Escritor;

public class BotonInfo extends JButton implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Thread hilo;
	JPanel p;
	Integer precio;
	String tiempo, name;
	JLabel lprecio, ltiempo;
	public boolean cronometroActivo;

	public BotonInfo(String name) {
		this.name = name;
		p = new JPanel(new BorderLayout());

		ImageIcon img = new ImageIcon(this.getClass().getResource(
				"/lib/Billar.png"));
		JLabel l = new JLabel(img);
		p.add(l, BorderLayout.CENTER);
		JPanel pinfo = new JPanel(new GridLayout(3, 2));
		if (precio == null) {
			precio = 0;
		}
		if (tiempo == null) {
			tiempo = "Inactivo";
		}
		JLabel ltitulonombre = new JLabel("Precio  $");
		String pr = precio.toString();
		lprecio = new JLabel("" + pr);
		JLabel ltitulotiempo = new JLabel("Tiempo");
		ltiempo = new JLabel("" + tiempo);
		pinfo.add(ltitulonombre);
		pinfo.add(lprecio);
		pinfo.add(ltitulotiempo);
		pinfo.add(ltiempo);
		p.add(pinfo, BorderLayout.SOUTH);

		add(p);

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				String[] tiem = ltiempo.getText().split(":");
				if (ltiempo.getText().equals("Inactivo")) {
					iniciarCronometro();
					nombreArchivo();
					crearArchivo();
				} else {
					estadoCronometro();
				}

			}

			

		});

	}
	
	private void crearArchivo() {
		Escritor esc = new Escritor();
		esc.escribir(name,"Archivo "+name);
		
	}

	private void nombreArchivo() {
		 //Instanciamos el objeto Calendar
        //en fecha obtenemos la fecha y hora del sistema
        Calendar fecha = new GregorianCalendar();
        //Obtenemos el valor del año, mes, día,
        //hora, minuto y segundo del sistema
        //usando el método get y el parámetro correspondiente
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        name+="_["+dia + "-" + (mes+1) + "-" + año+"]_["+hora+"-"+ minuto+"-"+ segundo+"]";
	}

	@SuppressWarnings("deprecation")
	protected void estadoCronometro() {
		int seleccion = JOptionPane.showOptionDialog(null,
				"¿Qué desea hacer con la mesa?", "Atención!", 1, 3, null,
				new Object[] { "Parar", "Agregar", "Cancelar" }, "txt");

		switch (seleccion) {
		case 0:// Si elegimos "pausar"
			hilo.stop();
			Escritor esc =new  Escritor();
			esc.escribir(name, "\r\n Tiempo total:............."+ltiempo.getText() +"\r\n Total a pagar:............."+lprecio.getText());
			esc.moverArchivo(name);
			esc.abrirArchivo(name);
			ltiempo.setText("Inactivo");
			lprecio.setText("0");
			break;
		case 1:// Si elegimos "Agregar"
			AgregarProducto frame = new AgregarProducto(this);
			frame.setVisible(true);
			;

			break;
		case 2:
			break;
		}
	}

	protected void iniciarCronometro() {
		hilo = new Thread(this);
		hilo.start();

	}

	public JPanel getP() {
		return p;
	}

	public void setP(JPanel p) {
		this.p = p;
	}

	public int getPreio() {
		return precio;
	}

	public void setPrecio(String nombre) {
		this.lprecio.setText(nombre);
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.ltiempo.setText(tiempo);
	}

	public String getName() {
		return name;
	}

	public void run() {
		// min es minutos, seg es segundos y mil es milesimas de segundo
		Integer hora = 0, minutos = 0, segundos = 0;
		String min = "", seg = "", hor = "";
		cronometroActivo = true;
		try {

			// Mientras cronometroActivo sea verdadero entonces seguira
			// aumentando el tiempo
			while (cronometroActivo) {
				Thread.sleep(995);
				// Incrementamos 1 segundo
				segundos += 1;

				// Cuando llega a 60 osea 1 segundo aumenta 1 segundo
				// y segundo de nuevo a 0
				if (segundos == 60) {
					segundos = 0;
					minutos += 1;
					Integer pre = Integer.parseInt(lprecio.getText()) + 100;
					String prec = "" + pre;
					lprecio.setText(prec);
					// Si los minutos llegan a 60 entonces aumenta 1 la hora
					// y los minutos vuelven a 0
					if (minutos == 60) {
						minutos = 0;
						hora++;
					}
				}

				// Esto solamente es estetica para que siempre este en formato
				// 00:00:000
				if (minutos < 10)
					min = "0" + minutos;
				else
					min = minutos.toString();
				if (segundos < 10)
					seg = "0" + segundos;
				else
					seg = segundos.toString();

				if (hora < 10)
					hor = "0" + hora;
				else
					hor = hora.toString();

				// Colocamos en la etiqueta la informacion
				ltiempo.setText(hor + ":" + min + ":" + seg);
				p.repaint();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Un error ocurrio en el manejo del tiempo.");
		}

	}

}
