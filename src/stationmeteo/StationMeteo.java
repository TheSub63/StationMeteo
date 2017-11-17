/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo;

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

/**
 *
 * @author clguilbert
 */
public class StationMeteo extends Application {
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
        Capteur cap1 = (Capteur) replaceSceneContent("fenetreCapteur.fxml");
        cap1.setApp(this);
        primaryStage.setTitle("Capteur 0");
        primaryStage.show();
    }

    
    private Initializable replaceSceneContent(String fxml){
        FXMLLoader loader = new FXMLLoader();
//        TabPane page=fenetreCapteur();
//        Scene scene = new Scene(page, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        return (Initializable) loader.getController();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(StationMeteo.class, (java.lang.String[])null);
    }
    
}
