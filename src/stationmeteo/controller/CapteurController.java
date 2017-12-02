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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;
/**
 *
 * @author clguilbert
 */
public class CapteurController extends AnchorPane implements Initializable{
    
    @FXML
    private Label nameText;
    @FXML
    private Label cpt;
    @FXML
    private Label imgText;
    @FXML
    private ProgressBar thermometre;
    @FXML
    private ImageView icon;

    private Capteur cap;

    private String imgname;

    public CapteurController(Capteur c){
        cap=c;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameText.setText(cap.getNom());
        cpt.setText(String.valueOf(cap.getTemperature())+"°C");
        if(icon!=null){
            if(cap.getTemperature()<0) imgname="snow.png";
            else if(cap.getTemperature()<20) imgname="nuage.png";
            else if(cap.getTemperature()>=20) imgname="soleil.png";
            Image img=new Image("stationmeteo/ressources/images/"+imgname);
            icon.setImage(img);
        }
    }
    
}
