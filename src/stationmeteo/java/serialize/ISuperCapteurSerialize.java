/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.ICapteurPoid;

/**
 *
 * @author matthias
 */
public interface ISuperCapteurSerialize {
    public IntegerProperty idProperty();
    public StringProperty nomProperty();
    public FloatProperty temperatureProperty();
<<<<<<< HEAD
   
    @SuppressWarnings("WeakerAccess")
=======
    public ObjectProperty<List<CapteurPoid>> listCapteurProperty();
>>>>>>> 57d58d1a16a6a905740d2f9edc2da8dd07d86423
    default public int getId(){return idProperty().get();}
    default public String getNom(){return nomProperty().get();}
    default public float getTemperature(){return temperatureProperty().get();}
<<<<<<< HEAD
    @SuppressWarnings("WeakerAccess")
    public List<ICapteurPoid> getListCapteur();
=======
    default public List<CapteurPoid> getListCapteur(){return listCapteurProperty().get();}
>>>>>>> 57d58d1a16a6a905740d2f9edc2da8dd07d86423
    default public void setId(int id){idProperty().set(id);}
    default public void setNom(String nom){nomProperty().set(nom);}
<<<<<<< HEAD
    @SuppressWarnings("WeakerAccess")
    default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
    @SuppressWarnings("WeakerAccess")
   public void setListCapteur(List<ICapteurPoid>maliste);
=======
    //default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
    default public void setListCapteur(List<CapteurPoid>maliste){this.listCapteurProperty().set(maliste);}
>>>>>>> 57d58d1a16a6a905740d2f9edc2da8dd07d86423
}
