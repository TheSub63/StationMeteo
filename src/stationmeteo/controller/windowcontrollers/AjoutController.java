package stationmeteo.controller.windowcontrollers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import stationmeteo.java.Capteur;
import stationmeteo.java.algorithmes.Algorithme;

/**
 * Classe du controleur gérant la fenetre d'ajout
 * @author magaydu
 */
public class AjoutController extends WindowController implements Initializable{
    /**
     * Initialisation de la fenetre d'ajout : associe au boutons leurs actions et initialise la choice box d'algorithmes
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());
        initAlgo();
    }



    /**
     * Fonction appelée par le bouton valider
     * Elle appelle Verification sur les informations saisies, construis l'algorithme et le capteur avant de quitter la scene
     */
    @Override
    protected void commitCapteur(){
        if(Verification.verifInfos(selectedAlgo, nomCapteur, idCapteur, actualisationCapteur, temperatureCapteur,
                onAlgoFixeAfficher1, onAlgoFixeAfficher2, intervalleAlgo)){
            showError();
        }
        else {
            Algorithme algo = buildAlgo(selectedAlgo);
            int id = Integer.parseInt(idCapteur.getText());
            capteur = new Capteur(
                    id, 
                    nomCapteur.getText(), 
                    Integer.parseInt(actualisationCapteur.getText()), 
                    Float.parseFloat(temperatureCapteur.getText()), 
                    algo);
            validButton.getScene().getWindow().hide();
            
        }
    }
}
