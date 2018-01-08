package stationmeteo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import stationmeteo.java.Icapteur;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
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

    private Icapteur selectedCapteur;
    private ObservableList<Icapteur> listeDeCapteur;
    private SuperCapteur onCap;

    public SuperCapController(ObservableList<Icapteur> list){
        listeDeCapteur=FXCollections.observableList(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        validButton.setOnMousePressed(me -> commitCapteur());
        stopButton.setOnMousePressed(me -> stopButton.getScene().getWindow().hide());
        capteurList.setOnMouseClicked(me -> selectedCapteur= capteurList.getSelectionModel().getSelectedItem());
        capteurList.setItems(listeDeCapteur);
    }

    private void commitCapteur() {
        onCap=new SuperCapteur(Integer.parseInt(idCapteur.getText()),
                                nomCapteur.getText(),selectedCapteur);
        listeDeCapteur.add(onCap);
        validButton.getScene().getWindow().hide();
    }
}
