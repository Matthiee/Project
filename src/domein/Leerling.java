package domein;

import gui.View;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.scene.image.Image;

/**
 *
 * @author Matthias
 */
public class Leerling implements Model{
    
    private final List<View> views;
    
    private String naam;
    private String inschrijvingsnr;
    private String instructeur;
    private Date verval;
    private String type;
    private Image image;
    private EvaluatieMoment eva1;
    private EvaluatieMoment eva2;
    private EvaluatieMoment eva3;
    private int lastSelectedEva; //1=eva1  2=eva2  3=eva3
    
    public Leerling(){
      views = new ArrayList<>();
    }

    public Leerling(String naam, String inschrijvingsnr, String instructeur, Date verval, String type, Image image, 
            EvaluatieMoment eva1, EvaluatieMoment eva2, EvaluatieMoment eva3, int lastSelectedEva) {
        this();
        
        this.naam = naam;
        this.inschrijvingsnr = inschrijvingsnr;
        this.instructeur = instructeur;
        this.verval = verval;
        this.type = type;
        this.image = image;
        this.eva1 = eva1;
        this.eva2 = eva2;
        this.eva3 = eva3;
        this.lastSelectedEva = lastSelectedEva;
    }

    public EvaluatieMoment getEva1() {
        return eva1;
    }

    public void setEva1(EvaluatieMoment eva1) {
        this.eva1 = eva1;
    }

    public EvaluatieMoment getEva2() {
        return eva2;
    }

    public void setEva2(EvaluatieMoment eva2) {
        this.eva2 = eva2;
    }

    public EvaluatieMoment getEva3() {
        return eva3;
    }

    public void setEva3(EvaluatieMoment eva3) {
        this.eva3 = eva3;
    }

    public int getLastSelectedEva() {
        return lastSelectedEva;
    }

    public void setLastSelectedEva(int lastSelectedEva) {
        this.lastSelectedEva = lastSelectedEva;
    }
   

    public String getNaam() {
        return naam;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        update();
    }

    public void setNaam(String naam) {
        this.naam = naam;
        update();
    }

    public String getInschrijvingsnr() {
        return inschrijvingsnr;
    }

    public void setInschrijvingsnr(String inschrijvingsnr) {
        this.inschrijvingsnr = inschrijvingsnr;
        update();
    }

    public String getInstructeur() {
        return instructeur;
    }

    public void setInstructeur(String instructeur) {
        this.instructeur = instructeur;
        update();
    }

    public Date getVerval() {
        return verval;
    }

    public void setVerval(Date verval) {
        this.verval = verval;
        update();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        update();
    }
    
    @Override
    public void addView(View view) {
       views.add(view);
    }

    @Override
    public void removeView(View v) {
        views.remove(v);
    }

    @Override
    public void update() {
        views.forEach(View::update);
    }
}
