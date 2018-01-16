/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import stationmeteo.java.serialize.ICapteurSerialize;
import java.io.Serializable;
import javafx.beans.property.FloatProperty;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.metier.Capteur;
import stationmeteo.java.metier.Icapteur;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.metier.fabriqueCapteur;

/**
 *Classe qui permet la serialization des capteurs
 * @author matthias
 */
public class XMLCapteur extends Icapteur implements Serializable,ICapteurSerialize {
//commun

    private IntegerProperty id;
    private StringProperty nom;
    private FloatProperty temperature;
   
    //capteur
    private IntegerProperty actualisation;
    private final ObjectProperty<Algorithme> algo;

    //propre au xmlCapteur
    private transient ICapteurSerialize model;

    /**
     *Constructeur par default de XMLCapteur, il permet de creer un XMLCapteur
     * par default
     */
    public XMLCapteur() {
        model = (ICapteurSerialize) fabriqueCapteur.fabriqueCapteur();
        id = new SimpleIntegerProperty(model.getId());
        nom = new SimpleStringProperty(model.getNom());
        temperature = new SimpleFloatProperty(model.getTemperature());
        actualisation = new SimpleIntegerProperty(model.getActualisation());
        algo = new SimpleObjectProperty(model.getAlgo());
   
    }
    
    /**
     *Constructeur de XMLCapteur, il permet de creer un XMLCApteur à partir des
     * classes implementées par IcapteurSerialize
     * @param n est l'objet de la classe implementé par IcapteurSerialize
     */
    public XMLCapteur(ICapteurSerialize n) {
        model = n;
        id = new SimpleIntegerProperty(n.getId());
        nom = new SimpleStringProperty(n.getNom());
        temperature = new SimpleFloatProperty(n.getTemperature());
        actualisation = new SimpleIntegerProperty(n.getActualisation());
        algo = new SimpleObjectProperty(n.getAlgo());
        
    }
   
    /**
     *Getteur de l'idProperty
     * @return l'IntegerProperty id
     */
    @Override
    public IntegerProperty idProperty() {
        return id;
    }
    /**
     *Getteur du nomProperty
     * @return le StringProperty nom
     */
    @Override
    public StringProperty nomProperty() {
        return nom;
    }
    /**
     *Getteur de la temperatureProperty
     * @return le floatProperty temperature
     */
    @Override
    public FloatProperty temperatureProperty() {
        return temperature;
    }
    /**
     *Getteur de l'actualisationProperty
     * @return l'IntegerProperty actualisation
     */
    @Override
    public IntegerProperty actualisationProperty() {
        return actualisation;
    }
    /**
     *Getteur de algoProperty
     * @return l'ObjectProperty algo
     */
    @Override
    public ObjectProperty<Algorithme> algoProperty() {
        return algo;
    }

    /**
     *Permet de donner le modele utiliser par XMLCapteur pour se creer
     * @return l'objet implementer par IcapteurSerialize
     */
    public ICapteurSerialize getModel() {
        model = (ICapteurSerialize) fabriqueCapteur.fabriqueCapteur(this.getId(),this.getNom(),this.getActualisation(),this.getTemperature(),this.getAlgo());
        return model;
    }
    /**
     *Getteur de l'id
     * @return l'id du capteur
     */
    @Override
    public int getId() {
        return id.get();
    }

    /**
     *Setteur de l'id du capteur
     * @param id est la nouvelle id du capteur
     */
    @Override
    public void setId(int id) {
        this.id.set(id);
    }
    /**
     *Getteur du nom du capteur
     * @return le nom du capteur
     */
    @Override
    public String getNom() {
        return nom.get();
    }
    /**
     *Setteur du nom du capteur
     * @param nom est le nouveaux nom du capteur
     */
    @Override
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    /**
     *Getteur de la temperature du capteur
     * @return la temperature du capteur
     */
    @Override
    public float getTemperature() {
        return temperature.get();
    }

    /**
     *Setteur de la temperature du capteur
     * @param temperature est la nouvelle temperature du capteur
     */
    @Override
    public void setTemperature(float temperature) {
        this.temperature.set(temperature);
    }

    /**
     *Getteur de l'actualisation du capteur
     * @return le temps d'actualisation du capteur
     */
    @Override
    public int getActualisation() {
        return actualisation.get();
    }
    /**
     *Setteur de l'actualisation du capteur
     * @param actualisation est le nouveau temps d'actualisation du capteur
     */
    @Override
    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }
    /**
     *Getteur de l'Algorithme du capteur
     * @return l'Algorithme du capteur
     */
    @Override
    public Algorithme getAlgo() {
        return algo.get();
    }
    /**
     *Setteur de l'Algorithme du capteur
     * @param algo est le nouvelle Algorithme du capteur
     */
    @Override
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }

    /**
     *Cette callse permet de convertir l'Objet XMLCapteur en String
     * @return la conversion de l'objet XMLCapteur en string
     */
    @Override
    public String toString(){
        return this.getNom();
    }
}
