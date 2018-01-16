/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stationmeteo.java.serialize;

import stationmeteo.java.serialize.xmlclass.XMLSuperCapteur;
import stationmeteo.java.serialize.xmlclass.XMLCapteur;
import stationmeteo.java.serialize.interfaceCap.ISuperCapteurSerialize;
import stationmeteo.java.serialize.interfaceCap.ICapteurSerialize;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import stationmeteo.java.metier.Capteur;
import stationmeteo.java.metier.Icapteur;
import stationmeteo.java.metier.SuperCapteur;

/**
 *Cette classe permet la mis en place de la serialization en XML, celle-ci va
 * manager en quelque sorte le chargement etla sauvegarde dans les fichier XML
 * @author matthias
 */
public class SerializerCapteur implements Serializable {
     
    /**
     *Cette methodes va charger les capteurs inscrit dans le xml dans une liste
     * @return une liste de capteur 
     */
    public List<ICapteurSerialize> chargeCapteur() {
        
        List<ICapteurSerialize> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("capteur.xml"))) {
            result = ((ArrayList<XMLCapteur>) ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
               
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
    /**
     *Cette methodes va charger les Supercapteurs inscrit dans le xml dans une liste
     * @return une liste de SuperCapteur 
     */
    public List<ISuperCapteurSerialize> chargeSuperCapteur() {
        
        List<ISuperCapteurSerialize> result = null;
        try (XMLDecoder ois = new XMLDecoder(new FileInputStream("superCapteur.xml"))) {
            result = ((ArrayList<XMLSuperCapteur>) ois.readObject()).stream().map(n -> n.getModel()).collect(Collectors.toList());
               
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return result;
    }
   
    /**
     *Cette methode va enregistrer dans les différent xml les Capteurs et les 
     * superCapteur
     * @param listCapteur
     */
    public void sauveCapteurs(ArrayList<Icapteur> listCapteur) {
        List<ICapteurSerialize> maListe = new ArrayList();
        List<ISuperCapteurSerialize> listSup= new ArrayList();
        for(int i=0;i<listCapteur.size();i++){
            if(listCapteur.get(i).getClass()==Capteur.class)
                maListe.add((Capteur)listCapteur.get(i));
            if(listCapteur.get(i).getClass()==SuperCapteur.class)
                listSup.add((SuperCapteur)listCapteur.get(i));
        }
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("capteur.xml"))) {
            List<XMLCapteur> bn;
            bn = maListe.stream().map((n)-> new XMLCapteur(n)).collect(Collectors.toList());
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
        }
        try (XMLEncoder oos = new XMLEncoder(new FileOutputStream("superCapteur.xml"))) {
            List<XMLSuperCapteur> bn=new ArrayList();
            XMLSuperCapteur i;
            for (ISuperCapteurSerialize c:listSup){
                i= new XMLSuperCapteur(c);
                bn.add(i);
            }
                
            
            oos.writeObject(bn);
            
        }catch (IOException e) {
            e.printStackTrace();
        }
      
    }    
}

   
