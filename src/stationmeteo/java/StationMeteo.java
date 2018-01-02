/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
       System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
   
}
