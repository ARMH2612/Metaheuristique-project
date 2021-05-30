package Home;

import Classes.ClauseList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import Classes.table_cnf_clause;
import partie1.BFS;

public class Controller implements Initializable {

    @FXML
    private CheckBox bfs_check;

    @FXML
    private CheckBox dfs_check;

    @FXML
    private CheckBox a_check;

    @FXML
    private RadioButton rad_sat_depuis_fichier;

    @FXML
    private ToggleGroup SAT_selction;

    @FXML
    private RadioButton rad_sat_random;

    @FXML
    private TextField text_file_path;

    @FXML
    private Button chose_file;

    @FXML
    private CheckBox chk_ifSat;

    @FXML
    private TextField text_nbr_var;

    @FXML
    private TextField text_nbr_clause;

    @FXML
    private TableView<table_cnf_clause> tabV_clause;

    @FXML
    private TableColumn<table_cnf_clause, String> tabCol_clause;

    @FXML
    private Button run;
    @FXML
    private Button genere_clauses_btn;

    @FXML
    public void toggle_SAT_radios(){

        boolean fichier;
        if (rad_sat_depuis_fichier.isSelected()){
           fichier = true;
        }else{
            fichier = false;
        }
        chk_ifSat.setDisable(fichier);
        text_nbr_var.setDisable(fichier);
        text_nbr_clause.setDisable(fichier);
        text_file_path.setDisable(!fichier);

    }


    FileChooser fileChooser = null;
    File file = null;

    @FXML
    public void chooseFile_pressed(){
        fileChooser = new FileChooser();
        file = fileChooser.showOpenDialog(null);
        if(file != null ){
            text_file_path.setText(file.getName());
            readFile(file.getAbsolutePath());
        }
    }




    private void readFile(String path){
        ObservableList<table_cnf_clause> clauses = FXCollections.observableArrayList();

        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null){
                clauses.add(new table_cnf_clause(line));

            }
            tabCol_clause.setCellValueFactory(new PropertyValueFactory<>("clause"));
            tabV_clause.setItems(clauses);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void genere_clauses_pressed(){
        int n  = Integer.parseInt(text_nbr_clause.getText());
        int m  = Integer.parseInt(text_nbr_var.getText());
        boolean SAT = chk_ifSat.isSelected();
        ClauseList clauses = new ClauseList(n,m).gen_aleat(SAT);

        ObservableList<table_cnf_clause> clausesOBL = FXCollections.observableArrayList();

        for (int i = 0; i < clauses.as_string_list().size(); i++) {
            //System.out.println(i+" - "+clauses.as_string_list().get(i));
            clausesOBL.add(new table_cnf_clause(clauses.as_string_list().get(i)));
        }

        tabCol_clause.setCellValueFactory(new PropertyValueFactory<>("clause"));
        tabV_clause.setItems(clausesOBL);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        chk_ifSat.setDisable(true);
        text_nbr_var.setDisable(true);
        text_nbr_clause.setDisable(true);
        text_file_path.setPromptText("Selectionner un ficher");
        bfs_check.setSelected(true);
        bfs_check.setDisable(true);
        dfs_check.setSelected(true);
        dfs_check.setDisable(true);
        a_check.setSelected(true);
        a_check.setDisable(true);

    }



    public class BfsThread extends Thread{
        File temp;
        public BfsThread(File file){
            super("BFS");
            temp = file;
        }
        public void run(){
            BFS bfs = new BFS();
        }
    }

}
