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
import static javax.accessibility.AccessibleRole.LABEL;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;
/**
 *
 * @author magaydu
 */
public class AjoutController extends BorderPane implements Initializable{

    @FXML
    TextField idCapteur;
    @FXML
    TextField nomCapteur;
    @FXML
    TextField actualisationCapteur;
    @FXML
    TextField temperatureCapteur;
    @FXML
    Button validButton;
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        validButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
               MainController.
                            }
        });
    }
    
}
