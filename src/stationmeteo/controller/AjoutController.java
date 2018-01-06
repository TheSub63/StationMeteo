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
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoire;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;
/**
 *
 * @author magaydu
 */
public class AjoutController extends WindowController implements Initializable{


    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());
        verif=new Verification();
        algoCapteur.setItems(FXCollections.observableArrayList(
                new AlgorithmeAleatoire(), 
                new AlgorithmeAleatoireFixe(1f,1f), 
                new AlgorithmeFenetreGlissante(1f)));


        algoCapteur.setOnAction(ae -> {
            algoCapteur.getSelectionModel().selectedIndexProperty();
            selectedAlgo=(Algorithme)algoCapteur.getSelectionModel().getSelectedItem();
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
    void commitCapteur(){
        if(!verif.verifInfos(selectedAlgo, nomCapteur, idCapteur, actualisationCapteur, temperatureCapteur,
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
