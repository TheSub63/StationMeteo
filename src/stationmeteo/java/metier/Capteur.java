package stationmeteo.java.metier;

import javafx.beans.property.*;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.serialize.ICapteurSerialize;

/**
 * Classe définissant un capteur simple. Un capteur est composé des mêmes attributs qu'un Icapteur, avec en plus une propriété
 * d'actualisation, une propriété d'algorithme, une CapteurThread, et une propriété de température.
 * @author magaydu
 */
public class Capteur extends Icapteur implements ICapteurSerialize{
     
    private IntegerProperty actualisation=new SimpleIntegerProperty(this, "actualisation");
    private ObjectProperty<Algorithme> algo = new SimpleObjectProperty<>(this,"algo");
    private CapteurThread leThread= new CapteurThread(this);
    private FloatProperty temperature=new SimpleFloatProperty(this, "temperature") ;

    /**
     * Constructeur du capteur par défaut, lui associant des valeurs fixes.
     */
    public Capteur() {
        super.setId(500);
        super.setNom("default");
        setActualisation(1);
        algo.set(null);
        this.setTemperature(27);
        leThread.start();
    }

    /**
     * Constructeur de capeur pret à l'emploi. Il construit le capteur conformément à ses paramètres et démarre la thread associée.
     * @param id l'id du nouveau capteur
     * @param nom son nom
     * @param actualisation la période d'actualisation du capteur
     * @param temperature la température initiale du capteur
     * @param algo l'algorithme associé
     */
    public Capteur(int id,String nom,int actualisation, float temperature, Algorithme algo) {
        super.setId(id);
        super.setNom(nom);
        setActualisation(actualisation);
        setAlgo(algo);
        if(algo==null)this.setTemperature(temperature);
        else this.setTemperature(algo.getNewTemp(temperature));
        leThread.start();
    }

    /**
     * Getter de la thread du capteur
     * @return l'objet CapteurThread de l'instance
     */
    public CapteurThread getLeThread() {
        return leThread;
    }

    /**
     * Getter de l'algorithme du capteur
     * @return l'objet Algortihme associé.
     */
    @Override
    public Algorithme getAlgo() {
        return algo.get();
    }

    /**
     * Getter de la temperature du capteur
     * @return la propriété température associée
     */
    public FloatProperty temperatureProperty() { return this.temperature; }

    /**
     * Getter de l'actualisation du capteur
     * @return la propriété actualisation.
     */
    @Override
    public IntegerProperty actualisationProperty(){return actualisation;}

    /**
     * Getter de la propriete algorithme du capteur
     * @return la propriété algorithme.
     */
    @Override
    public ObjectProperty<Algorithme> algoProperty(){return algo;}

    /**
     * Redefinition du toString parent
     * @return une chaine de caractère contenant le nom du capteur et l'algorithme associé au capteur
     */
    @Override
    public String toString(){
        return getNom()+" "+getAlgo();
    }

    /**
     * Setter de l'algorithme
     * @param algo l'algorithme à associer.
     */
    @Override
    public void setAlgo(Algorithme algo) {
        this.algo.set(algo);
    }

    /**
     * Setter de l'actualisation
     * @param actualisation la période d'actualisation à utiliser
     */
    @Override
    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }

    /**
     * Renvoie la valeur de la propriété actualisation.
     * @return un entier en secondes
     */
    @Override
    public int getActualisation() { return actualisation.get(); }

    /**
     * Renvoie la valeur de la propriété temperature.
     * @return un reel en °C
     */
    @Override
    public float getTemperature() {
        return temperatureProperty().get();
    }
    
}
