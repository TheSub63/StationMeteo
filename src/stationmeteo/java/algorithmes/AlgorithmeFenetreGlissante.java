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
public class AlgorithmeFenetreGlissante implements Algorithme{

    private Random alea;
    private float intervalle;
    
    public AlgorithmeFenetreGlissante(float intervalle){
        alea=new Random();
        this.intervalle=intervalle;
    }
    
    @Override
    public float getNewTemp(float temperature) {
        temperature=temperature+(((alea.nextFloat()*10)%intervalle-intervalle/2)*2);
        return temperature;
    }
    @Override
    public String toString(){
        return "Génération aléatoire réaliste";
    }
}
