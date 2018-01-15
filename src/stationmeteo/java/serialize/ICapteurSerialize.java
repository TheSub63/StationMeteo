/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author matthias
 */
public interface ICapteurSerialize  {
    
    public IntegerProperty idProperty();
    public StringProperty nomProperty();
    public FloatProperty temperatureProperty();
    public IntegerProperty actualisationProperty();
    public ObjectProperty<Algorithme> algoProperty();

    default public int getId(){return idProperty().get();}
    default public String getNom(){return nomProperty().get();}
    default public float getTemperature(){return temperatureProperty().get();}
    default public int getActualisation(){return actualisationProperty().get();}
    default public Algorithme getAlgo(){return algoProperty().get();}
    
    default public void setId(int id){idProperty().set(id);}
    default public void setNom(String nom){nomProperty().set(nom);}
    default public void setTemperature(float temperature){ temperatureProperty().set(temperature);}
    default public void setActualisation(int actu){actualisationProperty().set(actu);}
    default public void setAlgo(Algorithme algo){algoProperty().set(algo);}
}
