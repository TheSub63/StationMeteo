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
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.When;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
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
import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableObjectValue;
import javafx.concurrent.Task;
import static javafx.scene.input.KeyCode.T;
import javafx.util.converter.DoubleStringConverter;
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
    private Image snow =new Image("stationmeteo/ressources/images/snow.png");
    private Image nuage= new Image("stationmeteo/ressources/images/nuage.png");
    private Image soleil=new Image("stationmeteo/ressources/images/soleil.png");
    private Capteur cap;
    private FloatProperty progressBarValue=new SimpleFloatProperty();
    private FloatProperty IconProperty=new SimpleFloatProperty();
    private String imgname;
    private ObjectProperty<Image> ImageProperty= new SimpleObjectProperty();
    private ObjectBinding uneParti ;
    //private ObjectProperty<Image> ImageProperty = new SimpleObjectProperty(); 
    private ObjectBinding monImage ;
                                                                       
    private BooleanProperty isTemp = new SimpleBooleanProperty();
    private StringConverter<Number> converter = new NumberStringConverter();
    public CapteurController(Capteur c){
        cap=c;
        uneParti=new When(cap.temperatureProperty().lessThan(20f))
                    .then(nuage)
                    .otherwise(soleil);
        monImage = new When(cap.temperatureProperty().lessThan(0f))
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
