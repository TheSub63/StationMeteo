package stationmeteo.controller;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import stationmeteo.java.Icapteur;

public class CellFactory extends ListCell<Icapteur> {



    protected void updateItem(Icapteur item, boolean empty) {
        System.out.println("Appelée");
        super.updateItem(item, empty);
        System.out.println("update");
        if (item != null) {
            
            float temp = item.getTemperature();
            setTextFill(isSelected() ? Color.WHITE :
                        temp < 0 ? Color.BLUE : Color.RED);
        }
    }
}
