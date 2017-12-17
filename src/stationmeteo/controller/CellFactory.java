package stationmeteo.controller;

import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;
import stationmeteo.java.Capteur;
import stationmeteo.java.Icapteur;

public class CellFactory extends ListCell<Icapteur> {

    protected void updateItem(Capteur item, boolean empty) {
        super.updateItem(item, empty);

        if (item != null) {
            float temp = item.getTemperature();
            setTextFill(isSelected() ? Color.WHITE :
                        temp < 0 ? Color.BLUE : Color.RED);
        }
    }
}
