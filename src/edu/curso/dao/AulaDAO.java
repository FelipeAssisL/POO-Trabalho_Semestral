package edu.curso.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.curso.models.Aula;

public class AulaDAO implements InterfAulaDAO{
	
	public static final String JDBC_URL= "jdbc:mariadb://localhost:3306/academia";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="123456";
	private Connection con;
	
	public AulaDAO() { 
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(
					JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void salvar(Aula aula) {
		String sql = "INSERT INTO evento (tituloEvento, dataEvento, horaEvento, descricaoEvento, nomeTutor) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aula.getNomeAula());
			stmt.setDate(2, Date.valueOf(aula.getDataAula()));
			stmt.setString(3, aula.getHoraAula());
			stmt.setString(4, aula.getDescricaoAula());
			stmt.setString(5, aula.getNomeInstrutor());

			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public List<Aula> lerTodos() {
		return pesquisarPorNome("");
	}

	@Override
	public List<Aula> pesquisarPorNome(String nome) {
		
		List<Aula> lista = new ArrayList<>();
		String sql = "SELECT * FROM evento WHERE tituloEvento LIKE ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Aula aula = new Aula();
				aula.setNomeAula(rs.getString("tituloEvento"));
				aula.setDataAula(rs.getDate("dataEvento").toLocalDate());
				aula.setHoraAula(rs.getString("horaEvento"));
				aula.setDescricaoAula(rs.getString("descricaoEvento"));
				aula.setNomeInstrutor(rs.getString("nomeTutor"));;

				
				lista.add(aula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
