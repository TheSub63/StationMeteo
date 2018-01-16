package stationmeteo.java.metier;

import stationmeteo.java.metier.Capteur;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Classe définissant un objet capteurPoid composé d'un capteur et d'un poids
 * @author matthias
 */
public class CapteurPoid {
    private ObjectProperty<Icapteur> monCapteur=new SimpleObjectProperty<>(this,"monCapteur");
    private FloatProperty monPoid=new SimpleFloatProperty(this,"poid");
    
    private int actualisation;

    /**
     * Constructeur par défaut de CapteurPoid
     */
    public CapteurPoid(){
        monCapteur.set(fabriqueCapteur.fabriqueCapteur());
        monPoid.set(1f);
        actualisation=1;
    }

    /**
     * Constructeur du CapteurPoid prêt à l'emploi
     * @param Uncapteur capteur à pondérer
     * @param poid poids associé au capteur
     */
    public CapteurPoid(Icapteur Uncapteur, float poid){
        monCapteur.set(Uncapteur);
        monPoid.set(poid);
        if(Uncapteur.getClass()==Capteur.class) actualisation=((Capteur) Uncapteur).getActualisation();
        else actualisation=((SuperCapteur)Uncapteur).getActualisation();
    }

    /**

     */
    public int getActualisation() {return actualisation; }

    /**
     * Setter de l'actualisation
     * @param actualisation la valeur à donner à l'attribut actualisation
     */
    public void setActualisation(int actualisation) { this.actualisation = actualisation; }

    /**
     * Getter de l'actualisation
     * @return retourne l'entier correspondant à l'actualisation
     */
    public int getActu(){
        return actualisation;
    }

    /**
     * Propriété température du capteur
     * @return la propriété température de monCapteur
     */
    public FloatProperty temperatureProperty() { return monCapteur.get().temperatureProperty(); }

    /**
     * La propriété associée au poids du capteur
     * @return la propriété monPoids
     */
    public FloatProperty poidProperty(){
        return monPoid;
    }

    /**
     * Getter du poids du capteur
     * @return Le poids réel de l'objet
     */
    public float getMonPoid() {return poidProperty().get();}

    /**
     * Setter de la propriété poids
     * @param MonPoid le poids à associer au capteur
     */
    public void setMonPoid(float MonPoid) { this.poidProperty().set(MonPoid); }

    /**
     * Getter de la propriété monCapteur
     * @return la propriété poids
     */
    public ObjectProperty<Icapteur> monCapteurProperty(){
        return monCapteur;
    }

    /**
     * Getteur du capteur à pondérer
     * @return le capteur contenu dans monCapteur
     */
    public Icapteur getMonCapteur() { return monCapteurProperty().get(); }

    /**
     * Setter du capteur à pondérer
     * @param monCapteur le capteur à pondérer
     */
    public void setMonCapteur(Icapteur monCapteur) {
        this.monCapteurProperty().set(monCapteur);
    }
}
