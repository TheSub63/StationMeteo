/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.io.Serializable;
import java.util.List;
import javafx.beans.property.FloatProperty;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author matthias
 */
public class XMLcapteur extends Icapteur implements Serializable{
//commun
    private IntegerProperty id;
    private StringProperty nom;
    private FloatProperty temperature;
    private FloatProperty Poid;
    //capteur
    private IntegerProperty actualisation;
    private final ObjectProperty<Algorithme> algo;
    
    //superCapteur
    private ObjectProperty<List<Icapteur>> listCapteur;
    private IntegerProperty i;
    private FloatProperty PoidTot;
    //propre au xmlCapteur
    private transient Icapteur model;  
    @Override
    public void setTemperature(float temperature) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public XMLcapteur(Icapteur n){
        model=n;
        id=new SimpleIntegerProperty(n.getIden());
        nom=new SimpleStringProperty(n.getNom());
        temperature=new SimpleFloatProperty(n.getTemperature());
        Poid=new SimpleFloatProperty(n.getPoid());
        actualisation=new SimpleIntegerProperty(n.getActualisation());
        algo=new SimpleObjectProperty(n.getAlgo());
        listCapteur=new SimpleObjectProperty(n.getListCapteur());
        i= new SimpleIntegerProperty(n.getI());
        PoidTot=new SimpleFloatProperty(n.getPoid());
    }

    public Icapteur getModel() {
        return model;
    }
    
}
