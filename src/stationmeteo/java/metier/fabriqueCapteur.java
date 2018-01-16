/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.metier;

import stationmeteo.java.algorithmes.Algorithme;

/**
 *
 * @author matthias
 */
public class fabriqueCapteur {
    public static Icapteur fabriqueCapteur(){return new Capteur();}
    public static Icapteur fabriqueSuperCapteur(){return new SuperCapteur();}
    public static Icapteur fabriqueCapteur(int id,String nom,int actualisation, float temperature, Algorithme algo)
    {
        return new Capteur(id,nom,actualisation,temperature,algo);
    }
    public static Icapteur fabriqueSuperCapteur(int id , String nom ,CapteurPoid capteur){
        return new SuperCapteur(id,nom,capteur);
    }
   
}
