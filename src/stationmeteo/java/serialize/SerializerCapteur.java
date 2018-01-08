/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import stationmeteo.java.Capteur;
import stationmeteo.java.Icapteur;

/**
 *
 * @author matthias
 */
public class SerializerCapteur extends Icapteur implements Serializable {
     
    public List<ICapteurSerialize> chargeCapteur() {
        
        List<ICapteurSerialize> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("capteur.xml"))) {
            result = ((ArrayList<XMLcapteur>) ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
               
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }

    
    public void sauveCapteurs(ArrayList<Icapteur> listCapteur) {
        List<ICapteurSerialize> maListe = new ArrayList();
        for(int i=0;i<listCapteur.size();i++)
            if(listCapteur.get(i).getClass()==Capteur.class)
                maListe.add((Capteur)listCapteur.get(i));
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("capteur.xml"))) {
            List<XMLcapteur> bn;
            bn = maListe.stream().map((n)-> new XMLcapteur(n)).collect(Collectors.toList());
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
        }catch(Exception e){
            
        }      
    }

  

    
}
