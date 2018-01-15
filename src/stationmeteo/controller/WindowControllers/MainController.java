package stationmeteo.controller.WindowControllers;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import stationmeteo.controller.DisplayController.DigitalController;
import stationmeteo.controller.DisplayController.IconController;
import stationmeteo.controller.DisplayController.ThermoController;
import stationmeteo.java.Capteur;
import stationmeteo.java.serialize.ICapteurSerialize;
import stationmeteo.java.Icapteur;
import stationmeteo.java.serialize.SerializerCapteur;

/**
 * Controller de la fenêtre principale
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
    private Button groupButton;
    @FXML
    private Button digitalButton;
    @FXML
    private Button thermoButton;
    @FXML
    private Button iconButton;
    @FXML
    private ListView<Icapteur> capteurList;
    
    private ObservableList<Icapteur> listeDeCapteur = FXCollections.observableList(new ArrayList());
    private SerializerCapteur XMLdatamanager=new SerializerCapteur();
    private Icapteur selectedCapteur;
    /**
     * Getter du selectedCapteur
     * @return capteur sélectionné par l'utilisateur
     */
    public Icapteur getCapteur(){
        return selectedCapteur;
    }

    /**
     * Intialisation de la fenêtre : assigne les actions liées au clic de l'utilisateur et remplit capteurList avec
     * les éléments de listeDeCapteur
     * @param location La location relative de l'objet racine
     * @param resources Les ressources utilisés pour trouver l'objet racine
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        capteurList.setOnMouseClicked(me -> selectedCapteur= capteurList.getSelectionModel().getSelectedItem());
        //CellFactory A binder, class a peut etre supprimer
        /*capteurList.setCellFactory(param ->
            new ListCell<Icapteur>(){               
                @Override
                protected void updateItem(Icapteur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item != null) {
                        setText(item.toString());
                        float temp = item.getTemperature();
                        setTextFill(temp < 0 ? Color.BLUE : Color.RED);
                    
                    }
                }
            });**/
        addButton.setOnMousePressed(me -> ouvrirFenetreAjout());
        groupButton.setOnMousePressed(me -> ouvrirFenetreSuperCapteur());

        uptButton.setOnMousePressed(me -> {
            if(selectedCapteur!=null && selectedCapteur.getClass()==Capteur.class )
                 ouvrirFenetreModif();
        });

        delButton.setOnMousePressed(me -> {
            if(selectedCapteur!=null) {
                listeDeCapteur.remove(selectedCapteur);
                if(selectedCapteur.getClass()==Capteur.class)
                    ((Capteur) selectedCapteur).getLeThread().interrupt();
                selectedCapteur = null;
            }
        });

        digitalButton.setOnMousePressed(me -> { if(selectedCapteur!=null)affichageDigital(); });
        thermoButton.setOnMousePressed(me -> { if(selectedCapteur!=null)affichageThermo(); });
        iconButton.setOnMousePressed(me -> { if(selectedCapteur!=null)affichageIcone(); });

        capteurList.setItems(listeDeCapteur);
    }

    /**
     *Ajoute à la liste les capteurs sauvegardés.
     */
    public void chargerCapteur(){
       if(listeDeCapteur!=null){
            List<ICapteurSerialize> result=XMLdatamanager.chargeCapteur();
            if(result!=null){
                listeDeCapteur.clear();
                for(int i=0;i<XMLdatamanager.chargeCapteur().size();i++){
                    listeDeCapteur.add((Capteur )XMLdatamanager.chargeCapteur().get(i));
                }
            }
           /* List<ISuperCapteurSerialize> resultSup=XMLdatamanager.chargeSuperCapteur();
            if(resultSup!=null){
                for(int i=0;i<XMLdatamanager.chargeSuperCapteur().size();i++){
                    listeDeCapteur.add((SuperCapteur )XMLdatamanager.chargeSuperCapteur().get(i));
                }
            }*/
       }
    }

    /**
     * Sauvegarde les capteurs à l'aide du XMLdatamanager
     */
    public void sauveCapteur(){
        if(this.XMLdatamanager!= null){
            ArrayList<Icapteur> test =new ArrayList<>();
            test.addAll(capteurList.getItems());
            //ObservableList items = this.capteurList.getItems();
            XMLdatamanager.sauveCapteurs(test);
        }
        else System.out.println("Erreur P");
    }

    /**
     * Methode utilitaire de chargement de fenetre
     * @param path chemin d'accès à la ressource FXML
     * @param control instance de controller
     * @return le Stage chargé par la methode
     */
    private Stage charger(String path, BorderPane control){
        Stage fenetre=new Stage();
        URL url=getClass().getResource(path);
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(control);
        try{
            BorderPane page = loader.load();
            Scene scene = new Scene(page);
            fenetre.setScene(scene);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return fenetre;
    }

    /**
     * Procédure d'ouverture de la fenêtre d'Ajout et ajout du capteur si besoin
     */
    private void ouvrirFenetreAjout(){
        AjoutController ajoutcont=new AjoutController();
        Stage ajout=charger("/stationmeteo/ressources/fxml/fenetreAjout.fxml",ajoutcont);
        ajout.setTitle("Nouveau Capteur");
        ajout.showAndWait();
        if(ajoutcont.getCapteur()!=null) listeDeCapteur.add(ajoutcont.getCapteur());
    }

    /**
     * Procédure d'ouverture de la fenêtre de groupement de capteurs
     */
    private void ouvrirFenetreSuperCapteur(){
        SuperCapController supcont=new SuperCapController(listeDeCapteur);
        Stage supcap=charger("/stationmeteo/ressources/fxml/fenetreSuperCapteur.fxml",supcont);
        supcap.setTitle("Creer Super Capteur");
        supcap.showAndWait();
    }

    /**
     * Procédure d'ouverture de la fenêtre de modification et modification si besoin
     */
    private void ouvrirFenetreModif(){
        ModifController modifcont=new ModifController((Capteur) selectedCapteur);
        Stage modif=charger("/stationmeteo/ressources/fxml/fenetreModif.fxml",modifcont);
        modif.setTitle("Modifier Capteur");
        modif.showAndWait();
        if(modifcont.isModified()) {
            listeDeCapteur.remove(selectedCapteur);
            selectedCapteur=modifcont.getCapteur();
            listeDeCapteur.add(selectedCapteur);
        }
    }

    /**
     * Ouverture d'un affichage Digital
     */
    private void affichageDigital(){
        Stage digital=charger("/stationmeteo/ressources/fxml/fenetreDigitale.fxml",new DigitalController(selectedCapteur));
        digital.setTitle("Affichage Numérique");
        digital.show();
    }

    /**
     * Ouverture d'un affichage de Thermometre
     */
    private void affichageThermo(){
        Stage thermo=charger("/stationmeteo/ressources/fxml/fenetreThermo.fxml", new ThermoController(selectedCapteur));
        thermo.setTitle("Affichage Thermomètre");
        thermo.show();
    }

    /**
     * Ouverture d'un affichage avec Icone
     */
    private void affichageIcone(){
        Stage icone=charger("/stationmeteo/ressources/fxml/fenetreIcone.fxml",new IconController(selectedCapteur));
        icone.setTitle("Affichage Pictogramme");
        icone.show();
    }
}
