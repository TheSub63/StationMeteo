package stationmeteo.controller.windowcontrollers;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import stationmeteo.java.Icapteur;
import stationmeteo.java.algorithmes.Algorithme;
import stationmeteo.java.algorithmes.AlgorithmeAleatoire;
import stationmeteo.java.algorithmes.AlgorithmeAleatoireFixe;
import stationmeteo.java.algorithmes.AlgorithmeFenetreGlissante;

/**
 * Classe abstraite mere des controleurs de fenêtres agissant sur les capteurs.
 * @author Clément
 */
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
    protected ChoiceBox<Algorithme> algoCapteur;

    protected Algorithme selectedAlgo;
    protected Icapteur capteur;


    public Icapteur getCapteur() {
        return this.capteur;
    }
 
    /**
     * Methode affichant un message d'alerte en cas d'invalidité des informations saisies
     */
    protected void showError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Veuillez remplir tous les champs");
        alert.setContentText("Id et actualisation doivent être des entiers, température un nombre. "
                + "Pour Algorithme aléatoire bornée, min doit etre inférieur à max deux nombres."
                + "Pour Algorithme aléatoire réaliste, intervalle doit être un nombre supérieur ou égal à 1. "
                + "Un algorithme doit etre selectionné");
        alert.showAndWait();
    }

    /**
     * Methode désactivant et vidant les champs inutiles
     */
    protected void disableAll(){
        onAlgoFixeAfficher1.setDisable(true);
        onAlgoFixeAfficher2.setDisable(true);
        intervalleAlgo.setDisable(true);
        onAlgoFixeAfficher1.setText("");
        onAlgoFixeAfficher2.setText("");
        intervalleAlgo.setText("");
    }

    /**
     * Methode construisant un algorithme avec les paramètres choisis
     * @param selectedAlgo l'algorithme souhaité
     * @return l'algorithme utilisable
     */
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

    /**
     * Methode chargeant la choice box d'algorithmes
     */
    protected void initAlgo(){
        algoCapteur.setItems(FXCollections.observableArrayList(
                new AlgorithmeAleatoire(),
                new AlgorithmeAleatoireFixe(1f,1f),
                new AlgorithmeFenetreGlissante(1f)));
        algoCapteur.setOnAction(ae -> {
            algoCapteur.getSelectionModel().selectedIndexProperty();
            selectedAlgo= algoCapteur.getSelectionModel().getSelectedItem();
            if(selectedAlgo==null) disableAll();
            else if(selectedAlgo.getClass()==AlgorithmeAleatoireFixe.class){
                disableAll();
                onAlgoFixeAfficher1.setDisable(false);
                onAlgoFixeAfficher2.setDisable(false);  //si l'algo selectionnée est AlgorithmeAleatoireFixe alors on affiche les zones de textes associées
            }
            else if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class){
                disableAll();
                intervalleAlgo.setDisable(false);       //Meme procédé pour AlgorithmeFenetreGlissante
            }
            else disableAll();                          //Sinon on desactive les zones de textes
        });
    }

    abstract void commitCapteur();
}
