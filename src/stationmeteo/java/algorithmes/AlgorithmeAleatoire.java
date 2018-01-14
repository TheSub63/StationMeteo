package stationmeteo.java.algorithmes;

import java.util.Random;

/**
 * Classe d'Algorithme offrant au capteur un comportement aléatoire.
 * @author clguilbert
 */
public class AlgorithmeAleatoire implements Algorithme{

    private Random alea;

    /**
     * Constructeur de l'Algorithme Aleatoire, associant au comportement un générateur aléatoire.
     */
    public AlgorithmeAleatoire(){
        alea=new Random();
    }

    /**
     * Redefinition de la méthode permettant d'obtenir la température. Ici l'ancienne température est remplacée par une
     * valeur réelle aléatoire entre -50 et 50.
     * @param temperature L'ancienne température du capteur
     * @return la nouvelle température aléatoire du capteur
     */
    @Override
    public float getNewTemp(float temperature){
        temperature=alea.nextFloat()*100-50;
        return temperature;
    }

    /**
     * La redéfinition de la méthode toString d'algorithme, indiquant le nom de l'algorithme utilisé
     * @return le nom de l'algorithme utilisé
     */
    @Override
    public String toString(){
        return "Génération aléatoire";
    }
}
