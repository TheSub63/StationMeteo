/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo;

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
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
/**
 *
 * @author clguilbert
 */
public class StationMeteo extends Application {
    //private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {      
        URL url=getClass().getResource("fenetreCapteur.fxml");
        FXMLLoader loader = new FXMLLoader(url);          
       TabPane page;
        try{

            page = (TabPane) loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();     
        }
        primaryStage.setTitle("Capteur 0");
        primaryStage.show(); 
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
    
}
