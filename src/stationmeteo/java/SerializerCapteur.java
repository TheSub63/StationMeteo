/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

/**
 *
 * @author matthias
 */
public class SerializerCapteur extends Icapteur implements Serializable {
     
    public List<Icapteur> chargeCapteur() {
        List<Icapteur> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("capteur.xml"))) {
            result = ((ArrayList<XMLcapteur>) ois.readObject()).stream().map(XMLcapteur::getModel).collect(Collectors.toList());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    
    public void sauveCapteurs(ArrayList<Icapteur> listCapteur) {
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("capteur.xml"))) {
            List<XMLcapteur> bn = listCapteur.stream().map(XMLcapteur::new).collect(Collectors.toList());
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
        }      
    }

    @Override
    public void setTemperature(float temperature) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
