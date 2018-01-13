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
 *
 * @author matthias
 */
public class TempBinding extends FloatBinding{

    List<CapteurPoid>maliste;
    
    public TempBinding(List<CapteurPoid> uneListe,FloatProperty temp){
        maliste=uneListe;
        {this.bind(temp);}
    }
    @Override
    protected float computeValue() {
                float Poid=0;
                float result =0;
                for(CapteurPoid c : maliste){
                    result+=c.temperatureProperty().get()*c.poidProperty().get();
                    Poid+=c.poidProperty().get();
                }
                result=result/Poid;
                return result;      
    }
    
}
