/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;


import java.net.URL;

import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.FloatBinding;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import javafx.util.StringConverter;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.When;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;


import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.util.converter.NumberStringConverter;
import stationmeteo.java.Icapteur;



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
    private final Icapteur cap;
    private final FloatProperty progressBarValue=new SimpleFloatProperty();
    private final SimpleObjectProperty ImageProperty= new SimpleObjectProperty();
    private final ObjectBinding monImage ;
    private final FloatBinding min;
    private final StringConverter<Number> converter = new NumberStringConverter();
    
    public CapteurController(Icapteur c){
        cap=c;
        Image nuage = new Image("stationmeteo/ressources/images/nuage.png");
        Image soleil = new Image("stationmeteo/ressources/images/soleil.png");
        ObjectBinding uneParti = new When(cap.temperatureProperty().lessThan(20f))
                .then(nuage)
                .otherwise(soleil);
        Image snow = new Image("stationmeteo/ressources/images/snow.png");
        monImage = new When(cap.temperatureProperty().lessThanOrEqualTo(0f))
                       .then(snow)
                       .otherwise(uneParti);
        FloatProperty progressBarMin = new SimpleFloatProperty();
        progressBarMin.set(0f);
        min=(FloatBinding)new When(cap.temperatureProperty().lessThan(-10f)).then(progressBarMin).otherwise(cap.temperatureProperty().add(10f).divide(50f));
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        


        //nameText.setText(cap.getNom());
        nameText.textProperty().bind(cap.nomProperty());
        
        //cpt.setText(String.valueOf(cap.getTemperature())+"°C");
        //cpt.textProperty().bind( cap.temperatureProperty().asString());
        Bindings.bindBidirectional(cpt.textProperty(), cap.temperatureProperty(), converter);
        cpt.textProperty().bindBidirectional(cap.temperatureProperty(), converter);
         
         if(icon!=null){
            
             
                ImageProperty.bind(this.monImage);
            
            icon.imageProperty().bind(ImageProperty);
        }
        if(thermo!=null){
            thermo.setStyle("-fx-accent: red;");
            
            this.progressBarValue.bind(cap.temperatureProperty().add(10f).divide(50f));
            thermo.progressProperty().bind(min);

        }
    }

    
    
}
