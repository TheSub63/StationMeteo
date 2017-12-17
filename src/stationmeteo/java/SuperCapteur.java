/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur{
    private List<Icapteur> listCapteur;
    private float poid = 0;
    private int i;
    public SuperCapteur(int id , String nom ,Icapteur capteur){
        super.setId(id);
        super.setNom(nom);
        listCapteur= new ArrayList<>();
        this.ajouter(capteur, 1f);
        this.temperatureProperty().set(0f);
        
        for(i=0;i<listCapteur.size();i++){
            this.temperatureProperty().set(this.temperatureProperty().get()+(listCapteur.get(i).getTemperature()*listCapteur.get(i).getPoid()));
            poid=listCapteur.get(i).getPoid();
        }
       this.temperatureProperty().set(this.temperatureProperty().get()/poid);
    }
    public void ajouter(Icapteur i,float poid){
        i.setUnPoid(poid);
        listCapteur.add(i);
    } 
    
    

    @Override
    public void setTemperature(float temperature) {
        
        for(i=0;i<listCapteur.size();i++){
        this.temperatureProperty().bind(this.temperatureProperty().add(listCapteur.get(i).getTemperature()*listCapteur.get(i).getPoid()));
        poid=listCapteur.get(i).getPoid();
        }
        this.temperatureProperty().bind(this.temperatureProperty().divide(poid));
        
    }
    
}
