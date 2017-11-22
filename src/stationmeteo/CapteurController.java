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
    TextField digitalText;
    @FXML
    TextField barText;
    @FXML
    ProgressBar thermometre;
    @FXML
    TextField imgText;
    @FXML
    ImageView img;
    
    private Capteur cap;
    
    public void initialize(URL location, ResourceBundle resources) {
        digitalText.setText(""+cap.getTemperature());
        barText.setText(""+cap.getTemperature());
        imgText.setText(""+cap.getTemperature());

    }
    
}
