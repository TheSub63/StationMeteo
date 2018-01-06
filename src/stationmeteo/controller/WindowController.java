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

abstract class WindowController extends BorderPane {

    @FXML
    TextField idCapteur;
    @FXML
    TextField nomCapteur;
    @FXML
    TextField actualisationCapteur;
    @FXML
    TextField temperatureCapteur;
    @FXML
    TextField intervalleAlgo;
    @FXML
    TextField onAlgoFixeAfficher1;
    @FXML
    TextField onAlgoFixeAfficher2;
    @FXML
    Button validButton;
    @FXML
    Button annulButton;
    @FXML
    ChoiceBox<Algorithme> algoCapteur;//https://docs.oracle.com/javafx/2/ui_controls/choice-box.htm

    Algorithme selectedAlgo;
    Icapteur capteur;
    Verification verif;


    void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Veuillez remplir tous les champs");
        alert.setContentText("Id doit être un entier, température et actualisation des nombres. "
                + "Pour Algorithme aléatoire bornée, min doit etre inférieur à max deux nombres."
                + "Pour Algorithme aléatoire réaliste, intervalle doit être un nombre différent de 0. "
                + "Un algorithme doit etre selectionné");
        alert.showAndWait();
    }

    void disableAll(){
        onAlgoFixeAfficher1.setDisable(true);
        onAlgoFixeAfficher2.setDisable(true);
        intervalleAlgo.setDisable(true);
        onAlgoFixeAfficher1.setText("");
        onAlgoFixeAfficher2.setText("");
        intervalleAlgo.setText("");
    }
    abstract void commitCapteur();

    Algorithme buildAlgo(Algorithme selectedAlgo){
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
