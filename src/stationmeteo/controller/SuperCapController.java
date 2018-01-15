package stationmeteo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import stationmeteo.java.CapteurPoid;
import stationmeteo.java.Icapteur;
import java.net.URL;
import java.util.ResourceBundle;
import stationmeteo.java.SuperCapteur;

public class SuperCapController extends BorderPane implements Initializable{

    @FXML
    private TextField idCapteur;
    @FXML
    private TextField nomCapteur;
    @FXML
    private Button validButton;
    @FXML
    private Button stopButton;
    @FXML
    private ListView<Icapteur> capteurList;
    
    private ListView<Icapteur> selectedCapteurs;
    private ObservableList<Icapteur> listeDeCapteur;
    private SuperCapteur onCap;

    public SuperCapController(ObservableList<Icapteur> list){
        listeDeCapteur=FXCollections.observableList(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectedCapteurs= new ListView<>();
        validButton.setOnMousePressed(me -> commitCapteur());
        stopButton.setOnMousePressed(me -> stopButton.getScene().getWindow().hide());
        capteurList.setItems(listeDeCapteur);
        capteurList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        capteurList.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->
                selectedCapteurs.setItems(capteurList.getSelectionModel().getSelectedItems()));
        
    }

    private void commitCapteur() {
        for (Icapteur element : selectedCapteurs.getItems()) {
            TextInputDialog poidsI=new TextInputDialog("Entrez le poids du capteur "+element.getNom());
            while(!poidsI.getEditor().getText().matches("^[1-9]+$")) {
                poidsI.showAndWait();
                if (poidsI.getEditor().getText().matches("^[1-9]+$")) {
                    CapteurPoid sousCap = new CapteurPoid(element, Integer.parseInt(poidsI.getEditor().getText()));
                    if (onCap == null) {
                        onCap = new SuperCapteur(Integer.parseInt(idCapteur.getText()),
                                nomCapteur.getText(), sousCap);
                    }
                    else onCap.ajouter(sousCap);
                }
            }
        }
        listeDeCapteur.add(onCap);
        validButton.getScene().getWindow().hide();
    }
}
