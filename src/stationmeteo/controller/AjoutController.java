/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleRole.LABEL;
import stationmeteo.java.Capteur;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoire;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;
/**
 *
 * @author magaydu
 */
public class AjoutController extends BorderPane implements Initializable{

    @FXML
    private TextField idCapteur;
    @FXML
    private TextField nomCapteur;
    @FXML
    private TextField actualisationCapteur;
    @FXML
    private TextField temperatureCapteur;
    @FXML
    private TextField intervalleAlgo;
    @FXML
    private TextField onAlgoFixeAfficher1;
    @FXML
    private TextField onAlgoFixeAfficher2;
    @FXML
    private Button validButton;
    @FXML
    private Button annulButton;
    @FXML
    private ChoiceBox<Algorithme> algoCapteur;//https://docs.oracle.com/javafx/2/ui_controls/choice-box.htm
    
    private Algorithme selectedAlgo;
    private Capteur capteur;
    private int id;

    private final static String REGNUM="^-?[0-9]*(.[0-9]+)?$";
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        validButton.setOnMousePressed(me -> commitCapteur());
        annulButton.setOnMousePressed(me -> annulButton.getScene().getWindow().hide());

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
    
    private void commitCapteur(){
        if(!verifInfos()){
            showError();
        }
        else {
            if(selectedAlgo.getClass()==AlgorithmeAleatoireFixe.class){
                selectedAlgo=new AlgorithmeAleatoireFixe(
                        Float.parseFloat(onAlgoFixeAfficher1.getText()),
                        Float.parseFloat(onAlgoFixeAfficher2.getText()));
            }
            if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class){
                selectedAlgo=new AlgorithmeFenetreGlissante(
                        Float.parseFloat(intervalleAlgo.getText()));
            }
            Algorithme algo = selectedAlgo;
            id = Integer.parseInt(idCapteur.getText());
            capteur = new Capteur(
                    id, 
                    nomCapteur.getText(), 
                    Integer.parseInt(actualisationCapteur.getText()), 
                    Float.parseFloat(temperatureCapteur.getText()), 
                    algo);
            validButton.getScene().getWindow().hide();
            
        }
    }

    private boolean verifInfos(){
        
        if(selectedAlgo==null)return false;

        if(nomCapteur.getText().isEmpty() 
                || idCapteur.getText().isEmpty() 
                || actualisationCapteur.getText().isEmpty())return false;

        if(temperatureCapteur.getText().isEmpty()
                ||!temperatureCapteur.getText().matches(REGNUM)) 
                temperatureCapteur.setText("0");

        if(! idCapteur.getText().matches("^[0-9]+$")
                ||!actualisationCapteur.getText().matches("^[0-9.]*(.[0-9]+)?$"))
            return false;

        if(! onAlgoFixeAfficher1.isDisable()){

            if(! onAlgoFixeAfficher1.getText().matches(REGNUM)||!onAlgoFixeAfficher2.getText().matches(REGNUM))
                return false;

            if(Float.parseFloat(onAlgoFixeAfficher1.getText())>=Float.parseFloat(onAlgoFixeAfficher2.getText()))
                return false;

        }

        if(! intervalleAlgo.isDisable()) {

            return intervalleAlgo.getText().matches(REGNUM) && (!intervalleAlgo.getText().isEmpty() && Float.parseFloat(intervalleAlgo.getText()) != 0);

        }
        //Rendre la fonction accessible par ModifController
        return true;
    }

    private void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Veuillez remplir tous les champs");
        alert.setContentText("Id doit être un entier, température et actualisation des nombres. "
                + "Pour Algorithme aléatoire bornée, min doit etre inférieur à max deux nombres."
                + "Pour Algorithme aléatoire réaliste, intervalle doit être un nombre différent de 0. "
                + "Un algorithme doit etre selectionné");
        alert.showAndWait();
    }

    private void disableAll(){
        onAlgoFixeAfficher1.setDisable(true);
        onAlgoFixeAfficher2.setDisable(true);
        intervalleAlgo.setDisable(true);
        onAlgoFixeAfficher1.setText("");
        onAlgoFixeAfficher2.setText("");
        intervalleAlgo.setText("");

    }

    public Capteur getCapteur(){
        return capteur;
    }

}
    

