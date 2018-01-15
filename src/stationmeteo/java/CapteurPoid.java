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
public class CapteurPoid implements ICapteurPoid{
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
    public CapteurPoid(){
        monCapteur.set(new Capteur());
        monPoid.set(1f);
        actualisation=1;
    }

    @Override
    public int getActualisation() {
        return actualisation;
    }

    @Override
    public void setActualisation(int actualisation) {
        this.actualisation = actualisation;
    }

   
    public int getActu(){
        return actualisation;
    }
   
    @Override
    public ObjectProperty monCapteurProperty(){
        return monCapteur;
    }

    public FloatProperty temperatureProperty() {
        
        return monCapteur.get().temperatureProperty();
    }
    @Override
    public FloatProperty poidProperty(){
        return monPoid;
    }
      @Override public float getMonPoid() {
        return poidProperty().get();
    }

     @Override public void setMonPoid(float MonPoid) {
        this.poidProperty().set(MonPoid);
    }
     @Override public Icapteur getMonCapteur() {
        return (Icapteur) monCapteurProperty().get();
    }

     @Override public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteurProperty().set(monCapteur);
    }

}
