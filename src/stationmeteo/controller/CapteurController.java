/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
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
    
    private List<Capteur> cap =new ArrayList<>();
    
    private StationMeteo application;
    
    public void setApp(StationMeteo application){
        this.application = application;
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        cap.add(new Capteur(0,"cap0",1,1));
        digitText.setText(""+cap.get(0).getTemperature());
        barText.setText(""+cap.get(0).getTemperature());
        imgText.setText(""+cap.get(0).getTemperature());//To change body of generated methods, choose Tools | Templates.
    }
    
}
