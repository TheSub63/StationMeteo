/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import javafx.application.Platform;

/**
 *La classe CapteurThread permet de mettre en place un thread qui met à jour la 
 * temperature des capteurs automatiquement
 * @author matthias
 */
public class CapteurThread extends Thread implements Runnable{
    private Capteur capteurActif;

    /**
     *Constructeur de la classe CapteurThread
     * @param i : c'est un capteur, car il faut renseigner la classe du capteur à
     * implémenter
     */
    public CapteurThread(Capteur i){
        this.capteurActif=i;
    }
    
    /**
     *cette méthode met à jour la température des capteurs, elle est appelé dés 
     * que le thread est start()
     */
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

    /**
     *Getteur du Capteur Actif
     * @return le capteur que le thread actualise
     */
    public Capteur getCapteurActif() {
        return capteurActif;
    }

    /**
     *Setteur du Capteur Actif
     * @param capteurActif : le capteur que le thread actualise
     */
    public void setCapteurActif(Capteur capteurActif) {
        this.capteurActif = capteurActif;
    }
}
