/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.io.Serializable;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author matthias
 */
public class CapteurPoid implements Serializable{
    private ObjectProperty<Icapteur> monCapteur=new SimpleObjectProperty(this,"monCapteur");
    private FloatProperty monPoid=new SimpleFloatProperty(this,"poid");
    
    private int actualisation;
  
    public CapteurPoid(Icapteur Uncapteur, float poid){
        monCapteur.set(Uncapteur);
        monPoid.set(poid);
        
        if(Uncapteur.getClass()==Capteur.class)
            actualisation=((Capteur) Uncapteur).getActualisation();
        else actualisation=((SuperCapteur)Uncapteur).getActualisation();
    }

    public Icapteur getMonCapteur() {
        return monCapteur.get();
    }

    public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteur.set(monCapteur);
    }
    public int getActu(){
        return actualisation;
    }
    public float getMonPoid() {
        return monPoid.get();
    }

    public void setMonPoid(float MonPoid) {
        this.monPoid.set(MonPoid);
    }

    public FloatProperty temperatureProperty() {
        
        return monCapteur.get().temperatureProperty();
    }
    public FloatProperty poidProperty(){
        return monPoid;
    }

}
