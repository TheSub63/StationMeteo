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

/**
 *
 * @author matthias
 */
public interface ISuperCapteurSerialize {
    public IntegerProperty idProperty();
    public StringProperty nomProperty();
    public FloatProperty temperatureProperty();
    public ObjectProperty<List<CapteurPoid>> listCapteurProperty();
    @SuppressWarnings("WeakerAccess")
    default public int getId(){return idProperty().get();}
    @SuppressWarnings("WeakerAccess")
    default public String getNom(){return nomProperty().get();}
    @SuppressWarnings("WeakerAccess")
    default public float getTemperature(){return temperatureProperty().get();}
    @SuppressWarnings("WeakerAccess")
    default public List<CapteurPoid> getListCapteur(){return listCapteurProperty().get();}
    @SuppressWarnings("WeakerAccess")
    default public void setId(int id){idProperty().set(id);}
    @SuppressWarnings("WeakerAccess")
    default public void setNom(String nom){nomProperty().set(nom);}
    @SuppressWarnings("WeakerAccess")
    default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
    @SuppressWarnings("WeakerAccess")
    default public void setListCapteur(List<CapteurPoid>maliste){this.listCapteurProperty().set(maliste);}
}
