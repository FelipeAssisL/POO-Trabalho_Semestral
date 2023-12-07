package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.curso.models.Equipamento;

public class EquipamentoDAO implements InterfEquipamentoDAO {
	
	public static final String JDBC_URL= "jdbc:mariadb://localhost:3306/academia";
	public static final String JDBC_USER="root";
	public static final String JDBC_PASS="123456";

	private Connection con;
	
	public EquipamentoDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void salvar(Equipamento equip) {
		String sql = "INSERT INTO equipamento (nomeEquip, descricaoEquip) VALUES (?, ?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, equip.getNomeEquip());
			stmt.setString(2, equip.getDescricaoEquip());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Equipamento> lerTodos() {
		return pesquisarPorNome("");
	}

	@Override
	public List<Equipamento> pesquisarPorNome(String tituloEquip) {
		
		List<Equipamento> lista = new ArrayList<>();
		String sql = "SELECT * FROM equipamento WHERE nomeEquip LIKE ?";
		
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" +tituloEquip+ "%");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Equipamento equip = new Equipamento();
				equip.setNomeEquip(rs.getString("nomeEquip"));
				equip.setDescricaoEquip(rs.getString("descricaoEquip"));
				lista.add(equip);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
		
	}

}
