
package gui;

import controller.EvaController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Pijl extends GridPane{
    private EvaController evaController;
    
    private ImageView pijl1, pijl2, pijl3;
    
    //Images voor pijlen
    Image pijl1Neutraal = new Image("resource/Pijlen/pijl1Neutraal.png");
    Image pijl1Groen = new Image("resource/Pijlen/pijl1Groen.png");
    Image pijl1Oranje = new Image("resource/Pijlen/pijl1Oranje.png");
    Image pijl1Rood = new Image("resource/Pijlen/pijl1Rood.png");
        
    Image pijl2Neutraal = new Image("resource/Pijlen/pijl2Neutraal.png");
    Image pijl2Groen = new Image("resource/Pijlen/pijl2Groen.png");
    Image pijl2Oranje = new Image("resource/Pijlen/pijl2Oranje.png");
    Image pijl2Rood = new Image("resource/Pijlen/pijl2Rood.png");
        
    Image pijl3Neutraal = new Image("resource/Pijlen/pijl3Neutraal.png");
    Image pijl3Groen = new Image("resource/Pijlen/pijl3Groen.png");
    Image pijl3Oranje = new Image("resource/Pijlen/pijl3Oranje.png");
    Image pijl3Rood = new Image("resource/Pijlen/pijl3Rood.png");
    
    public Pijl(EvaController evaCtrl) {
        evaController = evaCtrl;
        
        pijl1 = new ImageView("resource/Pijlen/pijl1Neutraal.png");
        pijl2 = new ImageView("resource/Pijlen/pijl2Neutraal.png");
        pijl3 = new ImageView("resource/Pijlen/pijl3Neutraal.png");
        
        pijl1.setFitHeight(80);
        pijl1.setFitWidth(80);
        pijl2.setFitHeight(80);
        pijl2.setFitWidth(80);
        pijl3.setFitHeight(80);
        pijl3.setFitWidth(160);
        
        this.setMinSize(160, 160);
        this.setMaxSize(160, 160);
        
        this.add(pijl1, 0, 0);
        this.add(pijl2, 1, 0);
        this.add(pijl3, 0, 1, 2, 1);
    }
    
    public void update(){
        int pijl [] = evaController.loadPijlen();
                
        //stuur1
        if(pijl[0] == 0) pijl1.setImage(pijl1Neutraal);
        if(pijl[0] == 1) pijl1.setImage(pijl1Groen);
        if(pijl[0] == 2) pijl1.setImage(pijl1Oranje);
        if(pijl[0] == 3) pijl1.setImage(pijl1Rood);
        //stuur2
        if(pijl[1] == 0) pijl2.setImage(pijl2Neutraal);
        if(pijl[1] == 1) pijl2.setImage(pijl2Groen);
        if(pijl[1] == 2) pijl2.setImage(pijl2Oranje);
        if(pijl[1] == 3) pijl2.setImage(pijl2Rood);
        //stuur3
        if(pijl[2] == 0) pijl3.setImage(pijl3Neutraal);
        if(pijl[2] == 1) pijl3.setImage(pijl3Groen);
        if(pijl[2] == 2) pijl3.setImage(pijl3Oranje);
        if(pijl[2] == 3) pijl3.setImage(pijl3Rood);
    }
}
