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
import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    private Button addButton;
    @FXML
    private Button uptButton;
    @FXML
    private Button delButton;
    @FXML
    private Button digitalButton;
    @FXML
    private Button thermoButton;
    @FXML
    private Button iconButton;
    @FXML
    private Label nameText;
    @FXML
    private ListView capteurList;
    
    private ObservableList<Capteur> listeDeCapteur = FXCollections.observableList(new ArrayList());
    private StationMeteo application;
    private Capteur selectedCapteur;
    private CapteurController capteurController;
    public void setApp(StationMeteo application){
        this.application = application;
    }

    public ObservableList<Capteur> getListeDeCapteur() {
        return listeDeCapteur;
    }

    public void setListeDeCapteur(ObservableList<Capteur> listeDeCapteur) {
        this.listeDeCapteur = listeDeCapteur;
    }
    private CapteurController capteurcontrol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        capteurList.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                selectedCapteur=(Capteur)capteurList.getSelectionModel().getSelectedItem();
            }
        });
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
               
                listeDeCapteur.remove(selectedCapteur);
                selectedCapteur.getLeThread().stop();
                selectedCapteur=null;
            }
        });
        digitalButton.setOnMousePressed(me -> {
            if(selectedCapteur!=null)affichageDigital();
        });
        thermoButton.setOnMousePressed((MouseEvent me) -> {
            if(selectedCapteur!=null)affichageThermo();
        });
        iconButton.setOnMousePressed((MouseEvent me) -> {
            if(selectedCapteur!=null)affichageIcone();
        });


        Capteur captdef = new Capteur(0,"capteur defaut",1, 17.7f,null);

        

        listeDeCapteur.add(captdef);
       
        capteurList.setItems(listeDeCapteur);
       
                
    }
    public void ouvrirFenetreAjout(){
        Stage modif=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreAjout.fxml");
        FXMLLoader loader = new FXMLLoader(url);          
        BorderPane page;
        AjoutController ajoutcont=new AjoutController();
        loader.setController(ajoutcont);
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            modif.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        modif.setTitle("Nouveau Capteur");
        modif.showAndWait();
        if(ajoutcont.getCapteur()!=null) listeDeCapteur.add(ajoutcont.getCapteur());
    }
        public void ouvrirFenetreModif(){
        Stage modif=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreModif.fxml");
        FXMLLoader loader = new FXMLLoader(url);          
        BorderPane page;
        ModifController modifcont=new ModifController(selectedCapteur);

        loader.setController(modifcont);
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            modif.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        modif.setTitle("Modifier Capteur");
        modif.showAndWait(); 
        if(modifcont.getCapteur()!=null) {// SALE
            listeDeCapteur.remove(selectedCapteur);
            selectedCapteur=modifcont.getCapteur(); 
            listeDeCapteur.add(selectedCapteur);
        }
    }

    public ListView getCapteurList() {
        return capteurList;
    }

    public void setCapteurList(ListView capteurList) {
        this.capteurList = capteurList;
    }
    public void affichageDigital(){
        Stage digital=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreDigitale.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        BorderPane page;
        capteurcontrol=new CapteurController(selectedCapteur);
        loader.setController(capteurcontrol);
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            digital.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        digital.setTitle(selectedCapteur.getNom());
        digital.show();
    }

    public void affichageThermo(){
        Stage thermo=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreThermo.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        BorderPane page;
        capteurcontrol=new CapteurController(selectedCapteur);
        loader.setController(capteurcontrol);
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            thermo.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        thermo.setTitle(selectedCapteur.getNom());
        thermo.show();
    }

    public void affichageIcone(){
        Stage icone=new Stage();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreIcone.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        BorderPane page;
        capteurcontrol=new CapteurController(selectedCapteur);
        loader.setController(capteurcontrol);
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            icone.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        icone.setTitle(selectedCapteur.getNom());
        icone.show();
    }
        
        public Capteur getCapteur(){
            return selectedCapteur;
        }
}
