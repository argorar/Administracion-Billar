package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	Connection con;
	String driver,connectString,user,password;
	
	public Conexion(){
		
		driver = "org.postgresql.Driver";
        connectString = "jdbc:postgresql://localhost:5432/Ciber";
        user = "postgres";
        password = "241991";
    }

    public void conectar() throws SQLException, ClassNotFoundException{
        if (isConectado()==false){
            Class.forName(driver);
            con = DriverManager.getConnection (connectString, user , password);
        } else {
            System.out.println(isConectado());
        }
    }

    private boolean isConectado() {
        if (con == null) {
            return false;
        } else { 
            return true;
        }
    }
    
    public ResultSet consultar(String consulta){
    	ResultSet rs=null; 
    	try {
    	     rs=con.createStatement().executeQuery( consulta );
    	 } catch (SQLException SEx) {
    	   	SEx.printStackTrace();
    	 }
    	 return rs;
    }
    
    public void ejecutar(String consulta){
    	try {
    	     con.createStatement().execute( consulta );
    	 } catch (SQLException SEx) {
    	   	SEx.printStackTrace();
    	 }
    }
	
}
