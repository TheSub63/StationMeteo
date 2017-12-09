/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import static javax.accessibility.AccessibleRole.LABEL;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;
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
    private Button validButton;
    @FXML
    private Button annulButton;
    @FXML
    private ChoiceBox<Algorithme> algoCapteur;//https://docs.oracle.com/javafx/2/ui_controls/choice-box.htm
    
    private Algorithme selectedAlgo;
    protected Capteur i;
    private int id;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        validButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                commitCapteur();
                
            }
        });
        annulButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                Stage stage = (Stage) annulButton.getScene().getWindow();
                stage.close();
                
            }
        });
/**tests**/algoCapteur.setItems(FXCollections.observableArrayList(null, new AlgorithmeAleatoire(), new AlgorithmeAleatoireFixe(1f,1f), new AlgorithmeFenetreGlissante(1f)));
        algoCapteur.getSelectionModel().selectedIndexProperty();
        selectedAlgo=(Algorithme)algoCapteur.getSelectionModel().getSelectedItem();
        //if(selectedAlgo.getClass()==AlgorithmeFenetreGlissante.class) {                                   //L ERREUR EST LA EN FAIT
        //   this.getStylesheets().add("fenetreAjoutIntervalle.css");       //////////////////////////:
        //}
        
    }
    
    public void commitCapteur(){
        //erreur non fatale quand champ non rempli
        selectedAlgo=(Algorithme)algoCapteur.getSelectionModel().getSelectedItem();

        Algorithme algo=selectedAlgo;
                
                
        id=Integer.parseInt(idCapteur.getText());
        i = new Capteur(id,nomCapteur.getText(),Integer.parseInt(actualisationCapteur.getText()),Float.parseFloat(temperatureCapteur.getText()),algo);

    }
    public Capteur getCapteur(){
        return i;
    }
}
    

