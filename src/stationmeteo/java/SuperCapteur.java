package stationmeteo.java;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import stationmeteo.java.serialize.interfaceCap.ISuperCapteurSerialize;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur implements ISuperCapteurSerialize{

    private ListCapteurPoid listCapteur=new ListCapteurPoid();
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private TempBinding monTempBind;
    private FloatProperty observe=new SimpleFloatProperty(this,"observe");

    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        setId(id);
        setNom(nom);
        this.getListCapteur().add(capteur);
        observe=this.listCapteur.get(0).temperatureProperty();
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
    }

    public SuperCapteur() {   
        setId(10);
        setNom("default");
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
    }
    public void ajouter(CapteurPoid lecap){
       getListCapteur().add(lecap);
       int actu= listCapteur.get(0).getActu();
       for(CapteurPoid c : listCapteur){
           if(c.getActu()<=actu){
             actu= c.getActu();
             observe= c.temperatureProperty();
           }
       }
    } 
      
    @Override
    public String toString(){
        return this.getNom()+ " est un superCapteur";
    }
    @Override
    public FloatProperty temperatureProperty(){
         return temperature;
    }
    public int getActualisation(){
         int actu= listCapteur.get(0).getActu();
         for(CapteurPoid c: listCapteur){
            if(actu>= c.getActu()) actu= c.getActu();
         }
        return actu;
     }
    @Override
    public float getTemperature() {
        return temperatureProperty().get();
    }
    @Override
    public ListCapteurPoid getListCapteur() {
        return listCapteur;
    }
    @Override
    public void setListCapteur(ListCapteurPoid maliste) {
        listCapteur=maliste;
    }
    @Override public void setTemperature(float temperature){ 
        temperatureProperty().set(temperature);
    }
}
