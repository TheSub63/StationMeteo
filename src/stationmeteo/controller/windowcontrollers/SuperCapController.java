package stationmeteo.controller.windowcontrollers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import stationmeteo.java.metier.CapteurPoid;
import stationmeteo.java.metier.Icapteur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Alert.AlertType;
import stationmeteo.java.metier.SuperCapteur;
import stationmeteo.java.metier.FabriqueCapteur;

/**
 * Controller de la fenêtre permettant de créer un super capteur.
 * @author Clément
 */
public class SuperCapController extends WindowController implements Initializable{

    @FXML
    private ListView<Icapteur> capteurList;         //Liste affichant les capteurs sélectionnables
    
    private ListView<Icapteur> selectedCapteurs;    //Liste contenant les capteurs sélectionnés
    private ObservableList<Icapteur> listeDeCapteur;
    private SuperCapteur onCap;

    /**
     * Constructeur du Controleur
     * @param list liste des capteurs chargés
     */
    public SuperCapController(ObservableList<Icapteur> list){
        listeDeCapteur=FXCollections.observableList(list);
    }

    /**
     * Intialisation de la fenêtre : instancie la liste selectedCapteurs, assigne leurs actions aux boutons,
     * charge la listeDeCapteur dans la ListView, autorise la selection multiple et remplit la liste des capteurs sélectionnés
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedCapteurs= new ListView<>();

        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());

        capteurList.setItems(listeDeCapteur);
        capteurList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        capteurList.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->
                selectedCapteurs.setItems(capteurList.getSelectionModel().getSelectedItems()));
        
    }

    /**
     * Methode appelée par le bouton valider qui pour chaque capteur sélectionné affiche un dialogue permettant de
     * renseigner le poids associé. Elle est aussi responsable de l'instanciation du nouveau superCapteur et de l'ajout
     * des sous Capteurs.
     */
    void commitCapteur() {
        if(!Verification.verifInfoSuperCapteur(nomCapteur, idCapteur, selectedCapteurs)){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("SuperCapteur");
            alert.setHeaderText("nom, id ,capteur selectionné");
            alert.setContentText("le nom doit etre inserer, l'id doit être un entier, des capteurs doivent être selectionné");

            alert.showAndWait();
        }
        else{
        for (Icapteur element : selectedCapteurs.getItems()) {

            TextInputDialog poidsI=new TextInputDialog("Entrez le poids du capteur "+element.getNom());
            while(!poidsI.getEditor().getText().matches("^[1-9]+$")) {

                poidsI.showAndWait();
                if (poidsI.getEditor().getText().matches("^[1-9]+$")) {

                    CapteurPoid sousCap = new CapteurPoid(element, Integer.parseInt(poidsI.getEditor().getText()));
                    if (onCap == null) {
                        onCap = (SuperCapteur) FabriqueCapteur.fabriqueSuperCapteur(Integer.parseInt(idCapteur.getText()),
                                nomCapteur.getText(), sousCap);
                        onCap = (SuperCapteur) FabriqueCapteur.fabriqueSuperCapteur(Integer.parseInt(idCapteur.getText()), nomCapteur.getText(), sousCap);

                    }
                    else onCap.ajouter(sousCap);
                }

            }

        }

        listeDeCapteur.add(onCap);
        validButton.getScene().getWindow().hide();
        }
    }
}
