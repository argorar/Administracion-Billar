package clases;

import gui.Principal;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class HiloManejaEquipos extends Thread {
	
	Principal p;
	ServerSocket server;
	Socket clienteconectado;
	int nconectados=-1;
	
	
	public HiloManejaEquipos(Principal prin){
//		try {
//			p=prin;
//			server=new ServerSocket(5555);
//			
//		}
//		catch (BindException be){
//			JOptionPane.showMessageDialog(null, "Ya existe una instancia ejecutandose.");
//			System.exit(0);
//		}
//		catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	}
