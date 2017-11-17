/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo;

import javafx.beans.property.*;

/**
 *
 * @author magaydu
 */
public class Capteur {
    private IntegerProperty id;
    private StringProperty nom;
    private IntegerProperty actualisation;
    private IntegerProperty temperature;
    
    public Capteur(int id,String nom,int actualisation, int temperature){
        this.id.set(id);
        this.nom.set(nom);
        this.actualisation.set(actualisation);
        this.temperature.set(temperature);
        
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public int getActualisation() {
        return actualisation.get();
    }

    public void setActualisation(int actualisation) {
        this.actualisation.set(actualisation);
    }

    public int getTemperature() {
        return temperature.get();
    }

    public void setTemperature(int temperature) {
        this.temperature.set(temperature);
    }
    private final StringProperty string = new SimpleStringProperty();

    public String getString() {
        return string.get();
    }

    public void setString(String value) {
        string.set(value);
    }

    public StringProperty stringProperty() {
        return string;
    }

}
