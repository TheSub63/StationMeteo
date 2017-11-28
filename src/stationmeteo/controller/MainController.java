/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Preloader;
import javafx.application.Preloader.ProgressNotification;
import javafx.application.Preloader.StateChangeNotification;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stationmeteo.java.Capteur;
import stationmeteo.java.StationMeteo;

/**
 * Simple Preloader Using the ProgressBar Control
 *
 * @author clguilbert
 */
public class MainController extends BorderPane implements Initializable {
    
    @FXML
    Button addButton;
    @FXML
    Button uptButton;
    @FXML
    Button delButton;
    @FXML
    Button digitalButton;
    @FXML
    Button thermoButton;
    @FXML
    Button iconButton;
    @FXML
    Label nameText;
    @FXML
    ListView capteurList;
    
    private final ObservableList<Capteur> listeDeCapteur = FXCollections.observableList(new ArrayList());
    private StationMeteo application;
    private Capteur selectedCapteur;
    private CapteurController capteurController;
    public void setApp(StationMeteo application){
        this.application = application;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                ouvrirFenetreAjout(); 
            }
        });
        uptButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                if(selectedCapteur!=null)ouvrirFenetreModif(); 
            }
        });
        delButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("Suppression impossible");
            }
        });
        digitalButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("AFFICHAGE DIGITAL");
            }
        });
        thermoButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("AFFICHAGE THERMOMETRE");
            }
        });
        iconButton.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                System.out.println("AFFICHAGE ICONE");
            }
        });
        //https://www.developpez.net/forums/d1515667/java/interfaces-graphiques-java/javafx/communication-entre-2-controleurs-lies-chacun-fichier-fxml/
        capteurList.setItems(listeDeCapteur);
        Capteur captdef = new Capteur(0,"capteur defaut",1, 17.7f);
        //capteurs=new ArrayList<Capteur>();
	//capteurs.add(captdef);
        //if(capteurList.getItems()!=null) capteurs = capteurList.getItems();
	//capteurList.getSelectionModel().selectedItemProperty().addListener((property, oldValue, newValue) -> { System.out.println("LIST UPDATED");}
//);
                
                
    }
    public void ouvrirFenetreAjout(){
        Stage modif=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreAjout.fxml");
        FXMLLoader loader = new FXMLLoader(url);          
        BorderPane page;
        try{
            page = (BorderPane) loader.load();
            Scene scene = new Scene(page);
            modif.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        modif.setTitle("Nouveau Capteur");
        modif.show(); 
    }
        public void ouvrirFenetreModif(){
        Stage modif=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreModif.fxml");
        FXMLLoader loader = new FXMLLoader(url);          
        BorderPane page;
        try{
            page = (BorderPane) loader.load();
            Scene scene = new Scene(page);
            modif.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        modif.setTitle("Modifier Capteur");
        modif.show(); 
    }
}
