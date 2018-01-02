/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import javafx.application.Platform;

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
                sleep(capteurActif.getActualisation()*1000);

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                break;
            }
                if(capteurActif.getAlgo()==null) {
                    Platform.runLater(() -> this.capteurActif.setTemperature(this.capteurActif.getTemperature() - 1));
                }
                else {
                    Platform.runLater(() -> this.capteurActif.setTemperature(this.capteurActif.getAlgo().getNewTemp(capteurActif.getTemperature())));
                }
        }
    
    }

    public Capteur getCapteurActif() {
        return capteurActif;
    }

    public void setCapteurActif(Capteur capteurActif) {
        this.capteurActif = capteurActif;
    }
}
