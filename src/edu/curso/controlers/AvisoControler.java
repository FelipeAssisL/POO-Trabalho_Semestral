package edu.curso.controlers;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import java.time.LocalDate;
import java.util.List;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import edu.curso.models.Aviso;
import edu.curso.dao.*;

public class AvisoControler {
	
	private StringProperty tituloAviso = new SimpleStringProperty("");
	private StringProperty descricaoAviso = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> dataPublicacao = new SimpleObjectProperty<>(LocalDate.now());	
	private ObservableList<Aviso> listaAvisos = FXCollections.observableArrayList();
	private InterfAvisoDAO dao = new AvisoDAO();

	
	public void pesquisarAviso() {			
		List<Aviso> avisosCadastrados = dao.pesquisarPorNome(tituloAviso.get());
		listaAvisos.clear();
		listaAvisos.addAll(avisosCadastrados);
	}
	
	public void cadastrarAviso() {
		Aviso aviso = new Aviso();
		aviso.setTituloAviso(tituloAviso.get());
		aviso.setDescricaoAviso(descricaoAviso.get());
		
		dao.salvar(aviso);
		tituloAviso.set("");
		descricaoAviso.set("");
        lerTodos();
	}
	
	public void lerTodos() {
		List<Aviso> avisosCadastrados = dao.lerTodos();
		listaAvisos.clear();
		listaAvisos.addAll(avisosCadastrados);
	}
	
	public StringProperty tituloProperty() {
		return this.tituloAviso;
	}
	
	public StringProperty descricaoProperty() {
		return this.descricaoAviso;
	}
	
	public ObjectProperty<LocalDate> dataPublicacaoProperty() { 
		return this.dataPublicacao;
	}
	
	public ObservableList<Aviso> getListaAvisos(){
		return this.listaAvisos;
	}
	
	
	

}