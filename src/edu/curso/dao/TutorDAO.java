package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.curso.models.Tutor;

public class TutorDAO implements InterfTutorDAO{
	
	public static final String JDBC_URL= "jdbc:mariadb://localhost:3306/academia";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="123456";
	private Connection con;
	
	
	public TutorDAO() {
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void salvar(Tutor tutor) {
		
		String sql = "INSERT INTO tutor (nomeTutor, especialidadeTutor, descricaoTutor) VALUES (?, ?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, tutor.getNomeTutor());
			stmt.setString(2, tutor.getEspecialidadeTutor());
			stmt.setString(3, tutor.getDescricaoTutor());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Tutor> lerTodos() {
		return pesquisarPorNome("");
	}

	@Override
	public List<Tutor> pesquisarPorNome(String nome) {
		
		List<Tutor> lista = new ArrayList<>();
		String sql = "SELECT * FROM tutor WHERE nomeTutor LIKE ?";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) { 
				Tutor tutor = new Tutor();
				tutor.setNomeTutor(rs.getString("nomeTutor"));
				tutor.setEspecialidadeTutor(rs.getString("especialidadeTutor"));
				tutor.setDescricaoTutor(rs.getString("descricaoTutor"));
				lista.add(tutor);
			}
		} catch (Exception e){
			e.printStackTrace();
		}

		return lista;
	}

}
