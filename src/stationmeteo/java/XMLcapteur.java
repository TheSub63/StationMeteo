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
   
    public XMLcapteur(){
        model=new Capteur();
        id=new SimpleIntegerProperty(model.getId());
        nom=new SimpleStringProperty(model.getNom());
        temperature=new SimpleFloatProperty(model.getTemperature());
        Poid=new SimpleFloatProperty(model.getPoid());
        actualisation=new SimpleIntegerProperty(model.getActualisation());
        algo=new SimpleObjectProperty(model.getAlgo());
        listCapteur=new SimpleObjectProperty(model.getListCapteur());
        i= new SimpleIntegerProperty(model.getI());
        PoidTot=new SimpleFloatProperty(model.getPoid());
    }
    public XMLcapteur(Capteur n){
        model=n;
        id=new SimpleIntegerProperty(n.getId());
        nom=new SimpleStringProperty(n.getNom());
        temperature=new SimpleFloatProperty(n.getTemperature());
        actualisation=new SimpleIntegerProperty(n.getActualisation());
        Poid=null;
        algo=null;
        listCapteur=null;
        i= null;
        PoidTot=null;
    }
    public XMLcapteur(Icapteur n){
        model=n;
        id=new SimpleIntegerProperty(n.getId());
        nom=new SimpleStringProperty(n.getNom());
        temperature=new SimpleFloatProperty(n.getTemperature());
        Poid=new SimpleFloatProperty(n.getPoid());
        actualisation=new SimpleIntegerProperty(n.getActualisation());
        algo=new SimpleObjectProperty(n.getAlgo());
        listCapteur=new SimpleObjectProperty(n.getListCapteur());
        i= new SimpleIntegerProperty(n.getI());
        PoidTot=new SimpleFloatProperty(n.getPoid());
    }
    @Override
    public IntegerProperty idProperty(){return id;}
    @Override
    public StringProperty nomProperty(){return nom;}
    @Override
    public FloatProperty temperatureProperty(){return temperature;}
    @Override
    public FloatProperty poidsProperty(){return Poid;}
    @Override
    public IntegerProperty actualisationProperty(){return actualisation;}
    @Override
    public ObjectProperty<Algorithme> algoProperty(){return algo;}
    @Override
    public ObjectProperty<List<Icapteur>> listCapteurProperty(){return listCapteur;}
    @Override
    public FloatProperty poidProperty(){return PoidTot;}
    @Override
    public IntegerProperty iProperty(){return i;}
     
    public Icapteur getModel() {
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
    public List<Icapteur> getListCapteur() {
        return listCapteur.get();
    }

    @Override
    public void setListCapteur(List<Icapteur> listCapteur) {
        this.listCapteur.set(listCapteur);
    }
    /**
     *
     * @return
     */
    @Override
    public int getI() {
        return i.get();
    }
    @Override
    public void setI(int i) {
        this.i.set(i);
    }
    @Override
    public float getPoid() {
        return PoidTot.get();
    }
    @Override
    public void setPoid(float PoidTot) {
        this.PoidTot.set(PoidTot);
    }
    @Override
     public Algorithme getAlgo() {
        return algo.get();
    }
    @Override
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }
    
    
}
