/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.metier;

import stationmeteo.java.algorithmes.Algorithme;

/**
 *La classe permet d'instanceir des capteurs et des supercapteur sans passer
 * par le constructeur
 * @author matthias
 */
public class fabriqueCapteur {

    /**
     *Permet de fabriquer un capteur
     * @return le capteur default fabriquer
     */
    public static Icapteur fabriqueCapteur(){return new Capteur();}

    /**
     *Permet de fabriquer un SuperCapteur
     * @return le SuperCapteur default fabriquer
     */
    public static Icapteur fabriqueSuperCapteur(){return new SuperCapteur();}

    /**
     *Fabrique un capteur de base
     * @param id est l'identifaiant du capteur
     * @param nom est le nom du capteur
     * @param actualisation est le temp d'actualisation du serveur
     * @param temperature est la temperature du capteur
     * @param algo est le type Algorithme utiliser par le capteur pour chager
     * sa temperature
     * @return le capteur creé
     */
    public static Icapteur fabriqueCapteur(int id,String nom,int actualisation, float temperature, Algorithme algo)
    {
        return new Capteur(id,nom,actualisation,temperature,algo);
    }

    /**
     *Fabrique un SuperCapteur de base
     * @param id est l'identifiant du capteur
     * @param nom est le nom du capteur
     * @param capteur est le premier capteur integrer dans sa liste de capteur
     * @return le SuprCapteur creé
     */
    public static Icapteur fabriqueSuperCapteur(int id , String nom ,CapteurPoid capteur){
        return new SuperCapteur(id,nom,capteur);
    }
   
}
