/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;


import javafx.beans.property.*;
import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author magaydu
 */
public class Capteur extends Icapteur{
    
    //private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    //private StringProperty nom=new SimpleStringProperty(this, "nom");
    
    //private FloatProperty temperature=new SimpleFloatProperty(this, "temperature");
    
    private CapteurThread leThread= new CapteurThread(this);
    //private FloatProperty Poid = new SimpleFloatProperty(this, "poid");
    
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
    public void setTemperature(float temperature) {
        super.setUneTemperature(temperature); //To change body of generated methods, choose Tools | Templates.
    }
    
}
