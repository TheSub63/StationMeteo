/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author clguilbert
 */
public class StationMeteo extends Application {
    //private Stage primaryStage;
    private MainController leMain= new MainController();
    @Override
    public void start(Stage primaryStage) {
       leMain.ChargerCapteur();
        URL url=getClass().getResource("/stationmeteo/ressources/fxml/fenetreMain.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(leMain);
        BorderPane page;
        try{
            page = loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        primaryStage.setTitle("Station Meteo");
        primaryStage.show(); 
    }
@Override
    public void stop(){
        leMain.sauveCapteur();
       System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
   
}
