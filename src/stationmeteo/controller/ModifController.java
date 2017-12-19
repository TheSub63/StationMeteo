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
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleRole.LABEL;
import stationmeteo.java.Capteur;
import stationmeteo.java.Icapteur;
import stationmeteo.java.StationMeteo;
/**
 *
 * @author magaydu
 */
public class ModifController extends BorderPane implements Initializable{

    @FXML
    private Label nomCapteur;
    @FXML
    private Label idCapteur;
    @FXML
    private Label actualisationCapteur;
    @FXML
    private Label temperatureCapteur;
    @FXML
    private TextField nomText;
    @FXML
    private TextField idText;
    @FXML
    private TextField actualisationText;
    @FXML
    private TextField temperatureText;
    @FXML
    private Button validButton;
    @FXML
    private Button annulButton;
    
    private Icapteur capteur; 
    public ModifController(Icapteur c){
        capteur=c;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomText.setText(capteur.getNom());
        idText.setText(String.valueOf(capteur.getIden()));
        if(capteur.getClass()==Capteur.class){
        actualisationText.setText(String.valueOf(((Capteur) capteur).getActualisation()));
        }
        temperatureText.setText(String.valueOf(capteur.getTemperature()));
        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());
    }
    public void commitCapteur(){
            capteur.setNom(nomText.getText());
            capteur.setId(Integer.parseInt(idText.getText()));
            if(capteur.getClass()==Capteur.class){
                ((Capteur)capteur).setActualisation(Integer.parseInt(actualisationText.getText()));
        }
            
            capteur.setTemperature(Float.parseFloat(temperatureText.getText()));
            Stage stage = (Stage) validButton.getScene().getWindow();
            stage.close();
    }

    public Icapteur getCapteur() {
        return capteur;
    }
    
}
