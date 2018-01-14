package stationmeteo.java;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.net.URL;
import javafx.scene.layout.BorderPane;
import stationmeteo.controller.MainController;

/**
 * Classe principale de l'application, elle charge la fenêtre principale,
 * gère le lancement et la fermeture de l'application et l'instanciation du MainController.
 * @author clguilbert
 */

public class StationMeteo extends Application {

    /**
     * Le Main Controller de l'application
     */
    private MainController leMain= new MainController();

    /**
     * Methode gérant le processus de lancement de l'application, elle charge les éléments sauvegardés avec un appel au main controller,
     * charge la fenetre FXML et l'affiche.
     * @param primaryStage Le stage qui va contenir la scene chargée par le FXML loader.
     */
    @Override
    public void start(Stage primaryStage) {
        leMain.ChargerCapteur();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreMain.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(leMain);
        try{
            BorderPane page = loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        primaryStage.setTitle("Station Meteo");
        primaryStage.show(); 
    }

    /**
     * Gestion de l'arrêt de l'application : Appel au mainController pour sauvegarder les éléments
     */
    @Override
    public void stop(){
        leMain.sauveCapteur();
        System.exit(0);
    }

    /**
     * Lancement de l'application
     * @param args les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
   
}
