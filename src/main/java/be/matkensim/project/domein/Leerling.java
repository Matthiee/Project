package be.matkensim.project.domein;

import be.matkensim.project.gui.View;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private int grafiek;
    private EvaluatieMoment eva1;
    private EvaluatieMoment eva2;
    private EvaluatieMoment eva3;
    private int lastSelectedEva; //1=eva1  2=eva2  3=eva3
    private ObservableList<Attitude> attitudeWoorden;
    
    public Leerling(){
      views = new ArrayList<>();
    }

    public Leerling(String naam, String inschrijvingsnr, String instructeur, Date verval, String type, Image image, int grafiek, 
            EvaluatieMoment eva1, EvaluatieMoment eva2, EvaluatieMoment eva3, int lastSelectedEva, ObservableList attitudeWoorden) {
        this();
        
        this.naam = naam;
        this.inschrijvingsnr = inschrijvingsnr;
        this.instructeur = instructeur;
        this.verval = verval;
        this.type = type;
        this.image = image;
        this.grafiek = grafiek;
        this.eva1 = eva1;
        this.eva2 = eva2;
        this.eva3 = eva3;
        this.lastSelectedEva = lastSelectedEva;
        this.attitudeWoorden = attitudeWoorden;
    }
    
    public Leerling(String naam, String inschrijvingsnr, String instructeur, Date verval, String type, Image image) {
        this();
        
        this.naam = naam;
        this.inschrijvingsnr = inschrijvingsnr;
        this.instructeur = instructeur;
        this.verval = verval;
        this.type = type;
        this.image = image;
        this.grafiek = 0;
        this.eva1 = new EvaluatieMoment();
        this.eva2 = new EvaluatieMoment();
        this.eva3 = new EvaluatieMoment();
        this.lastSelectedEva = 1;
        this.attitudeWoorden = FXCollections.observableArrayList();
    }
    
    public ObservableList<Attitude> getAttitudeWoorden() {
        return attitudeWoorden;
    }

    public void setAttitudeWoorden(ObservableList<Attitude> attitudeWoorden) {
        this.attitudeWoorden = attitudeWoorden;
    }

    public int getGrafiek() {
        return grafiek;
    }

    public void setGrafiek(int grafiek) {
        this.grafiek = grafiek;
    }
   

    public EvaluatieMoment getEva1() {
        return eva1;
    }

    public void setEva1(EvaluatieMoment eva1) {
        this.eva1 = eva1;
        update();
    }

    public EvaluatieMoment getEva2() {
        return eva2;
    }

    public void setEva2(EvaluatieMoment eva2) {
        this.eva2 = eva2;
        update();
    }

    public EvaluatieMoment getEva3() {
        return eva3;
        
    }

    public void setEva3(EvaluatieMoment eva3) {
        this.eva3 = eva3;
        update();
    }

    public int getLastSelectedEva() {
        return lastSelectedEva;
    }

    public void setLastSelectedEva(int lastSelectedEva) {
        this.lastSelectedEva = lastSelectedEva;
        update();
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
        for(View v : views){
            v.update();
        }
    }
    
    public List<View> getViews(){
        return views;
    }
}
