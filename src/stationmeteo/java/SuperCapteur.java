package stationmeteo.java;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import stationmeteo.java.serialize.ISuperCapteurSerialize;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur implements ISuperCapteurSerialize{
    //superCapteur
    private ObjectProperty<List<CapteurPoid>> listCapteur=new SimpleObjectProperty<>(this,"listCapteur");
    //private IntegerProperty i= new SimpleIntegerProperty(this,"i");
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private TempBinding monTempBind;
    private FloatProperty observe=new SimpleFloatProperty(this,"observe");
    //private int actualisation;
    @SuppressWarnings("WeakerAccess")
    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        
        setId(id);
        setNom(nom);
        
        this.setListCapteur(new ArrayList<>());
        this.getListCapteur().add(capteur);
        observe=this.listCapteur.get().get(0).temperatureProperty();
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
       // temperature.bind(temp);
       System.out.println(this.getNom()+" est un super capteur");
    }
    @SuppressWarnings("WeakerAccess")
    public SuperCapteur() {
        
         setId(10);
        setNom("default");

        this.setListCapteur(new ArrayList());
         Platform.runLater(() ->monTempBind=new TempBinding(this.getListCapteur(),this.listCapteur.get().get(0).temperatureProperty()));

        this.setListCapteur(new ArrayList<>());
        monTempBind=new TempBinding(this.getListCapteur(),this.listCapteur.get().get(0).temperatureProperty());

      
        temperatureProperty().bind(monTempBind);
       // temperature.bind(temp);
       System.out.println(this.getNom()+" est un super capteur");//To change body of generated methods, choose Tools | Templates.
    }
    @SuppressWarnings("WeakerAccess")
    public void ajouter(CapteurPoid lecap){
       getListCapteur().add(lecap);
       int actu=listCapteur.get().get(0).getActu();
       for(CapteurPoid c : listCapteur.get()){
           if(c.getActu()<=actu){
             actu=c.getActu();
             observe=c.temperatureProperty();
           }
       
       }
    } 
      
    @Override
    public String toString(){
        return this.getNom()+ " est un superCapteur";
    }
    @SuppressWarnings("WeakerAccess")
    @Override
     public FloatProperty temperatureProperty(){
         return temperature;
     }
     int getActualisation(){
         int actu=listCapteur.get().get(0).getActu();
         for(CapteurPoid c: listCapteur.get()){
            if(actu>=c.getActu()) actu=c.getActu();
         }
        return actu;
     }

    @Override
    public ObjectProperty<List<CapteurPoid>> listCapteurProperty(){return listCapteur;}

    @Override
    public float getTemperature() {
        return temperatureProperty().get();
    }
}
