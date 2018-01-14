package stationmeteo.java.algorithmes;

/**
 * Interface définissant la méthode de base des Algorithmes. Application du patron de conception Stratégie.
 * @author clguilbert
 */
public interface Algorithme {
    float getNewTemp(float temperature);
    String toString();
}
