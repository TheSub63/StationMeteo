/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleRole.LABEL;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoire;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;
/**
 *
 * @author magaydu
 */
public class AjoutController extends BorderPane implements Initializable{

    @FXML
    private TextField idCapteur;
    @FXML
    private TextField nomCapteur;
    @FXML
    private TextField actualisationCapteur;
    @FXML
    private TextField temperatureCapteur;
    @FXML
    private TextField intervalleAlgo;
    @FXML
    private TextField onAlgoFixeAfficher1;
    @FXML
    private TextField onAlgoFixeAfficher2;
    @FXML
    private Button validButton;
    @FXML
    private Button annulButton;
    @FXML
    private ChoiceBox<Algorithme> algoCapteur;//https://docs.oracle.com/javafx/2/ui_controls/choice-box.htm
    
    private Algorithme selectedAlgo;
    protected Capteur i;
    private int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        validButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                commitCapteur();
                
            }
        });
        annulButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Stage stage = (Stage) annulButton.getScene().getWindow();
                stage.close();
                
            }
        });

        algoCapteur.setItems(FXCollections.observableArrayList(null, new AlgorithmeAleatoire(), new AlgorithmeAleatoireFixe(1f,1f), new AlgorithmeFenetreGlissante(1f)));


        algoCapteur.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                algoCapteur.getSelectionModel().selectedIndexProperty();
                selectedAlgo=(Algorithme)algoCapteur.getSelectionModel().getSelectedItem();
                if(selectedAlgo==null){
                    onAlgoFixeAfficher1.setDisable(true);
                    onAlgoFixeAfficher2.setDisable(true);
                    intervalleAlgo.setDisable(true);
                }
                else if(selectedAlgo.getClass()==AlgorithmeAleatoireFixe.class){
                    onAlgoFixeAfficher1.setDisable(false);
                    onAlgoFixeAfficher2.setDisable(false);
                    intervalleAlgo.setDisable(true); //SALE?
                }
                else if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class){
                    intervalleAlgo.setDisable(false);
                    onAlgoFixeAfficher1.setDisable(true);
                    onAlgoFixeAfficher2.setDisable(true);
                }
                else {
                    onAlgoFixeAfficher1.setDisable(true);
                    onAlgoFixeAfficher2.setDisable(true);
                    intervalleAlgo.setDisable(true);
                }

            }
        });
    }
    
    public void commitCapteur(){
        //erreur non fatale quand champ non rempli

        if(verifInfos()==false){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Veuillez remplir tous les champs");
            alert.setContentText("Id doit être un entier, température et actualisation des nombres.");
            alert.showAndWait();
        }
        else {
            Algorithme algo = selectedAlgo;
            id = Integer.parseInt(idCapteur.getText());
            i = new Capteur(id, nomCapteur.getText(), Integer.parseInt(actualisationCapteur.getText()), Float.parseFloat(temperatureCapteur.getText()), algo);
            Stage stage = (Stage) validButton.getScene().getWindow();
            stage.close();
        }
    }

    private boolean verifInfos(){

        if(nomCapteur.getText().isEmpty() || idCapteur.getText().isEmpty() || actualisationCapteur.getText().isEmpty()){
            return false;
        }
        if(temperatureCapteur.getText().isEmpty()||!temperatureCapteur.getText().matches("^-?[0-9]*(.[0-9]+)?$")) temperatureCapteur.setText("0");

        if(! idCapteur.getText().matches("^[0-9]+$")||!actualisationCapteur.getText().matches("^[0-9.]*(.[0-9]+)?$"))return false;

        //Faire verifs algo spécialisés
        //Rendre la fonction accessible par ModifController

        return true;
    }

    public Capteur getCapteur(){
        return i;
    }

}
    

