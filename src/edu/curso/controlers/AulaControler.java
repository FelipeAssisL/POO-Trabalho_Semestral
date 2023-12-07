package edu.curso.controlers;

import java.time.LocalDate;
import java.util.List;

import edu.curso.dao.AulaDAO;
import edu.curso.dao.InterfAulaDAO;
import edu.curso.models.Aula;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AulaControler {

	private StringProperty nomeAula = new SimpleStringProperty("");
	private StringProperty descricaoAula = new SimpleStringProperty("");
	private SimpleStringProperty instrutorAula = new SimpleStringProperty("");
	private StringProperty horaAula = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> dataAula = new SimpleObjectProperty<>();	
	private ObservableList<Aula> listaAulas = FXCollections.observableArrayList();
	
	private InterfAulaDAO dao = new AulaDAO();
	
	public void pesquisarAula() {			
		List<Aula> aulasCadastrados = dao.pesquisarPorNome(nomeAula.get());
		listaAulas.clear();
		listaAulas.addAll(aulasCadastrados);
	}
	
	public void cadastrarAula() {
		
		Aula aula = new Aula();
		aula.setNomeAula(nomeAula.get());
		aula.setDataAula(dataAula.get());
		aula.setHoraAula(horaAula.get());
		aula.setNomeInstrutor(instrutorAula.get());
		aula.setDescricaoAula(descricaoAula.get());
		
		dao.salvar(aula);
		nomeAula.set("");
		descricaoAula.set("");
		instrutorAula.set("");
		horaAula.set("");
        lerTodos();
	}
	
	public void lerTodos() {
		List<Aula> aulasCadastrados = dao.lerTodos();
		listaAulas.clear();
		listaAulas.addAll(aulasCadastrados);
	}
	
	public StringProperty nomeProperty() {
		return this.nomeAula;
	}
	public StringProperty descricaoProperty() {
		return this.descricaoAula;
	}
	public StringProperty tutorProperty() {
		return this.instrutorAula;
	}
	public StringProperty horaProperty() {
		return this.horaAula;
	}
	public ObjectProperty<LocalDate> dataProperty() {
		return this.dataAula;
	}
	public ObservableList<Aula> getListaAulas(){
		return this.listaAulas;
	}
}
