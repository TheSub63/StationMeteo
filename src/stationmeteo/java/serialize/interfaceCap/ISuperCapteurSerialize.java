/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize.interfaceCap;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.ListCapteurPoid;

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
     *Getteur de la liste de capteur
     * @return la Liste de capteurPoid
     */
    public ListCapteurPoid getListCapteur();

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
    default public void setTemperature(float temperature){temperatureProperty().set(temperature);}
    
    /**
     *Setteur de la liste de capteur
     * @param maliste est ma nouvelle liste de CapteurPoid
     */
    public void setListCapteur(ListCapteurPoid maliste);
    
    
}