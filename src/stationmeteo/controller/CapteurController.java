/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;

import com.sun.javafx.scene.layout.region.Margins.Converter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
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
import javafx.util.StringConverter;
import javafx.util.converter.FloatStringConverter;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;
import java.lang.Float;
import static java.lang.Math.abs;
import java.text.Format;
import java.util.Observable;
import java.util.concurrent.Callable;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.concurrent.Task;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;
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
    private FloatProperty progressBarValue=new SimpleFloatProperty();
    private FloatProperty IconProperty=new SimpleFloatProperty();
    private String imgname;
    private ObjectProperty<Image> ImageProperty = new SimpleObjectProperty(); 
    private BooleanProperty isTemp = new SimpleBooleanProperty();
    private StringConverter<Number> converter = new NumberStringConverter();
    public CapteurController(Capteur c){
        cap=c;
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        


        //nameText.setText(cap.getNom());
        nameText.textProperty().bind(cap.nomProperty());
        
        //cpt.setText(String.valueOf(cap.getTemperature())+"°C");
        //cpt.textProperty().bind( cap.temperatureProperty().asString());
        Bindings.bindBidirectional(cpt.textProperty(), cap.temperatureProperty(), converter);
         
         if(icon!=null){
            this.isTemp.bind(cap.temperatureProperty().lessThan(0f));
            if(this.isTemp.get())
                    ImageProperty.set(new Image("stationmeteo/ressources/images/snow.png"));
            else{
                this.isTemp.bind(cap.temperatureProperty().lessThan(20f));
                if(this.isTemp.get()) 
                    ImageProperty.setValue(new Image("stationmeteo/ressources/images/nuage.png"));
                else{
                    ImageProperty.setValue(new Image("stationmeteo/ressources/images/soleil.png"));
                    
                }
            } 
                
            
            icon.imageProperty().bind(ImageProperty);
        }
        if(thermo!=null){
            thermo.setStyle("-fx-accent: red;");
            
            
            this.progressBarValue.bind(cap.temperatureProperty().add(10f).divide(50f));
            thermo.progressProperty().bind(this.progressBarValue);
                    
                    
            

        }
    }

    
    
}
