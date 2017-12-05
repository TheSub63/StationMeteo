/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author matthias
 */
public class CapteurThread extends Thread implements Runnable{
    private Capteur capteurActif;
    public CapteurThread(Capteur i){
        this.capteurActif=i;
    }
    
     @Override
    public void run(){
        while(true){
            try {
                this.sleep(capteurActif.getActualisation()*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CapteurThread.class.getName()).log(Level.SEVERE, null, ex);
            }
                this.capteurActif.setTemperature(this.capteurActif.getTemperature()-1);
                System.out.println("le thread s'execute\n");
        
        }
    
    }

    public Capteur getCapteurActif() {
        return capteurActif;
    }

    public void setCapteurActif(Capteur capteurActif) {
        this.capteurActif = capteurActif;
    }
}
