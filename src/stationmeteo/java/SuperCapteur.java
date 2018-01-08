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

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur{
    /*private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    
    private ObjectProperty<List<CapteurPoid>> listCapteur=new SimpleObjectProperty<>(this,"listeCapteur");
    private IntegerProperty i= new SimpleIntegerProperty(this,"i");*/
    private FloatBinding temp =new FloatBinding() {
        {this.bind(temperatureProperty());}
        @Override
        protected float computeValue() {
          float temp=temperatureProperty().get();
          float Poid=0;
          float result =0;
          for(int i =0;i<getListCapteur().size();i++){
            result=result+(getListCapteur().get(i).getMonCapteur().getTemperature()*getListCapteur().get(i).getMonPoid());
            Poid=Poid+getListCapteur().get(i).getMonPoid();
        }
       result=result/Poid;
       return result;
        }
    };
    
    
    public SuperCapteur(int id , String nom ,Icapteur capteur){
        setId(id);
        setNom(nom);
        setListCapteur(new ArrayList<>());
        this.ajouter(capteur, 1f);
        
       System.out.println(this.getNom()+" est un super capteur");
    }
    public void ajouter(Icapteur i,float poid){
        CapteurPoid lecap=new CapteurPoid(i,poid);
        super.getListCapteur().add(lecap);
    } 
    @Override
    public String toString(){
        return this.getNom()+ "est un superCapteur";
    }
    

   
    /*@Override
    public IntegerProperty idProperty(){return id;}
    @Override
    public StringProperty nomProperty(){return nom;}
    @Override
    public FloatProperty temperatureProperty(){return temperature;}
   
    

    @Override
    public IntegerProperty iProperty(){return i;}
    @Override
    public String getNom() {return nom.get();}
    @Override
    public void setNom(String nom) {this.nom.set(nom);}
    
    
    @Override
    public float getTemperature() {return temperature.get();}
      
    @Override
    public int getId() {return id.get();}
    @Override
    public void setId(int id) {this.id.set(id);}
    @Override
    public List<CapteurPoid> getListCapteur() {return listCapteur.get(); }
    @Override
    public void setListCapteur(List<CapteurPoid> listCapteur) {
        this.listCapteur.set(listCapteur);
    }
    
    @Override
    public int getI() {return i.get();}
    @Override
    public void setI(int i) {this.i.set(i);}*/
}
