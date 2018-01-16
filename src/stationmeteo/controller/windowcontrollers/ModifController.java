package stationmeteo.controller.windowcontrollers;

import javafx.fxml.Initializable;
import stationmeteo.java.Capteur;
import stationmeteo.java.algorithmes.Algorithme;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Classe du controleur gérant la fenetre de modification
 * @author magaydu
 */
public class ModifController extends WindowController implements Initializable{

    private Capteur capteur;
    private boolean isModified=false;
    private Algorithme selectedAlgo;
    @SuppressWarnings("WeakerAccess")
    protected boolean isModified() {
        return isModified;
    }

    public Capteur getCapteur(){
        return capteur;
    }

    /**
     * Constructeur du controleur lui associant un capteur
     * @param c le capteur sélectionné par l'utilisateur
     */
    public ModifController(Capteur c){
        capteur=c;
    }

    /**
     * Initialisation de la fenetre d'ajout : remplit les zones de textes avec les infos concernant le capteur sélectionné,
     * associe aux boutons leurs comportements et prepare la choice box d'algorithme
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nomCapteur.setText(capteur.getNom());
        idCapteur.setText(String.valueOf(capteur.getId()));
        if(capteur.getClass()==Capteur.class){
            actualisationCapteur.setText(String.valueOf(capteur.getActualisation()));
        }
        temperatureCapteur.setText(String.valueOf(capteur.getTemperature()));
        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());
        selectedAlgo=capteur.getAlgo();
        initAlgo();
        algoCapteur.setValue(selectedAlgo);
    }


    /**
     * Fonction appelée par le bouton valider
     * Elle appelle Verification sur les informations saisies, construis l'algorithme et modifie le capteur avant de quitter la scene
     */
    @Override
    protected void commitCapteur() {
        if (Verification.verifInfos(selectedAlgo, nomCapteur, idCapteur, actualisationCapteur, temperatureCapteur,
                onAlgoFixeAfficher1, onAlgoFixeAfficher2, intervalleAlgo)){
            showError();
        } else {
            isModified=true;
            capteur.setNom(nomCapteur.getText());
            capteur.setId(Integer.parseInt(idCapteur.getText()));
            capteur.setActualisation(Integer.parseInt(actualisationCapteur.getText()));
            capteur.setTemperature(Float.parseFloat(temperatureCapteur.getText()));
            capteur.setAlgo(buildAlgo(selectedAlgo));
            validButton.getScene().getWindow().hide();
        }
    }

}