/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    private FloatProperty poids = new SimpleFloatProperty(this, "poid");
    //capteur
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    private Algorithme algo;
    //superCapteur
    private List<Icapteur> listCapteur;
    private float poid = 0;
    private int i;
    public Algorithme getAlgo() {
        return algo;
    }
    
   
    public void setAlgo(Algorithme algo) {
        this.algo = algo;
    }
    //public abstract void setPoid(float poid);
    public abstract void setTemperature(float temperature);
    
    
    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
    public StringProperty nomProperty() {
        return nom;
    }
    public void setUnPoid(float poid) {
        this.poids.set(poid);
    }
    public Float getPoids() {
        return poids.get();
    }
    
    public FloatProperty poidsProperty(){
        return poids;
    }
    public float getTemperature() {
        return temperature.get();
    }
    public FloatProperty temperatureProperty(){
        return temperature;
    }

    public void setUneTemperature(float temperature) {
        this.temperature.set(temperature);
    }
       
    public int getIden() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    public IntegerProperty idProperty() {
        return id;
    }
       public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }
        public int getActualisation() {
        return actualisation.get();
    }
    
    public  IntegerProperty actualisationProperty(){
        return actualisation;
    }

    public List<Icapteur> getListCapteur() {
        return listCapteur;
    }

    public void setListCapteur(List<Icapteur> listCapteur) {
        this.listCapteur = listCapteur;
    }

    public float getPoid() {
        return poid;
    }

    public void setPoid(float poid) {
        this.poid = poid;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
  
}
