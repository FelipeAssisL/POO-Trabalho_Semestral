package edu.curso.controlers;

import java.util.List;

import edu.curso.dao.TutorDAO;
import edu.curso.dao.InterfTutorDAO;
import edu.curso.models.Tutor;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TutorControler {
	
	private StringProperty nomeTutor = new SimpleStringProperty("");
	private StringProperty especialidadeTutor = new SimpleStringProperty("");
	private StringProperty descricaoTutor = new SimpleStringProperty("");
	private ObservableList<Tutor> listaTutores = FXCollections.observableArrayList();
	private InterfTutorDAO dao = new TutorDAO();
	
	public void pesquisarTutor() {			
		List<Tutor> tutoresCadastrados = dao.pesquisarPorNome(nomeTutor.get());
		listaTutores.clear();
		listaTutores.addAll(tutoresCadastrados);
	}
	
	public void cadastrarTutor() {
		
		Tutor tutor = new Tutor();
		tutor.setNomeTutor(nomeTutor.get());
		tutor.setEspecialidadeTutor(especialidadeTutor.get());
		tutor.setDescricaoTutor(descricaoTutor.get());
		
		dao.salvar(tutor);
		nomeTutor.set("");
		especialidadeTutor.set("");
		descricaoTutor.set("");
        lerTodos();
	}
	
	public void lerTodos() {
		List<Tutor> tutoresCadastrados = dao.lerTodos();
		listaTutores.clear();
		listaTutores.addAll(tutoresCadastrados);
	}
	
	public StringProperty nomeProperty() {
		return this.nomeTutor;
	}
	public StringProperty especialidadeProperty() {
		return this.especialidadeTutor;
	}
	public StringProperty descricaoProperty() {
		return this.descricaoTutor;
	}
	public ObservableList<Tutor> getListaTutor(){
		return this.listaTutores;
	}
	
	
}
