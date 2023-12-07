package edu.curso;

import java.time.format.DateTimeFormatter;

import edu.curso.controlers.AulaControler;
import edu.curso.controlers.AvisoControler;
import edu.curso.controlers.EquipamentoControler;
import edu.curso.controlers.TutorControler;
import edu.curso.models.Aula;
import edu.curso.models.Aviso;
import edu.curso.models.Equipamento;
import edu.curso.models.Tutor;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AcademiaBoundary extends Application {

    private Stage stage;
    private TabPane tabPane;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //TELA AVISOS
    TextField txtTituloAviso = new TextField();
    TextArea txtDescricaoAviso = new TextArea();
    Button btnPesquisarAviso = new Button("PESQUISAR");
    Button btnSalvarAviso = new Button("PUBLICAR");
    TableView<Aviso> tableAvisos = new TableView<>();
    
    //TELA EQUIPAMENTOS
    TextField txtNomeEquipamento = new TextField();
    TextField txtDescricaoEquip = new TextField();
    TextField txtBuscaEquipamento = new TextField();
    TableView<Equipamento> tableEquipamentos = new TableView<>();

    //TELA AULAS
    TextField txtTutor = new TextField();
    TextField txtAulas = new TextField();
    TextField txtHoraAula = new TextField();   
    TextArea txtDescricaoAulas = new TextArea(); 
    DatePicker dtAula = new DatePicker();
    Button btnPesquisarAula = new Button("PESQUISAR");
    Button btnSalvarAula = new Button("GRAVAR");
    TableView<Aula> tableAulas = new TableView<>();
    
    //TELA TUTOR
    TextField txtNomeTutor = new TextField();
    TextField txtEspecialidadeTutor = new TextField();
    TextField txtDescricaoTutor = new TextField();
    Button btnPesquisarTutor = new Button("PESQUISAR");
    Button btnSalvarTutor = new Button("GRAVAR");
    TableView<Tutor> tableTutores = new TableView<>();

    //CONTROLERS
    AvisoControler controlAviso = new AvisoControler();
    AulaControler controlAula = new AulaControler();
    TutorControler controlTutor = new TutorControler();
    EquipamentoControler controlEquip = new EquipamentoControler();
    
    public void start(Stage stage) throws Exception {
    	try {
    		this.stage = stage;
            stage.setTitle("MadFit - Acadêmia");
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1000, 650);
                
            tabPane = new TabPane();

            // ABAS DA TELA DE ADMIN
            Tab tabInicio = new Tab("Inicio");
                
            /*
             ****************** CADASTRO DE AVISOS ******************
            */
            
            Tab tabAvisos = new Tab("Avisos");
            GridPane gridAvisos = new GridPane();
              
            Button btnPesquisarAviso = new Button("PESQUISAR");
            Button btnSalvarAviso = new Button("PUBLICAR");
            
            btnPesquisarAviso.setOnAction( e -> controlAviso.pesquisarAviso());
            btnSalvarAviso.setOnAction( e -> controlAviso.cadastrarAviso());
            btnPesquisarAviso.setStyle("-fx-base: orange");
            btnSalvarAviso.setStyle("-fx-base: green;");
            
            txtTituloAviso.setMinWidth(600);
            txtDescricaoAviso.setMaxHeight(100);
		    txtDescricaoAviso.setMaxWidth(400);
		    txtDescricaoAviso.setMinWidth(600);

		    gridAvisos.setVgap(25);
	        gridAvisos.setHgap(10);
                  
			gridAvisos.add(new Label("Manutenção de Avisos"), 0, 0);
			gridAvisos.add(new Label("Título"), 0, 1);
			gridAvisos.add(txtTituloAviso, 1, 1);
			gridAvisos.add(btnPesquisarAviso, 2, 1);
			gridAvisos.add(new Label("Descrição"), 0, 2);
			gridAvisos.add(txtDescricaoAviso, 1, 2);
			gridAvisos.add(btnSalvarAviso, 2, 2);
			gridAvisos.add(tableAvisos, 1, 3);
			
			bindingAvisos();
			createColumnsAviso();
						              
			tabAvisos.setContent(gridAvisos);
                
            /*
            ****************** CADASTRO DE AULAS ******************
            */
            Tab tabEventos = new Tab("Aulas");
            GridPane gridAulas = new GridPane();
            
            btnPesquisarAula.setOnAction( e -> controlAula.pesquisarAula());
            btnPesquisarAula.setStyle("-fx-base: orange");
            btnSalvarAula.setOnAction( e -> controlAula.cadastrarAula());
            btnSalvarAula.setStyle("-fx-base: green");
            
            gridAulas.add(new Label("Manutenção de Aulas"),0,0);
            gridAulas.add(new Label("Aula"), 0, 1);
            gridAulas.add(txtAulas, 1, 1);
            txtAulas.setMinWidth(350);
            gridAulas.add(new Label("Data"), 0, 2);
            gridAulas.add(dtAula,1,2);
            gridAulas.add(new Label("Hora"), 2, 2);
            gridAulas.add(txtHoraAula, 3, 2);
			gridAulas.add(new Label("Instrutor"), 0, 3);
			gridAulas.add(txtTutor, 1, 3);
			gridAulas.add(new Label("Descrição"), 0, 4);
			gridAulas.add(txtDescricaoAulas, 1, 4);
            txtDescricaoAulas.setMaxHeight(50);
            txtDescricaoAulas.setMaxWidth(350);
			gridAulas.add(tableAulas, 1, 6);
            tableAulas.setMinWidth(450);
			gridAulas.add(btnPesquisarAula, 3, 1);
			gridAulas.add(btnSalvarAula, 3, 4);
			gridAulas.setVgap(25);
			
			bindingsAulas();
			createColumnsAula();
			tabEventos.setContent(gridAulas);

                
			/*
			****************** CADASTRO DE EQUIPAMENTOS ******************
			 */
    		Tab tabEquipamentos = new Tab("Equipamentos");
            GridPane gridEquip = new GridPane();
            
            Button btnPesquisarEquip = new Button("PESQUISAR");
            Button btnSalvarEquip = new Button("PUBLICAR");
            
            btnPesquisarEquip.setOnAction( e -> controlEquip.pesquisarEquipamento());
            btnSalvarEquip.setOnAction( e -> controlEquip.cadastrarEquipamento());
            btnPesquisarEquip.setStyle("-fx-base: orange");
            btnSalvarEquip.setStyle("-fx-base: green;");
            
            txtNomeEquipamento.setMinWidth(400);
            txtDescricaoEquip.setMinWidth(400);
            
            gridEquip.add(new Label("Manutenção de Equipamentos"), 0, 0);
            gridEquip.add(new Label("Equipamento"), 0, 1);
            gridEquip.add(txtNomeEquipamento, 1, 1);
            gridEquip.add(txtDescricaoEquip, 1, 2);
            gridEquip.add(btnPesquisarEquip, 2, 1);
            gridEquip.add(btnSalvarEquip, 2, 2);
            gridEquip.add(new Label("Descrição"), 0, 2);
            gridEquip.add(tableEquipamentos, 1, 3);
      

            gridEquip.setVgap(25);
            gridEquip.setHgap(10);
            
            bindingEquipamentos();
            createColumnsEquip();
            tabEquipamentos.setContent(gridEquip);

			/*
			****************** CADASTRO DE TUTORES ******************
			 */
			
            Tab tabTutores = new Tab("Tutores");
            GridPane gridTutores = new GridPane();
            
            btnPesquisarTutor.setOnAction( e -> controlTutor.pesquisarTutor());
            btnSalvarTutor.setOnAction( e -> controlTutor.cadastrarTutor());
            btnPesquisarTutor.setStyle("-fx-base: orange");
            btnSalvarTutor.setStyle("-fx-base: green");
            txtDescricaoTutor.setMaxHeight(100);
            txtDescricaoTutor.setMaxWidth(400);
            txtNomeTutor.setMinWidth(400);
            
            gridTutores.setVgap(25);
            gridTutores.setHgap(10);
            
            gridTutores.add(new Label("Manutenção de Tutores"), 0, 0);
            gridTutores.add(new Label("Nome"), 0, 1);
            gridTutores.add(txtNomeTutor, 1, 1);
            gridTutores.add(btnPesquisarTutor, 2, 1);
            gridTutores.add(new Label("Especialidade"), 0, 2);
            gridTutores.add(txtEspecialidadeTutor, 1, 2);
            gridTutores.add(new Label("Descrição"), 0, 3);
            gridTutores.add(txtDescricaoTutor, 1, 3);
            gridTutores.add(btnSalvarTutor, 2, 2);
            gridTutores.add(tableTutores, 1, 4);

            bindingTutor();
            createColumnsTutor();
            
			tabTutores.setContent(gridTutores);

            
            
			Tab tabAlunos = new Tab("Alunos");
			Tab tabPlano = new Tab("Planos");
                	
			tabInicio.setClosable(true);
			tabAvisos.setClosable(false);
			tabEventos.setClosable(false);
			tabEquipamentos.setClosable(false);
			tabAlunos.setClosable(false);
			tabTutores.setClosable(false);
			tabPlano.setClosable(false);
                
			tabPane.getTabs().addAll(tabAvisos, tabEventos, tabEquipamentos, tabAlunos, tabTutores, tabPlano);
			root.setCenter(tabPane);
			
			scene.getStylesheets().add(AcademiaBoundary.class.getResource("estilo.css").toExternalForm());
			stage.setScene(scene);
			stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
   

    private void bindingAvisos() {
    	Bindings.bindBidirectional(txtTituloAviso.textProperty(), controlAviso.tituloProperty());
    	Bindings.bindBidirectional(txtDescricaoAviso.textProperty(), controlAviso.descricaoProperty());
		
	}
    
	private void bindingEquipamentos() {
		Bindings.bindBidirectional(txtNomeEquipamento.textProperty(), controlEquip.nomeEquipProperty());
		Bindings.bindBidirectional(txtDescricaoEquip.textProperty(), controlEquip.descricaoEquipProperty());
	}
    
    private void bindingsAulas() {
    	Bindings.bindBidirectional(txtTutor.textProperty(), controlAula.tutorProperty());
    	Bindings.bindBidirectional(txtAulas.textProperty(), controlAula.nomeProperty());
    	Bindings.bindBidirectional(txtHoraAula.textProperty(), controlAula.horaProperty());
    	Bindings.bindBidirectional(txtDescricaoAulas.textProperty(), controlAula.descricaoProperty());
    	Bindings.bindBidirectional(dtAula.valueProperty(), controlAula.dataProperty());

    }

    private void bindingTutor() {
    	Bindings.bindBidirectional(txtNomeTutor.textProperty(), controlTutor.nomeProperty());
    	Bindings.bindBidirectional(txtEspecialidadeTutor.textProperty(), controlTutor.especialidadeProperty());
    	Bindings.bindBidirectional(txtDescricaoTutor.textProperty(), controlTutor.descricaoProperty());
		
	}
	
	private void createColumnsEquip() {
		tableEquipamentos.setItems(controlEquip.getListaEquipamentos());
		
    	TableColumn <Equipamento, String> colNomeEquip = new TableColumn<>("Equipamento");
    	colNomeEquip.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeEquip()));
    	
    	TableColumn <Equipamento, String> colDescricaoEquip = new TableColumn<>("Descrição do Equipamento");
    	colDescricaoEquip.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescricaoEquip()));
    	
    	colNomeEquip.setMinWidth(200);
    	colDescricaoEquip.setMinWidth(350);
    	
		tableEquipamentos.getColumns().addAll(colNomeEquip, colDescricaoEquip);
		
	}

	private void createColumnsAviso() {
		tableAvisos.setItems(controlAviso.getListaAvisos());
		
		TableColumn <Aviso, String> colTituloAviso = new TableColumn<>("Título do Aviso");
		colTituloAviso.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getTituloAviso()));
		
		TableColumn <Aviso, String> colDescricaoAviso = new TableColumn<>("Descrição");
		colDescricaoAviso.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescricaoAviso()));
    	
		colTituloAviso.setMinWidth(250);
		colDescricaoAviso.setMinWidth(350);
    	
		tableAvisos.getColumns().addAll(colTituloAviso, colDescricaoAviso);
	}

    private void createColumnsAula() {
    	
		tableAulas.setItems(controlAula.getListaAulas());

        TableColumn<Aula, String> colNomeAula = new TableColumn<>("Aula");
        colNomeAula.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeAula()));
        
        TableColumn<Aula, String> colInstrutor = new TableColumn<>("Instrutor");
        colInstrutor.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeInstrutor()));
        
        TableColumn<Aula, String> colDataAula = new TableColumn<>("Data");
        colDataAula.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(dtf.format(itemData.getValue().getDataAula())));

        TableColumn<Aula, String> colHoraAula = new TableColumn<>("Hora");
        colHoraAula.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getHoraAula()));
        
        TableColumn<Aula, String> colDescAula = new TableColumn<>("Descrição");
        colDescAula.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescricaoAula()));

        colNomeAula.setMinWidth(100);
        colInstrutor.setMinWidth(100);
        colDataAula.setMinWidth(100);
        colHoraAula.setMinWidth(100);
        colDescAula.setMinWidth(150);

		tableAulas.getColumns().addAll(colNomeAula,colInstrutor,colDataAula,colHoraAula,colDescAula);
    }
    
	private void createColumnsTutor() {
		
		tableTutores.setItems(controlTutor.getListaTutor());
		
		TableColumn <Tutor, String> colNomeTutor = new TableColumn<>("Tutor");
		colNomeTutor.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getNomeTutor()));
		
		TableColumn<Tutor, String> colEspecialidadeTutor = new TableColumn<>("Especialidade");
		colEspecialidadeTutor.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getEspecialidadeTutor()));
		
		TableColumn <Tutor, String> colDescricaoTutor = new TableColumn<>("Descrição");
		colDescricaoTutor.setCellValueFactory(itemData -> new ReadOnlyStringWrapper(itemData.getValue().getDescricaoTutor()));
		
		colNomeTutor.setMinWidth(150);
		colEspecialidadeTutor.setMinWidth(150);
		colDescricaoTutor.setMinWidth(250);
		
		tableTutores.getColumns().addAll(colNomeTutor, colEspecialidadeTutor, colDescricaoTutor);
	}
    
	public static void main(String[] args) {
        Application.launch(AcademiaBoundary.class, args);
    }
}