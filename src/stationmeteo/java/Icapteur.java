/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author matthias
 */
public abstract class Icapteur {
    
    //commun
    private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    private FloatProperty poids = new SimpleFloatProperty(this, "poid");
    //capteur
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    private ObjectProperty<Algorithme> algo = new SimpleObjectProperty(this,"algo");
    
    //superCapteur
    private ObjectProperty<List<Icapteur>> listCapteur=new SimpleObjectProperty<>(this,"listeCapteur");
    private FloatProperty poid = new SimpleFloatProperty(this,"poid");
    private IntegerProperty i= new SimpleIntegerProperty(this,"i");
    
    public IntegerProperty idProperty(){return id;}
    public StringProperty nomProperty(){return nom;}
    public FloatProperty temperatureProperty(){return temperature;}
    public FloatProperty poidsProperty(){return poids;}
    public IntegerProperty actualisationProperty(){return actualisation;}
    public ObjectProperty<Algorithme> algoProperty(){return algo;}
    public ObjectProperty<List<Icapteur>> listCapteurProperty(){return listCapteur;}
    public FloatProperty poidProperty(){return poid;}
    public IntegerProperty iProperty(){return i;}
    
            
    public Algorithme getAlgo() {
        return algo.get();
    }
  
   
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }
    //public abstract void setPoid(float poid);
    //public abstract void setTemperature(float temperature);
    
    
    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }
    
    public void setPoids(float poid) {
        this.poids.set(poid);
    }
    public float getPoids() {
        return poids.get();
    }
    
    
    public float getTemperature() {
        return temperature.get();
    }
    

    public void setUneTemperature(float temperature) {
        this.temperature.set(temperature);
    }
       
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }
    
       public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }
        public int getActualisation() {
        return actualisation.get();
    }
    
    

    public List<Icapteur> getListCapteur() {
        return listCapteur.get();
    }

    public void setListCapteur(List<Icapteur> listCapteur) {
        this.listCapteur.set(listCapteur);
    }

    public float getPoid() {
        return poid.get();
    }

    public void setPoid(float poid) {
        this.poid.set(poid);
    }

    public int getI() {
        return i.get();
    }

    public void setI(int i) {
        this.i.set(i);
    }
  
}
