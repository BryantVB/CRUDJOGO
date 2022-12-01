package CrudJOGOLIBRARY;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class  JogoDAOImpl implements JogoDAO {
	private static final String JDBC_URL = "jdbc:mariadb://localhost:3306/cadastro";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "alunofatec";
	private Connection con = null;
	
	JogoDAOImpl(){
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar (Jogo j) {
		
		String sql = "INSERT INTO Jogo (Id, nome, Genero, Classificacao)";
		sql += " VALUES ('" + j.getId() + "', ";
		sql += " '" + j.getNome() + "',";
		sql += " '" + j.getgenero() + "',";
		sql += " '" + j.getclassificacao() + "',";
	
	
	
		
		System.out.println("Query preparada: " + sql);
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo Com Sucesso");
		} catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Jogo> listar(String nome) {
	
			String sql = "SELECT * FROM Jogo";
			List<Jogo> jogos = new ArrayList<>();
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	Jogo j = new Jogo();
	            	j.setId(rs.getString("Id"));
	            	j.setNome(rs.getString("Nome"));
	          
	            	j.setGenero(rs.getString("Genero"));
	            	j.setClassificacao(rs.getString("Classificacao"));
	           
	            	
	                jogos.add(j);
	 	
	            }
					}catch (SQLException e) {
							e.printStackTrace();
	        }
		return jogos;
	}
	public void excluir(Jogo j) {
	
		String sql = "DELETE FROM Jogo where Id = ";
		sql += " '" + j.getId() + "' ";
		System.out.println("Query preparada: " + sql);
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deseja Mesmo Excluir ?");
		} catch (SQLException e) {
            e.printStackTrace();
        }
}
}