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
import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import stationmeteo.java.serialize.ISuperCapteurSerialize;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur implements ISuperCapteurSerialize{
    //superCapteur
    private ObjectProperty<List<CapteurPoid>> listCapteur=new SimpleObjectProperty(this,"listCapteur");
    //private IntegerProperty i= new SimpleIntegerProperty(this,"i");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
  
    private FloatBinding temp= new FloatBinding() {
            {super.bind(temperatureProperty(),listCapteur);}
          
            @Override
            protected float computeValue() {
                float Poid=0;
                float result =0;
                for(int i =0;i<listCapteurProperty().get().size();i++){
                    result=result+(getListCapteur().get(i).temperatureProperty().get()*getListCapteur().get(i).PoidProperty().get());
                    Poid=Poid+getListCapteur().get(i).PoidProperty().get();
                }
                result=result/Poid;
                return result;
            }
        };
    
    
    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        
        setId(id);
        setNom(nom);
        
        this.setListCapteur(new ArrayList());
        this.getListCapteur().add(capteur);
      temperatureProperty().bind(temp);
       // temperature.bind(temp);
       System.out.println(this.getNom()+" est un super capteur");
    }
    
    public SuperCapteur() {
        
         setId(10);
        setNom("default");
        this.setListCapteur(new ArrayList());
       // temperature.bind(temp);
       System.out.println(this.getNom()+" est un super capteur");//To change body of generated methods, choose Tools | Templates.
    }
    public void ajouter(CapteurPoid lecap){
       getListCapteur().add(lecap);
    } 
      
    @Override
    public String toString(){
        return this.getNom()+ " est un superCapteur";
    }
    @Override
     public FloatProperty temperatureProperty(){
         
         //temperature.bind(temp);
         return temperature;
     }
    @Override
    public ObjectProperty<List<CapteurPoid>> listCapteurProperty(){return listCapteur;}
    @Override
    public List<CapteurPoid> getListCapteur(){return listCapteur.get();}
    @Override
    public void setListCapteur(List<CapteurPoid>maliste){listCapteur.set(maliste);}
}
