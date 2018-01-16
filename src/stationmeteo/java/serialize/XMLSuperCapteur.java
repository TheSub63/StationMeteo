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
 *
 * @author matthias
 */
public class XMLSuperCapteur implements Serializable,ISuperCapteurSerialize{
    private IntegerProperty id;
    private StringProperty nom;
    private FloatProperty temperature; 
    private ObjectProperty<ListCapteurPoid> listCapteur;
    private transient ISuperCapteurSerialize model;
    public XMLSuperCapteur() {
        model = new SuperCapteur();
        id = new SimpleIntegerProperty(model.getId());
        nom = new SimpleStringProperty(model.getNom());
        temperature = new SimpleFloatProperty(model.getTemperature());
        listCapteur=new SimpleObjectProperty(model.getListCapteur());
   
    }
     public XMLSuperCapteur(ISuperCapteurSerialize n) {
        model = n;
        id = new SimpleIntegerProperty(n.getId());
        nom = new SimpleStringProperty(n.getNom());
        temperature = new SimpleFloatProperty(n.getTemperature());
        listCapteur=new SimpleObjectProperty(n.getListCapteur());
        
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
    
    public ISuperCapteurSerialize getModel() {
        
        model = new SuperCapteur(this.getId(),this.getNom(),this.listCapteur.get().get(0));
        /*for (int i=1;i<this.listCapteur.get().size();i++){
            model.getListCapteur().add(this.listCapteur.get().get(i));
        }*/
        return model;
    }
    @Override
    public String toString(){
        return this.getNom();
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

    @Override
    public void setListCapteur(ListCapteurPoid maliste){
        listCapteur.set(maliste);
    }

    @Override
    public ListCapteurPoid getListCapteur() {
        return listCapteur.get();
    }

   
}
