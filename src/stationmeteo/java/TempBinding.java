/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.List;
import javafx.beans.binding.FloatBinding;
import javafx.beans.property.FloatProperty;

/**
 *La classe qui permet de calculer et de mettre à jour la temperature du
 * supercapteur
 * @author matthias
 */
public class TempBinding extends FloatBinding{

    List<CapteurPoid>maliste;
    
    /**
     *Constructeur de la classe qui met en place la liste et les dependances
     * @param uneListe est la liste de capteur poid
     * @param temp est la propriété observé pour le changement
     */
    public TempBinding(List<CapteurPoid> uneListe,FloatProperty temp){
        maliste=uneListe;
        {this.bind(temp);}
    }

    /**
     *La methode permet de calculer la temperature en question, elle est appelée
     * à chaque fois que l'on observe un changement dans les dépendances.
     * @return result :la temperature une fois calculé
     */
    @Override
    protected float computeValue() {
                float Poid=0;
                float result =0;
                for(ICapteurPoid c : maliste){
                    result+=((CapteurPoid)c).temperatureProperty().get()*c.poidProperty().get();
                    Poid+=c.poidProperty().get();
                }
                result=result/Poid;
                return result;      
    }
    
}
