package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaAdminAluno extends Application {

    private Stage stage;
    private TabPane tabPane;
    private boolean admin = false;

    public void start(Stage stage) throws Exception {

        if (admin) {

            try {
                this.stage = stage;
                stage.setTitle("MadFit - ADMIN");
                BorderPane root = new BorderPane();

                tabPane = new TabPane();

                // ABAS DA TELA DE ADMIN
                Tab tabAvisos = new Tab("Avisos");
                Tab tabEventos = new Tab("Aulas");
                Tab tabEquipamentos = new Tab("Equipamentos");
                Tab tabAlunos = new Tab("Alunos");
                Tab tabTutores = new Tab("Tutores");
                Tab tabPlano = new Tab("Planos");
                	
                tabAvisos.setClosable(false);
                tabEventos.setClosable(false);
                tabEquipamentos.setClosable(false);
                tabAlunos.setClosable(false);
                tabTutores.setClosable(false);
                tabPlano.setClosable(false);
                tabPane.getTabs().addAll(tabAvisos, tabEventos, tabEquipamentos, tabAlunos, tabTutores, tabPlano);
                root.setCenter(tabPane);

                Scene scene = new Scene(root, 800, 500);
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
                Tab tabAvisos = new Tab("Avisos");
                Tab tabEventos = new Tab("Aulas");
                Tab tabEquipamentos = new Tab("Equipamentos");
                Tab tabPerfil = new Tab("Meu Perfil");
                Tab tabTutores = new Tab("Tutores");
                Tab tabPlano = new Tab("Planos");

                tabAvisos.setClosable(false);
                tabEventos.setClosable(false);
                tabEquipamentos.setClosable(false);
                tabPerfil.setClosable(false);
                tabTutores.setClosable(false);
                tabPlano.setClosable(false);

                tabPane.getTabs().addAll(tabAvisos, tabEventos, tabEquipamentos, tabTutores, tabPlano, tabPerfil);
                root.setCenter(tabPane);

                Scene scene = new Scene(root, 800, 500);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
