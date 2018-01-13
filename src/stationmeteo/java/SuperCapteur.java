/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.ListView;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur{
    //superCapteur
    private ObjectProperty<List<CapteurPoid>> listCapteur=new SimpleObjectProperty<>(this,"listeCapteur");
    private IntegerProperty i= new SimpleIntegerProperty(this,"i");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private FloatBinding temp =new FloatBinding() {
        {this.bind(temperature.asObject());}
        @Override
        protected float computeValue() {
          float Poid=0;
          float result =0;
          for(int i =0;i<listCapteur.get().size();i++){
            result=result+(listCapteur.get().get(i).getMonCapteur().temperatureProperty().get()*listCapteur.get().get(i).getMonPoid());
            Poid=Poid+listCapteur.get().get(i).getMonPoid();
        }
       result=result/Poid;
       return result;
        }
    };
    @Override
     public FloatProperty temperatureProperty(){
         return temperature;
     }
    
    
    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        setId(id);
        setNom(nom);
        setListCapteur(new ArrayList<CapteurPoid>());
        getListCapteur().add(capteur);
       // temperatureProperty().bind(temp);
       System.out.println(this.getNom()+" est un super capteur");
    }
    public void ajouter(CapteurPoid lecap){
       getListCapteur().add(lecap);
    } 
    @Override
    public String toString(){
        return this.getNom()+ " est un superCapteur";
    }
    
 
    public ObjectProperty<List<CapteurPoid>> listCapteurProperty(){return listCapteur;}
   
    public IntegerProperty iProperty(){return i;}
   
   public List<CapteurPoid> getListCapteur() {
        return listCapteur.get();
    }

    public void setListCapteur(List<CapteurPoid> listCapteur) {
        this.listCapteur.set(listCapteur);
    }

    public int getI() {
        return i.get();
    }

    public void setI(int i) {
        this.i.set(i);
    }
}
