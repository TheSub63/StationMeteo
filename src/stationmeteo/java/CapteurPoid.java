/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

/**
 *
 * @author matthias
 */
public class CapteurPoid extends Icapteur {
    private Icapteur monCapteur;
    private FloatProperty MonPoid=new SimpleFloatProperty(this,"poid");
    
    public CapteurPoid(Icapteur Uncapteur){
        monCapteur= Uncapteur;
        MonPoid.set(1);
    }
    public CapteurPoid(Icapteur Uncapteur, float poid){
        monCapteur= Uncapteur;
        MonPoid.set(poid);
    }

    public Icapteur getMonCapteur() {
        return monCapteur;
    }

    public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteur = monCapteur;
    }

    public float getMonPoid() {
        return MonPoid.get();
    }

    public void setMonPoid(float MonPoid) {
        this.MonPoid.set(MonPoid);
    }

    @Override
    public FloatProperty temperatureProperty() {
        return null;
    }
}
