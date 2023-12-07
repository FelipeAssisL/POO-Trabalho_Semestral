package edu.curso.controlers;

import java.util.List;

import edu.curso.dao.EquipamentoDAO;
import edu.curso.dao.InterfEquipamentoDAO;
import edu.curso.models.Equipamento;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EquipamentoControler {
	
	private StringProperty nomeEquip = new SimpleStringProperty("");
	private StringProperty descricaoEquip = new SimpleStringProperty("");
	private ObservableList<Equipamento> listaEquipamentos = FXCollections.observableArrayList();
	private InterfEquipamentoDAO dao = new EquipamentoDAO();
	
	public void pesquisarEquipamento() {
		List<Equipamento> equipamentosCadastrados = dao.pesquisarPorNome(nomeEquip.get());
		listaEquipamentos.clear();
		listaEquipamentos.addAll(equipamentosCadastrados);
	}
	
	public void cadastrarEquipamento() {
		Equipamento equip = new Equipamento();
		equip.setNomeEquip(nomeEquip.get());
		equip.setDescricaoEquip(descricaoEquip.get());
		
		dao.salvar(equip);
		nomeEquip.set("");
		descricaoEquip.set("");
		lerTodos();
	}
	
	public void lerTodos() {
		List<Equipamento> equipamentosCadastrados = dao.lerTodos();
		listaEquipamentos.clear();
		listaEquipamentos.addAll(equipamentosCadastrados);
	}
	
	public StringProperty nomeEquipProperty() {
		return this.nomeEquip;
	}
	
	public StringProperty descricaoEquipProperty() {
		return this.descricaoEquip;
	}
	
	public ObservableList<Equipamento> getListaEquipamentos(){
		return this.listaEquipamentos;
	}
}