package stationmeteo.controller;

import javafx.scene.control.TextField;
import stationmeteo.java.algorithmes.Algorithme;


public class Verification {
    final static String REGNUM="^-?[0-9]*(.[0-9]+)?$";
    boolean verifInfos(Algorithme selectedAlgo, TextField nomCapteur,TextField idCapteur,TextField actualisationCapteur,
                       TextField temperatureCapteur, TextField onAlgoFixeAfficher1, TextField onAlgoFixeAfficher2,
                       TextField intervalleAlgo) {
        {
            if (selectedAlgo == null) return false;

            if (nomCapteur.getText().isEmpty()
                    || idCapteur.getText().isEmpty()
                    || actualisationCapteur.getText().isEmpty()) return false;

            if (temperatureCapteur.getText().isEmpty()
                    || !temperatureCapteur.getText().matches(REGNUM))
                temperatureCapteur.setText("0");

            if (!idCapteur.getText().matches("^[0-9]+$")
                    || !actualisationCapteur.getText().matches("^[0-9.]*(.[0-9]+)?$"))
                return false;

            if (!onAlgoFixeAfficher1.isDisable()) {

                if (!onAlgoFixeAfficher1.getText().matches(REGNUM) || !onAlgoFixeAfficher2.getText().matches(REGNUM))
                    return false;

                if (Float.parseFloat(onAlgoFixeAfficher1.getText()) >= Float.parseFloat(onAlgoFixeAfficher2.getText()))
                    return false;

            }

            return intervalleAlgo.isDisable() ||
                    intervalleAlgo.getText().matches(REGNUM) &&
                            (!intervalleAlgo.getText().isEmpty() &&
                                    Float.parseFloat(intervalleAlgo.getText()) != 0);
        }
    }
}
