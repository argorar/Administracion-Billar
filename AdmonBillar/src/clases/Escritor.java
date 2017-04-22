package clases;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Escritor {

	public void escribir(String name,String cadena){
	    String sFichero = "C:\\Billar\\MesasActivas\\"+name+".txt";
	    File fichero = new File(sFichero);
		BufferedWriter out=null;   
		try {   
			if(fichero.exists()==false){
				out = new BufferedWriter(new FileWriter("C:\\Billar\\MesasActivas\\"+name+".txt", false));   
			    out.write(cadena);
			}
		else{
		    out = new BufferedWriter(new FileWriter("C:\\Billar\\MesasActivas\\"+name+".txt", true));   
		    out.write("\r\n"+cadena);
		}
		} catch (IOException e) {   
			JOptionPane.showMessageDialog(null,"Se encontro un error en "+name+", fue movido a la carpeta error. ","Error",JOptionPane.ERROR_MESSAGE);
	    	File directorioProcesados = new File("C:\\Billar\\Error\\");
			fichero.renameTo(new File(directorioProcesados
					+ File.separator +name+".txt"));  
		} finally {   
		    if (out != null) {   
		        try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   
		    }   
		} 
	}
	public void moverArchivo(String name){
		String sFichero = "C:\\Billar\\MesasActivas\\"+name+".txt";
	    File fichero = new File(sFichero);
		File directorioProcesados = new File("C:\\Billar\\HistorialMesas\\");
		fichero.renameTo(new File(directorioProcesados
				+ File.separator +name+".txt")); 
	}
	public void abrirArchivo(String name){
	    try {
	        
	        File file = new File("C:\\Billar\\HistorialMesas\\"+name+".txt");
	        Desktop.getDesktop().open(file);
	        } catch(Exception e) {
	         
	        e.printStackTrace();
	        }
	         
	}
}
