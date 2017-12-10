/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.*;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.util.Duration;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author magaydu
 */
public class Capteur {
    
    private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    
    private Algorithme algo;
    
    private CapteurThread leThread= new CapteurThread(this);
    private Thread test;
    
    
    public Capteur(int id,String nom,int actualisation, float temperature, Algorithme algo) {
        this.test = new Thread();
        this.id.set(id);
        this.nom.set(nom);
        this.actualisation.set(actualisation);
        this.algo=algo;
        if(algo==null)this.temperature.set(temperature);
        else this.temperature.set(algo.getNewTemp(temperature));
        
        leThread.start();
        this.temperature=leThread.getCapteurActif().temperatureProperty();
        
                
    }

    public CapteurThread getLeThread() {
        return leThread;
    }

    public void setLeThread(CapteurThread leThread) {
        this.leThread = leThread;
    }
    
    public Algorithme getAlgo(){
        return this.algo;
    }
    
    public int getIden() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public int getActualisation() {
        return actualisation.get();
    }

    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }

    public float getTemperature() {
                
        return temperature.get();
    }

    public void setTemperature(float temperature) {
        this.temperature.set(temperature);
    }
    

    public StringProperty nomProperty() {
        return nom;
    }
    public IntegerProperty idProperty() {
        return id;
    }
    public  IntegerProperty actualisationProperty(){
        return actualisation;
    }
    public FloatProperty temperatureProperty(){
        return temperature;
    }
    @Override
    public String toString(){
        return getNom()+" "+getAlgo();
    }
}
