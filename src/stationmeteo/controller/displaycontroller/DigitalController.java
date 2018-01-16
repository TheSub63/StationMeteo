package stationmeteo.controller.displaycontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import stationmeteo.java.metier.Icapteur;

/**
 * Classe mere de l'ensemble controlant les fenetres d'affichage des capteurs
 * @author matthias
 */
public class DigitalController extends BorderPane implements Initializable{
    
    @FXML
    private Label nameText;
    @FXML
    private Label cpt;
    
    protected final Icapteur cap;
    protected final StringConverter<Number> converter = new NumberStringConverter();

    /**
     * Associe un Icapteur au controller
     * @param c le capteur séléctionné par l'utilisateur
     */
    public DigitalController(Icapteur c){
        cap=c;
    }

    /**
     * Intialisation de la fenêtre : bind le label cpt et la température du capteur, affiche le nom du capteur sélectionné
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameText.setText(cap.getNom());
        Bindings.bindBidirectional(cpt.textProperty(), cap.temperatureProperty(), converter);
    }
}
