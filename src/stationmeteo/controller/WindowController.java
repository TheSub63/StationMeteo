package stationmeteo.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import stationmeteo.java.Icapteur;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;

@SuppressWarnings("WeakerAccess")
abstract class WindowController extends BorderPane {

    @FXML
    protected TextField idCapteur;
    @FXML
    protected TextField nomCapteur;
    @FXML
    protected TextField actualisationCapteur;
    @FXML
    protected TextField temperatureCapteur;
    @FXML
    protected TextField intervalleAlgo;
    @FXML
    protected TextField onAlgoFixeAfficher1;
    @FXML
    protected TextField onAlgoFixeAfficher2;
    @FXML
    protected Button validButton;
    @FXML
    protected Button annulButton;
    @FXML
    protected ChoiceBox<Algorithme> algoCapteur;//https://docs.oracle.com/javafx/2/ui_controls/choice-box.htm

    protected Algorithme selectedAlgo;
    protected Icapteur capteur;
    protected Verification verif;


    protected void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Veuillez remplir tous les champs");
        alert.setContentText("Id doit être un entier, température et actualisation des nombres. "
                + "Pour Algorithme aléatoire bornée, min doit etre inférieur à max deux nombres."
                + "Pour Algorithme aléatoire réaliste, intervalle doit être un nombre supérieur ou égal à 1. "
                + "Un algorithme doit etre selectionné");
        alert.showAndWait();
    }

    protected void disableAll(){
        onAlgoFixeAfficher1.setDisable(true);
        onAlgoFixeAfficher2.setDisable(true);
        intervalleAlgo.setDisable(true);
        onAlgoFixeAfficher1.setText("");
        onAlgoFixeAfficher2.setText("");
        intervalleAlgo.setText("");
    }
    abstract void commitCapteur();

    protected Algorithme buildAlgo(Algorithme selectedAlgo){
        if(selectedAlgo.getClass()==AlgorithmeAleatoireFixe.class){
            selectedAlgo=new AlgorithmeAleatoireFixe(
                    Float.parseFloat(onAlgoFixeAfficher1.getText()),
                    Float.parseFloat(onAlgoFixeAfficher2.getText()));
        }
        if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class){
            selectedAlgo=new AlgorithmeFenetreGlissante(
                    Float.parseFloat(intervalleAlgo.getText()));
        }
        return selectedAlgo;
    }

    public Icapteur getCapteur() {
        return this.capteur;
    }
}
