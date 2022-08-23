package model;
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexao {
	

	public static Connection conector() {
		java.sql.Connection conexao = null;
		//chamada do driver
		String driver = "com.mysql.cj.jdbc.Driver";
		//informações referente ao banco de dados
		String url = "jdbc:mysql://localhost:3306/projeto_java";
		String user = "root";
		String password = "";
		//estabelecendo a conexao com o banco de dados
		//JOptionPane.showInternalMessageDialog(null,"Tentando Conectar com o banco de dados");
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user, password);
			//JOptionPane.showInternalMessageDialog(null, "Banco de dados Conectado ");
			
			
			
		}catch(Exception e) {
			//JOptionPane.showInternalMessageDialog(null, "Ops, Banco de dados Desconectado ERRO: " + e);
		   return null;
		   
		}
		return conexao;
     
	}
	
	
	
}
