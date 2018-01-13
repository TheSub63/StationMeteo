/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.algorithmes;

import java.util.Random;

/**
 *
 * @author clguilbert
 */
public class AlgorithmeAleatoire implements Algorithme{
    private Random alea;
    
    public AlgorithmeAleatoire(){
        alea=new Random();
    }
    
    @Override
    public float getNewTemp(float temperature){
        
        temperature=alea.nextFloat()*100-50;
        return temperature;
    }
    
    @Override
    public String toString(){
        return "Génération aléatoire";
    }
}
