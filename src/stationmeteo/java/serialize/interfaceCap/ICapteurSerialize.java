/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize.interfaceCap;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *Interface qui permet de mettre en place un composite entre la classe Capteur
 * et la class XMLCapteur
 * @author matthias
 */
public interface ICapteurSerialize  {
    
    /**
     *Getteur de l'idProperty
     * @return l'IntegerProperty id
     */
    public IntegerProperty idProperty();

    /**
     *Getteur du nomProperty
     * @return le StringProperty nom
     */
    public StringProperty nomProperty();

    /**
     *Getteur de la temperatureProperty
     * @return le floatProperty temperature
     */
    public FloatProperty temperatureProperty();

    /**
     *Getteur de l'actualisationProperty
     * @return l'IntegerProperty actualisation
     */
    public IntegerProperty actualisationProperty();

    /**
     *Getteur de algoProperty
     * @return l'ObjectProperty algo
     */
    public ObjectProperty<Algorithme> algoProperty();

    /**
     *Getteur de l'id
     * @return l'id du capteur
     */
    default public int getId(){return idProperty().get();}

    /**
     *Getteur du nom du capteur
     * @return le nom du capteur
     */
    default public String getNom(){return nomProperty().get();}

    /**
     *Getteur de la temperature du capteur
     * @return la temperature du capteur
     */
    default public float getTemperature(){return temperatureProperty().get();}

    /**
     *Getteur de l'actualisation du capteur
     * @return le temps d'actualisation du capteur
     */
    default public int getActualisation(){return actualisationProperty().get();}

    /**
     *Getteur de l'Algorithme du capteur
     * @return l'Algorithme du capteur
     */
    default public Algorithme getAlgo(){return algoProperty().get();}
    
    /**
     *Setteur de l'id du capteur
     * @param id est la nouvelle id du capteur
     */
    default public void setId(int id){idProperty().set(id);}
    /**
     *Setteur du nom du capteur
     * @param nom est le nouveaux nom du capteur
     */
    default public void setNom(String nom){nomProperty().set(nom);}
    /**
     *Setteur de la temperature du capteur
     * @param temperature est la nouvelle temperature du capteur
     */
    default public void setTemperature(float temperature){ temperatureProperty().set(temperature);}
    /**
     *Setteur de l'actualisation du capteur
     * @param actu est le nouveau temps d'actualisation du capteur
     */
    default public void setActualisation(int actu){actualisationProperty().set(actu);}

    /**
     *Setteur de l'Algorithme du capteur
     * @param algo est le nouvelle Algorithme du capteur
     */
    default public void setAlgo(Algorithme algo){algoProperty().set(algo);}
}
