/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.Initializable;
import stationmeteo.java.Capteur;
import stationmeteo.java.Icapteur;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoire;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;

/**
 *
 * @author magaydu
 */
public class ModifController extends WindowController implements Initializable{

    private boolean isModified=false;
    public ModifController(Icapteur c){
        capteur=c;
    }
    private Algorithme selectedAlgo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        verif=new Verification();
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

    }

    private void initAlgo(){
        algoCapteur.setItems(FXCollections.observableArrayList(
                new AlgorithmeAleatoire(),
                new AlgorithmeAleatoireFixe(1f,1f),
                new AlgorithmeFenetreGlissante(1f)));
        algoCapteur.setValue(selectedAlgo);
        algoCapteur.setOnAction(ae -> {
            algoCapteur.getSelectionModel().selectedIndexProperty();
            selectedAlgo= algoCapteur.getSelectionModel().getSelectedItem();
            if(selectedAlgo==null) disableAll();
            else if(selectedAlgo.getClass()==AlgorithmeAleatoireFixe.class){
                disableAll();
                onAlgoFixeAfficher1.setDisable(false);
                onAlgoFixeAfficher2.setDisable(false);
            }
            else if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class){
                disableAll();
                intervalleAlgo.setDisable(false);
            }
            else disableAll();
        });
    }




    @Override
    protected void commitCapteur() {
        if (!verif.verifInfos(selectedAlgo, nomCapteur, idCapteur, actualisationCapteur, temperatureCapteur,
                onAlgoFixeAfficher1, onAlgoFixeAfficher2, intervalleAlgo)){
            showError();
        } else {
            isModified=true;
            capteur.setNom(nomCapteur.getText());
            capteur.setId(Integer.parseInt(idCapteur.getText()));
            if (capteur.getClass() == Capteur.class) {
                capteur.setActualisation(Integer.parseInt(actualisationCapteur.getText()));
            }
            capteur.setUneTemperature(Float.parseFloat(temperatureCapteur.getText()));
            capteur.setAlgo(buildAlgo(selectedAlgo));
            validButton.getScene().getWindow().hide();
        }
    }

    @SuppressWarnings("WeakerAccess")
    protected boolean isModified() {
        return isModified;
    }
}