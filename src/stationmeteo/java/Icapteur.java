/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

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
public abstract class Icapteur {
    
    //commun
    private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
   // private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    //private FloatProperty poids = new SimpleFloatProperty(this, "poid");

    public IntegerProperty idProperty(){return id;}
    public StringProperty nomProperty(){return nom;}
    @SuppressWarnings("WeakerAccess")
    public abstract FloatProperty temperatureProperty();
    @SuppressWarnings("WeakerAccess")
    public abstract float getTemperature();
    
    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
    
   
       
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

}
