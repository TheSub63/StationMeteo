package stationmeteo.java;

import java.util.LinkedList;
import java.util.List;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import stationmeteo.java.serialize.ISuperCapteurSerialize;

/**
 *
 * @author matthias
 */
public class SuperCapteur extends Icapteur implements ISuperCapteurSerialize{

    private List<ICapteurPoid> listCapteur=new LinkedList();
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private TempBinding monTempBind;
    private FloatProperty observe=new SimpleFloatProperty(this,"observe");
<<<<<<< HEAD
    
    @SuppressWarnings("WeakerAccess")
    public SuperCapteur(int id , String nom ,ICapteurPoid capteur){
=======
    //private int actualisation;
    
    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        
>>>>>>> 57d58d1a16a6a905740d2f9edc2da8dd07d86423
        setId(id);
        setNom(nom);
        this.getListCapteur().add(capteur);
        observe=this.listCapteur.get(0).temperatureProperty();
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
       System.out.println(this.getNom()+" est un super capteur");
    }
<<<<<<< HEAD
    @SuppressWarnings("WeakerAccess")
    public SuperCapteur() {   
        setId(10);
        setNom("default");
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
=======
    
    public SuperCapteur() {
        
         setId(10);
        setNom("default");
        this.setListCapteur(new ArrayList<>());
        monTempBind=new TempBinding(this.getListCapteur(),this.listCapteur.get().get(0).temperatureProperty());
      
>>>>>>> 57d58d1a16a6a905740d2f9edc2da8dd07d86423
        temperatureProperty().bind(monTempBind);
       System.out.println(this.getNom()+" est un super capteur");
    }
    public void ajouter(CapteurPoid lecap){
       getListCapteur().add(lecap);
       int actu=((CapteurPoid)listCapteur.get(0)).getActu();
       for(ICapteurPoid c : listCapteur){
           if(((CapteurPoid) c).getActu()<=actu){
             actu=((CapteurPoid) c).getActu();
             observe=((CapteurPoid) c).temperatureProperty();
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
     int getActualisation(){
         int actu=((CapteurPoid)listCapteur.get(0)).getActu();
         for(ICapteurPoid c: listCapteur){
            if(actu>=((CapteurPoid)c).getActu()) actu=((CapteurPoid)c).getActu();
         }
        return actu;
     }
    @Override
    public float getTemperature() {
        return temperatureProperty().get();
    }

    @Override
    public List<ICapteurPoid> getListCapteur() {
        return listCapteur;
    }
    @Override
    public void setListCapteur(List<ICapteurPoid> maliste) {
        listCapteur=maliste;
    }
}
