package stationmeteo.java;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author matthias
 */
public class CapteurPoid{
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

    public int getActualisation() {
        return actualisation;
    }

    public void setActualisation(int actualisation) {
        this.actualisation = actualisation;
    }

   
    public int getActu(){
        return actualisation;
    }

    public ObjectProperty monCapteurProperty(){
        return monCapteur;
    }

    public FloatProperty temperatureProperty() {
        
        return monCapteur.get().temperatureProperty();
    }

    public FloatProperty poidProperty(){
        return monPoid;
    }
    public float getMonPoid() {
        return poidProperty().get();
    }

public void setMonPoid(float MonPoid) {
        this.poidProperty().set(MonPoid);
    }
    public Icapteur getMonCapteur() {
        return (Icapteur) monCapteurProperty().get();
    }

     public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteurProperty().set(monCapteur);
    }

}
