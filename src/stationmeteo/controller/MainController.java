/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author clguilbert
 */
public class MainController extends BorderPane implements Initializable {
    
    @FXML
    Button addButton;
    @FXML
    Button uptButton;
    @FXML
    Button delButton;
    @FXML
    Label nameText;
    @FXML
    ListView capteurList;
    
 private StationMeteo application;
    
    public void setApp(StationMeteo application){
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        capteurList=new ListView<Capteur>();
    }
    
        
    
}
