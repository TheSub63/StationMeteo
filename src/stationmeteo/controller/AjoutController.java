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
import stationmeteo.java.StationMeteo;
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
    private Button validButton;
    
    protected Capteur i;
    private int id;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                commitCapteur();
                
            }
        });
    }
    
    public void commitCapteur(){
        //erreur non fatale quand champ non rempli
        id=Integer.parseInt(idCapteur.getText());
        i = new Capteur(id,nomCapteur.getText(),Integer.parseInt(actualisationCapteur.getText()),Float.parseFloat(temperatureCapteur.getText()));
        Stage stage = (Stage) validButton.getScene().getWindow();
        stage.close();
    }
    public Capteur getCapteur(){
        return i;
    }
}
    

