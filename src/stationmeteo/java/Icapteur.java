package stationmeteo.java;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe abstraite mère des classes Capteur et SuperCapteur.
 * @author matthias
 */
public abstract class Icapteur {
    
    //commun
    private IntegerProperty id=new SimpleIntegerProperty(this, "id");
    private StringProperty nom=new SimpleStringProperty(this, "nom");

    public abstract FloatProperty temperatureProperty();
    public abstract float getTemperature();

    /**
     * Getter de l'id
     * @return l'integerProperty id
     */
    public IntegerProperty idProperty(){return id;}
    /**
     * Getter du nom
     * @return la StringProperty nom
     */
    public StringProperty nomProperty(){return nom;}

    /**
     * Getter de la valeur du nom
     * @return le nom du capteur
     */
    public String getNom() {
        return nom.get();
    }

    /**
     * Setter du nom
     * @param nom le nom à associer au capteur
     */
    public void setNom(String nom) { this.nom.set(nom); }

    /**
     * Getter de la valeur de l'id
     * @return l'id du capteur
     */
    public int getId() { return id.get(); }

    /**
     * Setter de l'id
     * @param id l'id à associer au capteur
     */
    public void setId(int id) {
        this.id.set(id);
    }

}
