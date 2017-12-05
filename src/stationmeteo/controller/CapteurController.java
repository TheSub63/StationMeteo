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
import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;

import javax.swing.*;

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
    private ImageView icon;
    @FXML
    private ProgressBar thermo;

    private Capteur cap;

    private String imgname;
    private StringProperty tempe=new SimpleStringProperty(this,"temp");
    public CapteurController(Capteur c){
        cap=c;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        tempe.set(String.valueOf(cap.getTemperature()));
        //nameText.setText(cap.getNom());
        nameText.textProperty().bind(cap.nomProperty());
        cpt.setText(String.valueOf(cap.getTemperature())+"°C");
        cpt.textProperty().bind(tempe);
        if(icon!=null){
            if(cap.getTemperature()<0) imgname="snow.png";
            else if(cap.getTemperature()<20) imgname="nuage.png";
            else if(cap.getTemperature()>=20) imgname="soleil.png";
            Image img=new Image("stationmeteo/ressources/images/"+imgname);
            icon.setImage(img);
        }
        if(thermo!=null){
            thermo.setStyle("-fx-accent: red;");
            thermo.setProgress((cap.getTemperature()+10)/50);

        }
    }

    
    
}
