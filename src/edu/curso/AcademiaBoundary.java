package edu.curso;

import edu.curso.models.Aula;
import edu.curso.models.Aviso;
import edu.curso.models.Equipamento;
import javafx.application.Application;
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
    private boolean admin = true;
    
    TextField txtTituloAviso = new TextField();
    TextArea txtDescricaoAviso = new TextArea();
    TextField txtNomeEquipamento = new TextField();
    TextField txtDescricaoEquip = new TextField();
    TextField txtAulas = new TextField();
    TextField txtTutor = new TextField();
    DatePicker dtAula = new DatePicker();
    TextArea txtDescricaoAulas = new TextArea();
    TableView<Aviso> tableAvisos = new TableView<>();
    TableView<Equipamento> tableEquipamentos = new TableView<>();
    TableView<Aula> tableAulas = new TableView<>();
    TextField txtBuscaEquipamento = new TextField();

    public void start(Stage stage) throws Exception {

        if (admin) {

            try {
                this.stage = stage;
                stage.setTitle("MadFit - Acad�mia");
                BorderPane root = new BorderPane();
                Scene scene = new Scene(root, 950, 650);
                
                tabPane = new TabPane();

                // ABAS DA TELA DE ADMIN
                Tab tabInicio = new Tab("Inicio");
                
                //TELA DE AVISOS - ADMIN
                Tab tabAvisos = new Tab("Avisos");
                GridPane gridAvisos = new GridPane();
                
                Button btnPesquisarAviso = new Button("PESQUISAR");
                Button btnSalvarAviso = new Button("PUBLICAR");
                Button btnAtualizarAviso = new Button("ATUALIZAR");
                Button btnExcluirAviso = new Button("EXCLUIR");
                
                gridAvisos.add(new Label("Manutenção de Avisos"), 0, 0);
                gridAvisos.add(new Label("T�tulo"), 0, 1);
                gridAvisos.add(txtTituloAviso, 1, 1);
                gridAvisos.add(btnPesquisarAviso, 2, 1);
                gridAvisos.add(new Label("Descrição"), 0, 2);
                gridAvisos.add(txtDescricaoAviso, 1, 2);
                txtDescricaoAviso.setMaxHeight(150);
                txtDescricaoAviso.setMaxWidth(400);
                
                gridAvisos.add(btnSalvarAviso, 0, 3);
                gridAvisos.add(btnAtualizarAviso, 1, 3);
                gridAvisos.add(btnExcluirAviso, 2, 3);
                gridAvisos.setVgap(25);
                gridAvisos.setHgap(10);
                
                tabAvisos.setContent(gridAvisos);
                
                // TELA DE AULAS - ADMIN
                Tab tabEventos = new Tab("Aulas");
                GridPane gridAulas = new GridPane();
                
                Button btnPesquisarAula = new Button("PESQUISAR");
                Button btnSalvarAula = new Button("GRAVAR");
                btnSalvarAula.setStyle("-fx-base: green;");
                Button btnExcluirAula = new Button("EXCLUIR");
                btnExcluirAula.setStyle("-fx-base: red;");
                
                gridAulas.add(new Label("Manutenção de Aulas"),0,0);
                
                gridAulas.add(new Label("Aula"), 0, 1);
                gridAulas.add(txtAulas, 1, 1);
                gridAulas.add(new Label("Data"), 0, 2);
                gridAulas.add(dtAula,1,2);
                
                gridAulas.add(new Label("Instrutor"), 0, 4);
                gridAulas.add(txtTutor, 1, 3);

                gridAulas.add(new Label("Descrição"), 0, 3);

                gridAulas.add(txtDescricaoAulas, 1, 4);
                txtDescricaoAulas.setMaxHeight(80);
                txtDescricaoAulas.setMaxWidth(400);
                
                txtAulas.setMinWidth(400);
                
                tableAulas.setMinWidth(600);
                TableColumn<Aula, String> colunaNomeAula = new TableColumn<>("Aula");
                TableColumn<Aula, String> colunaInstrutor = new TableColumn<>("Instrutor");
                TableColumn<Aula, String> colunaDataAula = new TableColumn<>("Data");
                TableColumn<Aula, String> colunaDescAula = new TableColumn<>("Descrição");


                colunaNomeAula.setMinWidth(150);
                colunaInstrutor.setMinWidth(150);
                colunaDataAula.setMinWidth(150);
                colunaDescAula.setMinWidth(150);

                ;
                tableAulas.getColumns().addAll(colunaNomeAula,colunaInstrutor,colunaDataAula,colunaDescAula);
                
                gridAulas.add(tableAulas, 1, 6);

                
                gridAulas.add(btnPesquisarAula, 2, 1);
                gridAulas.add(btnSalvarAula, 0, 5);
                gridAulas.add(btnExcluirAula, 2, 5);
                gridAulas.setVgap(25);
                gridAulas.setHgap(10);
                tabEventos.setContent(gridAulas);
                
                    //TELA DE EQUIPAMENTOS - ADMIN
                Tab tabEquipamentos = new Tab("Equipamentos");
                GridPane gridEquip = new GridPane();
                
                Button btnPesquisarEquip = new Button("PESQUISAR");
                Button btnSalvarEquip = new Button("PUBLICAR");
                Button btnAtualizarEquip = new Button("ATUALIZAR");
                Button btnExcluirEquip = new Button("EXCLUIR");
                
                gridEquip.add(new Label("Manutenção de Equipamentos"), 0, 0);
                gridEquip.add(new Label("Equipamento"), 0, 1);
                gridEquip.add(txtNomeEquipamento, 1, 1);
                gridEquip.add(btnPesquisarEquip, 2, 1);
                gridEquip.add(new Label("Descrição"), 0, 2);
                gridEquip.add(txtDescricaoEquip, 1, 2);
                
                txtNomeEquipamento.setMinWidth(400);

                gridEquip.add(btnSalvarEquip, 0, 3);
                gridEquip.add(btnAtualizarEquip, 1, 3);
                gridEquip.add(btnExcluirEquip, 2, 3);
                gridEquip.setVgap(25);
                gridEquip.setHgap(10);
                
                tabEquipamentos.setContent(gridEquip);

                
                Tab tabAlunos = new Tab("Alunos");
                Tab tabTutores = new Tab("Tutores");
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
        } else {

            try {
                this.stage = stage;
                stage.setTitle("MadFit - Aluno");
                BorderPane root = new BorderPane();
                

                tabPane = new TabPane();

                // ABAS DA TELA DE ALUNO
                Tab tabInicio = new Tab("Inicio");
                
                     //TAB DE AVISOS - ALUNO
                Tab tabAvisos = new Tab("Avisos");
                GridPane gridAvisosAluno = new GridPane();
                
                tableAvisos.setMinWidth(600);
                TableColumn<Aviso, String> colunaNomeAviso = new TableColumn<>("T�tulo");
                TableColumn<Aviso, String> colunaDescricaoAviso = new TableColumn<>("Comunicado");
                colunaNomeAviso.setMinWidth(200);
                colunaDescricaoAviso.setMinWidth(400);
                
                tableAvisos.getColumns().addAll(colunaNomeAviso, colunaDescricaoAviso);
                
                gridAvisosAluno.add(new Label("�ltimos Avisos"), 0, 0);
                gridAvisosAluno.add(tableAvisos, 0, 1);
                gridAvisosAluno.setVgap(25);
                gridAvisosAluno.setHgap(10);
                tabAvisos.setContent(gridAvisosAluno);

                Tab tabEventos = new Tab("Aulas");
                
                
                    //TAB DE EQUIPAMENTOS - ALUNO
                Tab tabEquipamentos = new Tab("Equipamentos");
                
                GridPane gridEquipAluno = new GridPane();
                FlowPane paneAux = new FlowPane();
                Label lblCtaEquipamentos = new Label("Temos tudo o que voc� precisa para cuidar da sua sa�de. Confira nossos equipamentos!");
                lblCtaEquipamentos.setStyle("-fx-font-size: 14");
                TableColumn<Equipamento, String> colunaNomeEquip = new TableColumn<>("Equipamento");
                TableColumn<Equipamento, String> colunaDescricaoEquip = new TableColumn<>("Benef�cios");
                colunaNomeEquip.setMinWidth(250);
                colunaDescricaoEquip.setMinWidth(350);
                Button btnBuscaEquip = new Button("BUSCAR");
                
                paneAux.getChildren().addAll(new Label("Buscar por nome"), txtBuscaEquipamento, btnBuscaEquip);
                paneAux.setHgap(15);
                
                tableEquipamentos.getColumns().addAll(colunaNomeEquip, colunaDescricaoEquip);
                
                gridEquipAluno.add(new Label("Equipamentos MadFit"), 0, 0);
                gridEquipAluno.add(lblCtaEquipamentos, 0, 1);
                gridEquipAluno.add(paneAux, 0, 2);
                gridEquipAluno.add(tableEquipamentos, 0, 3);
                gridEquipAluno.setVgap(25);
                gridEquipAluno.setHgap(10);
                tabEquipamentos.setContent(gridEquipAluno);
                                
                
                
                Tab tabPerfil = new Tab("Meu Perfil");
                Tab tabTutores = new Tab("Tutores");
                Tab tabPlano = new Tab("Planos");

                tabInicio.setClosable(true);
                tabAvisos.setClosable(false);
                tabEventos.setClosable(false);
                tabEquipamentos.setClosable(false);
                tabPerfil.setClosable(false);
                tabTutores.setClosable(false);
                tabPlano.setClosable(false);

                tabPane.getTabs().addAll(tabAvisos, tabEventos, tabEquipamentos, tabTutores, tabPlano, tabPerfil);
                root.setCenter(tabPane);
                
                
                Scene scene = new Scene(root, 800, 500);
                scene.getStylesheets().add(AcademiaBoundary.class.getResource("estilo.css").toExternalForm());
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(AcademiaBoundary.class, args);
    }
}