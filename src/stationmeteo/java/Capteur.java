/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;


import javafx.beans.property.*;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.serialize.ICapteurSerialize;

/**
 *
 * @author magaydu
 */
public class Capteur extends Icapteur implements ICapteurSerialize{
    
    /*private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    
    private FloatProperty poids = new SimpleFloatProperty(this, "poids");
    private ObjectProperty<Algorithme> algo = new SimpleObjectProperty(this,"algo");*/
    private CapteurThread leThread= new CapteurThread(this);
    public Capteur(int id,String nom,int actualisation, float temperature, Algorithme algo) {
        //Thread test = new Thread();
        super.setId(id);
        super.setNom(nom);
        super.setActualisation(actualisation);
        super.setAlgo(algo);
        if(algo==null)this.setTemperature(temperature);
        else this.setTemperature(algo.getNewTemp(temperature));
        leThread.start();
        
    }
    public Capteur() {
        super.setId(500);
        super.setNom("default");
        super.setActualisation(1);
        super.setAlgo(null);
        this.setTemperature(27);
        
        leThread.start();
    }
    /*@Override
    public IntegerProperty idProperty(){return id;}
    @Override
    public StringProperty nomProperty(){return nom;}
    @Override
    public FloatProperty temperatureProperty(){return temperature;}
    
    @Override
    public IntegerProperty actualisationProperty(){return actualisation;}
    @Override
    public ObjectProperty<Algorithme> algoProperty(){return algo;}*/
    public CapteurThread getLeThread() {
        return leThread;
    }

    public void setLeThread(CapteurThread leThread) {
        this.leThread = leThread;
    }
    
    
    @Override
    public String toString(){
        return getNom()+" "+getAlgo();
    }

   

   
    
}
