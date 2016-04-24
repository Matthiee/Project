package be.matkensim.project.controller;

import be.matkensim.project.domein.Attitude;
import be.matkensim.project.domein.EvaluatieMoment;
import be.matkensim.project.domein.Leerling;
import be.matkensim.project.gui.View;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class LeerlingController {
    private Leerling leerling;
    private String aandachtsPunt;
    private ObservableList<String> aandachtsPuntenLijst = FXCollections.observableArrayList();
    
    public LeerlingController(Leerling lln){
        this.leerling=lln;
    }

    public Leerling getLeerling() {
        return leerling;
    }

    public void setLeerling(Leerling leerling) {
        
        if (this.leerling!=null){
            List<View> views = this.leerling.getViews();
            
            leerling.getViews().addAll(views);
            this.leerling.getViews().clear();
        }
        
        this.leerling = leerling;
        
        this.leerling.update();
    }
    
    public ObservableList<Attitude> getAttitudeWoorden() {
         return leerling.getAttitudeWoorden();
    }
 
    public void setAttitudeWoorden(ObservableList<Attitude> attitudeWoorden) {
         leerling.setAttitudeWoorden(attitudeWoorden);
    }
    
    public int getGrafiek(){
        return leerling.getGrafiek();
    }
    
    public void setGrafiek(int grafiek){
        leerling.setGrafiek(grafiek);
    }
    
    public EvaluatieMoment getEva1() {
        return leerling.getEva1();
    }
    
    public void setEva1(EvaluatieMoment eva1) {
        leerling.setEva1(eva1);
    }

    public EvaluatieMoment getEva2() {
        return leerling.getEva2();
    }

    public void setEva2(EvaluatieMoment eva2) {
        leerling.setEva2(eva2);
    }

    public EvaluatieMoment getEva3() {
        return leerling.getEva3();
    }

    public void setEva3(EvaluatieMoment eva3) {
        leerling.setEva3(eva3);
    }

    public int getLastSelectedEva() {
        return leerling.getLastSelectedEva();
    }

    public void setLastSelectedEva(int lastSelectedEva) {
        leerling.setLastSelectedEva(lastSelectedEva);
    }
   

    public String getNaam() {
        return leerling.getNaam();
    }

    public Image getImage() {
        return leerling.getImage();
    }

    public void setImage(Image image) {
        leerling.setImage(image);
    }

    public void setNaam(String naam) {
        leerling.setNaam(naam);
    }

    public String getInschrijvingsnr() {
        return leerling.getInschrijvingsnr();
    }

    public void setInschrijvingsnr(String inschrijvingsnr) {
        leerling.setInschrijvingsnr(inschrijvingsnr);
    }

    public String getInstructeur() {
        return leerling.getInstructeur();
    }

    public void setInstructeur(String instructeur) {
        leerling.setInstructeur(instructeur);
    }

    public Date getVerval() {
        return leerling.getVerval();
    }

    public void setVerval(Date verval) {
        leerling.setVerval(verval);
    }

    public String getType() {
        return leerling.getType();
    }

    public void setType(String type) {
        leerling.setType(type);
    } 

   

    public void setAandachtsPunt(String aandachtsPunt) {
        this.aandachtsPunt = aandachtsPunt;
        aandachtsPuntenLijst.add(aandachtsPunt);
    }

    public ObservableList<String> getAandachtsPuntenLijst() {
        return aandachtsPuntenLijst;
    }

  
    
    
}
