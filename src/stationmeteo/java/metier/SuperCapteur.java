package stationmeteo.java.metier;

import stationmeteo.java.metier.ListCapteurPoid;
import stationmeteo.java.metier.Icapteur;
import stationmeteo.java.metier.CapteurPoid;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import stationmeteo.java.serialize.interfaceCap.ISuperCapteurSerialize;

/**
 * Classe définissant un Super Capteur simple. Un Super Capteur est composé des mêmes attributs qu'un Icapteur, avec en plus une
 * Liste de capteurs pondérés, une température et un binding sur sa liste de capteurs.
 * @author matthias
 */
public class SuperCapteur extends Icapteur implements ISuperCapteurSerialize{

    private ListCapteurPoid listCapteur=new ListCapteurPoid();
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;
    private TempBinding monTempBind;
    private FloatProperty observe=new SimpleFloatProperty(this,"observe");

    /**
     * Constructeur par défaut du super capteur, lui associant des valeurs par défaut.
     */
    public SuperCapteur() {
        setId(10);
        setNom("default");
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
    }

    /**
     * Constructeur prêt à l'emploi du Super Capteur
     * @param id l'id du SuperCapteur à construire
     * @param nom le nom du SuperCapteur à construire
     * @param capteur le capteur qui servira de premier élément à la liste
     */
    public SuperCapteur(int id , String nom ,CapteurPoid capteur){
        setId(id);
        setNom(nom);
        this.getListCapteur().add(capteur);
        observe=this.listCapteur.get(0).temperatureProperty();
        monTempBind=new TempBinding(this.getListCapteur(),observe);
        temperature.bind(monTempBind);
    }

    /**
     * Fonction d'ajout à la liste de Super Capteurs
     * @param lecap
     */
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

    /**
     * Redéfiniton du toString parent
     * @return Affiche le nom est la mention du rôle du capteur.
     */
    @Override
    public String toString(){
        return this.getNom()+ " est un superCapteur";
    }

    /**
     * Getter de la propriété temperature
     * @return la propriété température du capteur
     */
    @Override
    public FloatProperty temperatureProperty(){
         return temperature;
    }

    /**
     * Getter de l'actualisation
     * @return l'actualisation du capteur de la liste le plus fréquemment actualisé
     */
    public int getActualisation(){
         int actu= listCapteur.get(0).getActu();
         for(CapteurPoid c: listCapteur){
            if(actu>= c.getActu()) actu= c.getActu();
         }
        return actu;
    }

    /**
     * Getter de la valeur de la température
     * @return la température contenue dans la propriete temperatureProperty.
     */
    @Override
    public float getTemperature() {
        return temperatureProperty().get();
    }

    /**
     * Getter de la liste de capteurs de l'objet
     * @return la liste des sous capteurs du SuperCapteur
     */
    @Override
    public ListCapteurPoid getListCapteur() {
        return listCapteur;
    }

    /**
     * Setteur de la liste de capteur
     * @param maliste est ma nouvelle liste de CapteurPoid
     */
    @Override
    public void setListCapteur(ListCapteurPoid maliste) {
        listCapteur=maliste;
    }

    /**
     * Setteur de la temperature du capteur
     * @param temperature est la nouvelle temperature du capteur
     */
    @Override public void setTemperature(float temperature){ 
        temperatureProperty().set(temperature);
    }
}
