/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.metier.ListCapteurPoid;

/**
 *Interface qui permet de mettre en place un composite entre la classe SuperCapteur
 * et la class XMLSuperCapteur
 * @author matthias
 */
public interface ISuperCapteurSerialize {
    /**
     *Getteur de l'idProperty
     * @return l'IntegerProperty id
     */
    IntegerProperty idProperty();
    /**
     *Getteur du nomProperty
     * @return le StringProperty nom
     */
    StringProperty nomProperty();
     /**
     *Getteur de la temperatureProperty
     * @return le floatProperty temperature
     */
     FloatProperty temperatureProperty();
    
    /**
     *Getteur de la liste de capteur
     * @return la Liste de capteurPoid
     */
    ListCapteurPoid getListCapteur();

      /**
     *Getteur de l'id
     * @return l'id du capteur
     */
    default int getId(){return idProperty().get();}
    /**
     *Getteur du nom du capteur
     * @return le nom du capteur
     */
    default String getNom(){return nomProperty().get();}
    /**
     *Getteur de la temperature du capteur
     * @return la temperature du capteur
     */
    default float getTemperature(){return temperatureProperty().get();}
    
  
    /**
     *Setteur de l'id du capteur
     * @param id est la nouvelle id du capteur
     */
    default void setId(int id){idProperty().set(id);}
    /**
     *Setteur du nom du capteur
     * @param nom est le nouveaux nom du capteur
     */
    default void setNom(String nom){nomProperty().set(nom);}
    /**
     *Setteur de la temperature du capteur
     * @param temperature est la nouvelle temperature du capteur
     */
    default void setTemperature(float temperature){temperatureProperty().set(temperature);}
    
    /**
     *Setteur de la liste de capteur
     * @param maliste est ma nouvelle liste de CapteurPoid
     */
    void setListCapteur(ListCapteurPoid maliste);
    
    
}