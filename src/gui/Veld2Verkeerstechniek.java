
package gui;

import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Veld2Verkeerstechniek extends GridPane implements View {
    
    //de controllers
    private final SchermController schermController;
    //Afbeeldingen
    private ImageView afstandImg, inhalenImg, kruisenImg, linksafImg, rechtsafImg, openbareWegImg,
            richtingaanwijzersImg, snelheidImg, verkeerstekensImg, voorrangImg;
    private ImageView pijl1Img, pijl2Img, pijl3Img;
    //GridPanes
    private GridPane pijlGp, links, rechts;
    //button
    private Button exit;
    
    public Veld2Verkeerstechniek(SchermController schermCtrl){
        schermController = schermCtrl;
        
        //alle afbeeldingen
            //Links
        links = new GridPane();
        openbareWegImg = new ImageView("resource/Verkeerstechniek/openbareWeg.png");
        richtingaanwijzersImg = new ImageView("resource/Verkeerstechniek/richtingaanwijzers.png");
        rechtsafImg = new ImageView("resource/Verkeerstechniek/rechtsaf.png");
        linksafImg = new ImageView("resource/Verkeerstechniek/linksaf.png");
        kruisenImg = new ImageView("resource/Verkeerstechniek/kruisen.png");
            //Rechts
        rechts = new GridPane();
        voorrangImg = new ImageView("resource/Verkeerstechniek/voorrang.png");
        verkeerstekensImg = new ImageView("resource/Verkeerstechniek/verkeerstekens.png");
        snelheidImg = new ImageView("resource/Verkeerstechniek/snelheid.png");
        afstandImg = new ImageView("resource/Verkeerstechniek/afstand.png");
        inhalenImg = new ImageView("resource/Verkeerstechniek/inhalen.png");
            //pijlen center
        pijlGp = new GridPane();
        pijl1Img = new ImageView("resource/Verkeerstechniek/pijl1Neutraal.png");
        pijl2Img = new ImageView("resource/Verkeerstechniek/pijl2Neutraal.png");
        pijl3Img = new ImageView("resource/Verkeerstechniek/pijl3Neutraal.png");
        
        //GridPane links
        links.add(openbareWegImg, 0, 0);
        links.add(richtingaanwijzersImg, 0, 1);
        links.add(rechtsafImg, 0, 2);
        links.add(linksafImg, 0, 3);
        links.add(kruisenImg, 0, 4);
        
        //GridPane rechts
        rechts.add(voorrangImg, 0, 0);
        rechts.add(verkeerstekensImg, 0, 1);
        rechts.add(snelheidImg, 0, 2);
        rechts.add(afstandImg, 0, 3);
        rechts.add(inhalenImg, 0, 4);
        
        //GridPane pijlen
        pijlGp.add(pijl1Img, 0, 0);
        pijlGp.add(pijl2Img, 1, 0);
        pijlGp.add(pijl3Img, 0, 1, 2, 1);
        
        //opmaak
            //algemeen
        this.setPadding(new Insets(50,50,50,50));
        this.setHgap(50);
            //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(20);
        openbareWegImg.setFitHeight(80);
        openbareWegImg.setFitWidth(80);
        openbareWegImg.setTranslateX(180);
        richtingaanwijzersImg.setFitHeight(80);
        richtingaanwijzersImg.setFitWidth(80);
        richtingaanwijzersImg.setTranslateX(75);
        richtingaanwijzersImg.setTranslateY(-30);
        rechtsafImg.setFitHeight(80);
        rechtsafImg.setFitWidth(80);
        rechtsafImg.setTranslateX(10);
        linksafImg.setFitHeight(80);
        linksafImg.setFitWidth(80);
        linksafImg.setTranslateX(75);
        linksafImg.setTranslateY(30);
        kruisenImg.setFitHeight(80);
        kruisenImg.setFitWidth(80);
        kruisenImg.setTranslateX(180);
            //rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(20);
        voorrangImg.setFitHeight(80);
        voorrangImg.setFitWidth(80);
        voorrangImg.setTranslateX(-180);
        verkeerstekensImg.setFitHeight(80);
        verkeerstekensImg.setFitWidth(80);
        verkeerstekensImg.setTranslateX(-75);
        verkeerstekensImg.setTranslateY(-30);
        snelheidImg.setFitHeight(80);
        snelheidImg.setFitWidth(80);
        snelheidImg.setTranslateX(-10);
        afstandImg.setFitHeight(80);
        afstandImg.setFitWidth(80);
        afstandImg.setTranslateX(-75);
        afstandImg.setTranslateY(30);
        inhalenImg.setFitHeight(80);
        inhalenImg.setFitWidth(80);
        inhalenImg.setTranslateX(-180);
            //pijlen center
        pijlGp.setAlignment(Pos.CENTER);
        pijlGp.setTranslateY(10);
        pijl1Img.setFitHeight(150);
        pijl1Img.setFitWidth(150);
        pijl2Img.setFitHeight(150);
        pijl2Img.setFitWidth(150);
        pijl3Img.setFitHeight(150);
        pijl3Img.setFitWidth(300);
        
        //Exit button
        exit = new Button("ga terug");
        
        //eventhandler
        exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));
        
        //Alle Gridpanes toevoegen an hoofd GridPane
            //volgorde is belangrijk, niet aanpassen!
        this.add(pijlGp, 2 ,0);
        this.add(rechts, 3, 0);
        this.add(links, 1, 0);
        this.add(exit, 3, 1);        
        
    }
    
    @Override
    public void update(){
        
    }
    
    
}
