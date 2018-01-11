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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static javafx.scene.control.SelectionMode.MULTIPLE;
import static javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION;
import stationmeteo.java.SuperCapteur;

public class SuperCapController extends BorderPane implements Initializable{

    @FXML
    protected TextField idCapteur;
    @FXML
    protected TextField nomCapteur;
    @FXML
    protected Button validButton;
    @FXML
    protected Button stopButton;
    @FXML
    private ListView<Icapteur> capteurList;
    
    private Icapteur leader;
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
        capteurList.getSelectionModel().selectedItemProperty().addListener((obs,ov,nv)->{
            selectedCapteurs.setItems(capteurList.getSelectionModel().getSelectedItems());
        });
        
    }

    private void commitCapteur() {
        for (Icapteur element : selectedCapteurs.getItems()) {
            TextInputDialog poidsI=new TextInputDialog("Entrez le poids du capteur "+element.getNom());
            poidsI.showAndWait();
            CapteurPoid sousCap=new CapteurPoid(element, Integer.parseInt(poidsI.getEditor().getText()));
            if(onCap==null){
                onCap=new SuperCapteur(Integer.parseInt(idCapteur.getText()),
                        nomCapteur.getText(),sousCap);
            }
            else onCap.ajouter(sousCap);
        }
        listeDeCapteur.add(onCap);
        validButton.getScene().getWindow().hide();
    }
}
