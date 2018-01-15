package stationmeteo.java.algorithmes;

import java.util.Random;

/**
 * Classe d'Algorithme offrant au capteur un comportement aléatoire, dans un intervalle borné fixé par l'utilisateur.
 * @author clguilbert
 */
public class AlgorithmeAleatoireFixe implements Algorithme{
    private Random alea;
    private float min, max;

    /**
     * Constructeur d'Algorithme aléatoire Fixe définissant l'intervalle.
     * @param min Borne minimale de l'intervalle
     * @param max Borne maximale de l'intervalle
     */
    public AlgorithmeAleatoireFixe(float min, float max){
        alea=new Random();
        this.min=min;
        this.max=max;
    }

    /**
     * Redefinition de la méthode permettant d'obtenir la température. Ici l'ancienne température est remplacée par une
     * valeur réelle aléatoire entre les bornes de l'intervalle spécifié.
     * @param temperature L'ancienne température du capteur
     * @return La température modifiée par l'Algorithme
     */
    @Override
    public float getNewTemp(float temperature) {
        temperature=min+alea.nextFloat()*(max-min);
        return temperature;
    }

    /**
     * La redéfinition de la méthode toString d'algorithme, indiquant le nom de l'algorithme utilisé
     * @return le nom de l'algorithme utilisé
     */
    @Override
    public String toString(){
        return "Génération aléatoire Bornée";
    }

}
