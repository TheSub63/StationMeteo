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
public class XMLcapteur extends Icapteur implements Serializable,ICapteurSerialize {
//commun

    private IntegerProperty id;
    private StringProperty nom;
    private FloatProperty temperature;
    private FloatProperty Poid;
    //capteur
    private IntegerProperty actualisation;
    private final ObjectProperty<Algorithme> algo;

    //propre au xmlCapteur
    private transient ICapteurSerialize model;

    public XMLcapteur() {
        model = new Capteur();
        id = new SimpleIntegerProperty(model.getId());
        nom = new SimpleStringProperty(model.getNom());
        temperature = new SimpleFloatProperty(model.getTemperature());
        Poid = new SimpleFloatProperty(model.getPoids());
        actualisation = new SimpleIntegerProperty(model.getActualisation());
        algo = new SimpleObjectProperty(model.getAlgo());
   
    }

    public XMLcapteur(ICapteurSerialize n) {
        model = n;
        id = new SimpleIntegerProperty(n.getId());
        nom = new SimpleStringProperty(n.getNom());
        temperature = new SimpleFloatProperty(n.getTemperature());
        Poid = new SimpleFloatProperty(n.getPoids());
        actualisation = new SimpleIntegerProperty(n.getActualisation());
        algo = new SimpleObjectProperty(n.getAlgo());
        
    }

    @Override
    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public StringProperty nomProperty() {
        return nom;
    }

    @Override
    public FloatProperty temperatureProperty() {
        return temperature;
    }

    @Override
    public FloatProperty poidsProperty() {
        return Poid;
    }

    @Override
    public IntegerProperty actualisationProperty() {
        return actualisation;
    }

    @Override
    public ObjectProperty<Algorithme> algoProperty() {
        return algo;
    }



    public ICapteurSerialize getModel() {
        model = new Capteur(this.getId(),this.getNom(),this.getActualisation(),this.getTemperature(),this.getAlgo());
        return model;
    }

    @Override
    public int getId() {
        return id.get();
    }

    /**
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public String getNom() {
        return nom.get();
    }

    @Override
    public void setNom(String nom) {
        this.nom.set(nom);
    }

    @Override
    public float getTemperature() {
        return temperature.get();
    }

    /**
     *
     * @param temperature
     */
    @Override
    public void setTemperature(float temperature) {
        this.temperature.set(temperature);
    }

    /**
     *
     * @return
     */
    @Override
    public float getPoids() {
        return Poid.get();
    }

    /**
     *
     * @param Poid
     */
    @Override
    public void setPoids(float Poid) {
        this.Poid.set(Poid);
    }

    @Override
    public int getActualisation() {
        return actualisation.get();
    }

    @Override
    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }

    

    @Override
    public Algorithme getAlgo() {
        return algo.get();
    }

    @Override
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }

    @Override
    public String toString(){
        return this.getNom();
    }
}
