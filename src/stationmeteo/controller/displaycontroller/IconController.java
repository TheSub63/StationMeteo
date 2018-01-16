package stationmeteo.controller.displaycontroller;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import stationmeteo.java.metier.Icapteur;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Classe du controleur gérant les affichages avec icones
 * @author Clément
 */
public class IconController extends DigitalController {

    @FXML
    private ImageView icon;

    private final ObjectBinding<Image> monImage ;
    private final SimpleObjectProperty<Image> ImageProperty= new SimpleObjectProperty<>();

    /**
     * Constructeur de l'iconController : appelle le constructeur de la classe mère, puis charge les images et les bind
     * grâce aux conditions When.
     * @param c le capteur selectionné
     */
    public IconController(Icapteur c) {
        super(c);
        Image nuage = new Image("stationmeteo/ressources/images/nuage.png");
        Image soleil = new Image("stationmeteo/ressources/images/soleil.png");
        Image snow = new Image("stationmeteo/ressources/images/neige.png");

        ObjectBinding<Image> unePartie = new When(cap.temperatureProperty().lessThan(20f))
                .then(nuage)
                .otherwise(soleil);

        monImage = new When(cap.temperatureProperty().lessThanOrEqualTo(0f))
                .then(snow)
                .otherwise(unePartie);
    }

    /**
     * Appelle l'initialize de le classe mère puis bind l'image à l'opération monImage
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        super.initialize(location,resources);
        ImageProperty.bind(this.monImage);
        icon.imageProperty().bind(ImageProperty);
    }
}
