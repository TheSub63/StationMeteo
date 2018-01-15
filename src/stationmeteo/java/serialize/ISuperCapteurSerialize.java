/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.CapteurPoid;
import stationmeteo.java.ICapteurPoid;
import stationmeteo.java.ListCapteurPoid;

/**
 *
 * @author matthias
 */
public interface ISuperCapteurSerialize {
    public IntegerProperty idProperty();
    public StringProperty nomProperty();
    public FloatProperty temperatureProperty();

     public ListCapteurPoid getListCapteur();

    //public ObjectProperty<List<ICapteurPoid>> listCapteurProperty();
    
    default public int getId(){return idProperty().get();}
    default public String getNom(){return nomProperty().get();}
    default public float getTemperature(){return temperatureProperty().get();}
   
  
    
    default public void setId(int id){idProperty().set(id);}
    default public void setNom(String nom){nomProperty().set(nom);}
    default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
   public void setListCapteur(ListCapteurPoid maliste);
    //default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
    
}