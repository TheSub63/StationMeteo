/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;


import java.net.URL;

import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.util.StringConverter;

import stationmeteo.java.Capteur;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.When;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;


import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.util.converter.NumberStringConverter;



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
    private final Image snow =new Image("stationmeteo/ressources/images/snow.png");
    private final Image nuage= new Image("stationmeteo/ressources/images/nuage.png");
    private final Image soleil=new Image("stationmeteo/ressources/images/soleil.png");
    private final Capteur cap;
    private final FloatProperty progressBarValue=new SimpleFloatProperty();
    private final FloatProperty IconProperty=new SimpleFloatProperty();
    
    private final ObjectProperty<Image> ImageProperty= new SimpleObjectProperty();
    private final ObjectBinding uneParti ;
    //private ObjectProperty<Image> ImageProperty = new SimpleObjectProperty(); 
    private final ObjectBinding monImage ;
                                                                       
    
    private final StringConverter<Number> converter = new NumberStringConverter();
    public CapteurController(Capteur c){
        cap=c;
        uneParti=new When(cap.temperatureProperty().lessThan(20f))
                    .then(nuage)
                    .otherwise(soleil);
        monImage = new When(cap.temperatureProperty().lessThanOrEqualTo(0f))
                       .then(snow)
                       .otherwise(uneParti);
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        


        //nameText.setText(cap.getNom());
        nameText.textProperty().bind(cap.nomProperty());
        
        //cpt.setText(String.valueOf(cap.getTemperature())+"°C");
        //cpt.textProperty().bind( cap.temperatureProperty().asString());
        Bindings.bindBidirectional(cpt.textProperty(), cap.temperatureProperty(), converter);
         
         if(icon!=null){
            
             
                ImageProperty.bind(this.monImage);
            
            icon.imageProperty().bind(ImageProperty);
        }
        if(thermo!=null){
            thermo.setStyle("-fx-accent: red;");
            
            
            this.progressBarValue.bind(cap.temperatureProperty().add(10f).divide(50f));
            thermo.progressProperty().bind(this.progressBarValue);
                    
                    
            

        }
    }

    
    
}
