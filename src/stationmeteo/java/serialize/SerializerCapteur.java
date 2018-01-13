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
import javafx.beans.property.FloatProperty;
import stationmeteo.java.Capteur;
import stationmeteo.java.Icapteur;
import stationmeteo.java.SuperCapteur;

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
    public List<ISuperCapteurSerialize> chargeSuperCapteur() {
        
        List<ISuperCapteurSerialize> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("superCapteur.xml"))) {
            result = ((ArrayList<XMLSuperCapteur>) ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
               
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    public List<Icapteur>chargeIcapte(){
      List<Icapteur> result= null;
      List<ICapteurSerialize>capList=chargeCapteur();
      
      
      for(int i=0;i<capList.size();i++){
        result.add((Capteur)capList.get(i));
      }
      List<ISuperCapteurSerialize> supList=chargeSuperCapteur();
      for(int i=0;i<supList.size();i++){
        result.add((SuperCapteur)supList.get(i));
      }
      return result;
    }

    
    public void sauveCapteurs(ArrayList<Icapteur> listCapteur) {
        List<ICapteurSerialize> maListe = new ArrayList();
        List<ISuperCapteurSerialize> listSup= new ArrayList();
        for(int i=0;i<listCapteur.size();i++)
            if(listCapteur.get(i).getClass()==Capteur.class)
                maListe.add((Capteur)listCapteur.get(i));
            else listSup.add((SuperCapteur)listCapteur.get(i));
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("capteur.xml"))) {
            List<XMLcapteur> bn;
            bn = maListe.stream().map((n)-> new XMLcapteur(n)).collect(Collectors.toList());
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("superCapteur.xml"))) {
            List<XMLSuperCapteur> bn;
            bn = listSup.stream().map((n)-> new XMLSuperCapteur(n)).collect(Collectors.toList());
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
      
    }    
}

    @Override
    public FloatProperty temperatureProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
