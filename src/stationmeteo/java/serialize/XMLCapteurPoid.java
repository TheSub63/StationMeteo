/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import java.io.Serializable;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import stationmeteo.java.CapteurPoid;
import stationmeteo.java.ICapteurPoid;
import stationmeteo.java.Icapteur;

/**
 *
 * @author matthias
 */
public class XMLCapteurPoid implements ICapteurPoid,Serializable{

    
    private ObjectProperty<Icapteur> monCapteur;
    private FloatProperty monPoid;
    private int actualisation;
    private transient ICapteurPoid model;
    public XMLCapteurPoid() {
        model =new CapteurPoid();
        monCapteur=new SimpleObjectProperty(model.getMonCapteur());
        monPoid=new SimpleFloatProperty(model.getMonPoid());
        actualisation=model.getActualisation();
    }
    public XMLCapteurPoid(ICapteurPoid n){
        model=n;
        monCapteur=new SimpleObjectProperty(n.getMonCapteur());
        monPoid=new SimpleFloatProperty(n.getMonPoid());
        actualisation=n.getActualisation();
    }
    @Override
    public ObjectProperty<Icapteur> monCapteurProperty() {
        return monCapteur; 
    }

    @Override
    public FloatProperty poidProperty() {
       return monPoid;
    }
    @Override public float getMonPoid() {
        return poidProperty().get();
    }

    @Override public void setMonPoid(float MonPoid) {
        this.poidProperty().set(MonPoid);
    }
    @Override public Icapteur getMonCapteur() {
        return monCapteurProperty().get();
    }

    @Override public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteurProperty().set(monCapteur);
    }
     public ICapteurPoid getModel() {
        model = new CapteurPoid(this.getMonCapteur(),this.getMonPoid());
        return model;
    }

    @Override
    public int getActualisation() {
        return actualisation;
    }

    @Override
    public void setActualisation(int actualisation) {
        this.actualisation=actualisation;
    }

    @Override
    public FloatProperty temperatureProperty() {
        return monCapteur.get().temperatureProperty();
    }
    
}
