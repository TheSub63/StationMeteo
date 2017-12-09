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
public class AlgorithmeAleatoireFixe implements Algorithme{
    private Random alea;
    private float min, max;
    
    public AlgorithmeAleatoireFixe(float min, float max){
        alea=new Random();
        this.min=min;
        this.max=max;
    }
    
    @Override
    public float getNewTemp(float temperature) {
        temperature=(min+alea.nextFloat()*10)%max;
        return temperature;
    }
    
    @Override
    public String toString(){
        return "Génération aléatoire Bornée";
    }
    
}
