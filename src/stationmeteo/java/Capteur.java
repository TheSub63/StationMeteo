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
     
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    private ObjectProperty<Algorithme> algo = new SimpleObjectProperty(this,"algo");
    private CapteurThread leThread= new CapteurThread(this);
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    public Capteur(int id,String nom,int actualisation, float temperature, Algorithme algo) {
        //Thread test = new Thread();
        super.setId(id);
        super.setNom(nom);
        setActualisation(actualisation);
        setAlgo(algo);
        if(algo==null)this.setTemperature(temperature);
        else this.setTemperature(algo.getNewTemp(temperature));
        leThread.start();
        
    }
    public Capteur() {
        super.setId(500);
        super.setNom("default");
        setActualisation(1);
        algo.set(null);
        this.setTemperature(27);
        
        leThread.start();
    }
 
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

    

    @Override
    public IntegerProperty actualisationProperty(){return actualisation;}
    @Override
    public ObjectProperty<Algorithme> algoProperty(){return algo;}
    @Override
    public Algorithme getAlgo() {
        return algo.get();
    }
  
   
    @Override
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }
    @Override
    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }
    @Override
    public int getActualisation() {
        return actualisation.get();
    }

    @Override
    public FloatProperty temperatureProperty() {
        return this.temperature;//To change body of generated methods, choose Tools | Templates.
    }
    
}
