/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.ArrayList;
import java.util.List;
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
    private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private FloatProperty poids = new SimpleFloatProperty(this, "poid");
    private ObjectProperty<List<Icapteur>> listCapteur=new SimpleObjectProperty<>(this,"listeCapteur");
    private FloatProperty poid = new SimpleFloatProperty(this,"poid");
    private IntegerProperty i= new SimpleIntegerProperty(this,"i");
    private FloatBinding temp =new FloatBinding() {
        {this.bind(temperature);}
        @Override
        protected float computeValue() {
          float temp=temperature.get();
          setPoid(0);
          float result =0;
          for(int i =0;i<getListCapteur().size();i++){
            result=result+(getListCapteur().get(i).getTemperature()*getListCapteur().get(i).getPoids());
            setPoid(getPoid()+getListCapteur().get(i).getPoids());
        }
       result=result/getPoid();
       return result;
        }
    };
    
    
    public SuperCapteur(int id , String nom ,Icapteur capteur){
        super.setId(id);
        super.setNom(nom);
        super.setListCapteur(new ArrayList<>());
        this.ajouter(capteur, 1f);
        
       
    }
    public void ajouter(Icapteur i,float poid){
        i.setPoids(poid);
        super.getListCapteur().add(i);
    } 
    
    

   
    @Override
    public IntegerProperty idProperty(){return id;}
    @Override
    public StringProperty nomProperty(){return nom;}
    @Override
    public FloatProperty temperatureProperty(){return temperature;}
    @Override
    public FloatProperty poidsProperty(){return poids;}
    @Override
    public ObjectProperty<List<Icapteur>> listCapteurProperty(){return listCapteur;}
    @Override
    public FloatProperty poidProperty(){return poid;}
    @Override
    public IntegerProperty iProperty(){return i;}
    @Override
    public String getNom() {return nom.get();}
    @Override
    public void setNom(String nom) {this.nom.set(nom);}
    @Override
    public void setPoids(float poid) { this.poids.set(poid); }
    @Override
    public float getPoids() {return poids.get();}
    @Override
    public float getTemperature() {return temperature.get();}
    @Override
    public void setUneTemperature(float temperature) {
        this.temperature.set(temperature);
    }       
    @Override
    public int getId() {return id.get();}
    @Override
    public void setId(int id) {this.id.set(id);}
    @Override
    public List<Icapteur> getListCapteur() {return listCapteur.get(); }
    @Override
    public void setListCapteur(List<Icapteur> listCapteur) {
        this.listCapteur.set(listCapteur);
    }
    @Override
    public float getPoid() { return poid.get();}
    @Override
    public void setPoid(float poid) {this.poid.set(poid);}
    @Override
    public int getI() {return i.get();}
    @Override
    public void setI(int i) {this.i.set(i);}
}
