/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import java.io.Serializable;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.ListCapteurPoid;
import stationmeteo.java.SuperCapteur;

/**
 *Classe qui permet la serialization des SuperCapteurs
 * @author matthias
 */
public class XMLSuperCapteur implements Serializable,ISuperCapteurSerialize{
    private IntegerProperty id;
    private StringProperty nom;
    private FloatProperty temperature; 
    private ObjectProperty<ListCapteurPoid> listCapteur;
    private transient ISuperCapteurSerialize model;
    /**
     *Constructeur par default de XMLSuperCapteur, il permet de creer un XMLSuperCapteur
     * par default
     */
    public XMLSuperCapteur() {
        model = new SuperCapteur();
        id = new SimpleIntegerProperty(model.getId());
        nom = new SimpleStringProperty(model.getNom());
        temperature = new SimpleFloatProperty(model.getTemperature());
        listCapteur=new SimpleObjectProperty(model.getListCapteur());
   
    }
    /**
     *Constructeur de XMLSuperCapteur, il permet de creer un XMLSuperCapteur à partir des
     * classes implementées par ISuperCapteurSerialize
     * @param n est l'objet de la classe implementé par ISuperCapteurSerialize
     */
     public XMLSuperCapteur(ISuperCapteurSerialize n) {
        model = n;
        id = new SimpleIntegerProperty(n.getId());
        nom = new SimpleStringProperty(n.getNom());
        temperature = new SimpleFloatProperty(n.getTemperature());
        listCapteur=new SimpleObjectProperty(n.getListCapteur());
        
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
     *Permet de donner le modele utiliser par XMLSuperCapteur pour se creer
     * @return l'objet implementer par ISuperCapteurSerialize
     */
    public ISuperCapteurSerialize getModel() {
        model = new SuperCapteur(this.getId(),this.getNom(),this.listCapteur.get().get(0));
        return model;
    }
    /**
     *Cette callse permet de convertir l'Objet XMLCapteur en String
     * @return la conversion de l'objet XMLCapteur en string
     */
    @Override
    public String toString(){
        return this.getNom();
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
     *Setteur de la liste de capteur
     * @param maliste est ma nouvelle liste de CapteurPoid
     */
    @Override
    public void setListCapteur(ListCapteurPoid maliste){
        listCapteur.set(maliste);
    }
    /**
     *Getteur de la liste de capteur
     * @return la Liste de capteurPoid
     */
    @Override
    public ListCapteurPoid getListCapteur() {
        return listCapteur.get();
    }

   
}
