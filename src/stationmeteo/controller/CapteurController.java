/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author clguilbert
 */
public class CapteurController extends AnchorPane implements Initializable{
    
    @FXML
    Label digitText;
    @FXML
    Label barText;
    @FXML
    Label imgText;
    @FXML
    ProgressBar thermometre;
    @FXML
    ImageView img;
    
    private Capteur cap;
    
    private StationMeteo application;
    
    public void setApp(StationMeteo application){
        this.application = application;
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        cap=new Capteur(0,"cap0",1,1);
        digitText.setText(""+cap.getTemperature());
        barText.setText(""+cap.getTemperature());
        imgText.setText(""+cap.getTemperature());
    }
    
}
