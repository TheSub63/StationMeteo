/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur{
   
    public SuperCapteur(int id , String nom ,Icapteur capteur){
        super.setId(id);
        super.setNom(nom);
        super.setListCapteur(new ArrayList<>());
        this.ajouter(capteur, 1f);
        this.temperatureProperty().set(0f);
        super.setPoid(0);
        for(super.setI(0);super.getI()<super.getListCapteur().size();super.setI(super.getI()+1)){
            this.temperatureProperty().set(this.temperatureProperty().get()+(super.getListCapteur().get(super.getI()).getTemperature()*super.getListCapteur().get(super.getI()).getPoids()));
            super.setPoid(super.getPoid()+super.getListCapteur().get(super.getI()).getPoids());
        }
       this.temperatureProperty().set(this.temperatureProperty().get()/super.getPoid());
    }
    public void ajouter(Icapteur i,float poid){
        i.setUnPoid(poid);
        super.getListCapteur().add(i);
    } 
    
    

    @Override
    public void setTemperature(float temperature) {
        for(super.setI(0);super.getI()<super.getListCapteur().size();super.setI(super.getI()+1)){
            this.temperatureProperty().set(this.temperatureProperty().get()+(super.getListCapteur().get(super.getI()).getTemperature()*super.getListCapteur().get(super.getI()).getPoids()));
            super.setPoid(super.getPoid()+super.getListCapteur().get(super.getI()).getPoids());
        }
       this.temperatureProperty().set(this.temperatureProperty().get()/super.getPoid());  
    }
    
}
