/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public Leerling(){
      views = new ArrayList<>();
    }

    public Leerling(String naam, String inschrijvingsnr, String instructeur, Date verval, String type, Image image) {
        this();
        
        this.naam = naam;
        this.inschrijvingsnr = inschrijvingsnr;
        this.instructeur = instructeur;
        this.verval = verval;
        this.type = type;
        this.image = image;
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
