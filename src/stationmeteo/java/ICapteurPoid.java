/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.Icapteur;

/**
 *
 * @author matthias
 */
public interface ICapteurPoid {
    public ObjectProperty<Icapteur> monCapteurProperty();
    public FloatProperty poidProperty();
    public int getActualisation();
    public void setActualisation(int actualisation);
    public FloatProperty temperatureProperty();
    default public float getMonPoid() {
        return poidProperty().get();
    }

    default public void setMonPoid(float MonPoid) {
        this.poidProperty().set(MonPoid);
    }
    default public Icapteur getMonCapteur() {
        return monCapteurProperty().get();
    }

    default public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteurProperty().set(monCapteur);
    }
}
