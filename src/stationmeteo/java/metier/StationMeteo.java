package stationmeteo.java.metier;

import javafx.application.Application;
import javafx.stage.Stage;
import stationmeteo.controller.windowcontrollers.MainController;

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
        leMain.chargerCapteur();
        primaryStage=leMain.charger("/stationmeteo/ressources/fxml/fenetreMain.fxml",leMain);
        primaryStage.setTitle("Station Meteo");
        primaryStage.show(); 
    }

    /**
     * Gestion de l'arrêt de l'application : Appel au mainController pour sauvegarder les éléments
     */
    @Override
    public void stop(){
        int status = 1;
        try {
            leMain.sauveCapteur();
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(status);
        }
        finally {
            status=0;
        }
        System.exit(status);
    }

    /**
     * Lancement de l'application
     * @param args les arguments de la ligne de commande.
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
   
}
