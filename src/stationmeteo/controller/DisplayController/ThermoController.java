package stationmeteo.controller.DisplayController;

import javafx.beans.binding.FloatBinding;
import javafx.beans.binding.When;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import stationmeteo.java.Icapteur;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Classe du controleur gérant les affichages avec thermometre
 * @author Clément
 */
public class ThermoController extends DigitalController {
    @FXML
    private ProgressBar thermo;

    private final FloatBinding min;
    private final FloatProperty progressBarValue=new SimpleFloatProperty();

    /**
     * Constructeur du ThermoController : appelle le constructeur de la classe mère, puis paramètre la jauge en définissant
     * son minimum et son intervalle de progression
     * @param c le capteur selectionné
     */
    public ThermoController(Icapteur c) {
        super(c);
        FloatProperty progressBarMin = new SimpleFloatProperty();
        progressBarMin.set(0f);
        min=(FloatBinding)new When(cap.temperatureProperty().lessThan(-10f))
                .then(progressBarMin)
                .otherwise(cap.temperatureProperty().add(10f).divide(50f));
    }

    /**
     * Appelle l'initialize de le classe mère puis paramètre la couleur de la progressBar, et bind sa progression à la
     * température du capteur.
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location,resources);
        thermo.setStyle("-fx-accent: red;");
        this.progressBarValue.bind(cap.temperatureProperty().add(10f).divide(50f));
        thermo.progressProperty().bind(min);
    }
}

