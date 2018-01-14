package stationmeteo.java.algorithmes;

import java.util.Random;

/**
 * Classe d'Algorithme offrant au capteur un comportement réaliste, c'est à dire prenant en compte l'ancienne température.
 * @author clguilbert
 */
public class AlgorithmeFenetreGlissante implements Algorithme{

    private Random alea;
    private float intervalle;

    /**
     * Constructeur d'Algorithme à fenêtre glissante définissant la taille de la fenêtre.
     * @param taille Taille de la fenêtre
     */
    public AlgorithmeFenetreGlissante(float taille){
        alea=new Random();
        this.intervalle=taille;
    }

    /**
     * Redefinition de la méthode permettant d'obtenir la température. Ici l'ancienne température est utilisée :
     * La nouvelle température est égale à l'ancienne plus un nombre aléatoire entre -taille et taille
     * @param temperature L'ancienne température du capteur
     * @return La température modifiée du capteur
     */
    @Override
    public float getNewTemp(float temperature) {
        temperature=temperature+(((alea.nextFloat()*10)%intervalle-intervalle/2)*2);
        return temperature;
    }

    /**
     * La redéfinition de la méthode toString d'algorithme, indiquant le nom de l'algorithme utilisé
     * @return le nom de l'algorithme utilisé
     */
    @Override
    public String toString(){
        return "Génération aléatoire réaliste";
    }
}
