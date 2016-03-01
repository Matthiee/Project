package controller;

import domein.EvaluatieMoment;
import domein.Leerling;
import java.util.Date;
import javafx.scene.image.Image;

/**
 *
 * @author Matthias
 */
public class LeerlingController {
    private final Leerling leerling;
    
    public LeerlingController(Leerling l){
        this.leerling=l;
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
    
    
    
}
