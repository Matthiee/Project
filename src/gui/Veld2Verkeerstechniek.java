
package gui;

import controller.EvaController;
import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Veld2Verkeerstechniek extends GridPane implements View {
    
    //de controllers
    private final SchermController schermController;
    private final EvaController evaController;
    //Afbeeldingen
    private EvaOnderdeel afstandImg, inhalenImg, kruisenImg, linksafImg, rechtsafImg, openbareWegImg,
            richtingaanwijzersImg, snelheidImg, verkeerstekensImg, voorrangImg;
    private ImageView pijl1Img, pijl2Img, pijl3Img;
    //GridPanes
    private GridPane pijlGp, links, rechts;
    //button
    private Button exit;
    
    public Veld2Verkeerstechniek(SchermController schermCtrl, EvaController evaCtrl){
        evaController = evaCtrl;
        schermController = schermCtrl;
        
        //alle afbeeldingen
            //Links
        links = new GridPane();
        openbareWegImg = new EvaOnderdeel("resource/Verkeerstechniek/openbareWeg.png", evaController);
        openbareWegImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKPLAATS_ID));
        richtingaanwijzersImg = new EvaOnderdeel("resource/Verkeerstechniek/richtingaanwijzers.png", evaController);
        richtingaanwijzersImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRICHTINGAANWIJZERS_ID));
        rechtsafImg = new EvaOnderdeel("resource/Verkeerstechniek/rechtsaf.png", evaController);
        rechtsafImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKRECHTSAF_ID));
        linksafImg = new EvaOnderdeel("resource/Verkeerstechniek/linksaf.png", evaController);
        linksafImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKLINKSAF_ID));
        kruisenImg = new EvaOnderdeel("resource/Verkeerstechniek/kruisen.png", evaController);
        kruisenImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKKRUISEN_ID));
            //Rechts
        rechts = new GridPane();
        voorrangImg = new EvaOnderdeel("resource/Verkeerstechniek/voorrang.png", evaController);
        voorrangImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVOORRANG_ID));
        verkeerstekensImg = new EvaOnderdeel("resource/Verkeerstechniek/verkeerstekens.png", evaController);
        verkeerstekensImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKVERKEERSTEKENS_ID));
        snelheidImg = new EvaOnderdeel("resource/Verkeerstechniek/snelheid.png", evaController);
        snelheidImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKSNELHEID_ID));
        afstandImg = new EvaOnderdeel("resource/Verkeerstechniek/afstand.png", evaController);
        afstandImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKAFSTAND_ID));
        inhalenImg = new EvaOnderdeel("resource/Verkeerstechniek/inhalen.png", evaController);
        inhalenImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD2VERKEERSTECHNIEKINHALEN_ID));
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
        openbareWegImg.setMinSize(80, 80);
        openbareWegImg.setMaxSize(80, 80);
        openbareWegImg.setTranslateX(180);
        richtingaanwijzersImg.setMinSize(80, 80);
        richtingaanwijzersImg.setMaxSize(80, 80);
        richtingaanwijzersImg.setTranslateX(75);
        richtingaanwijzersImg.setTranslateY(-30);
        rechtsafImg.setMinSize(80, 80);
        rechtsafImg.setMaxSize(80, 80);
        rechtsafImg.setTranslateX(10);
        linksafImg.setMinSize(80, 80);
        linksafImg.setMaxSize(80, 80);
        linksafImg.setTranslateX(75);
        linksafImg.setTranslateY(30);
        kruisenImg.setMinSize(80, 80);
        kruisenImg.setMaxSize(80, 80);
        kruisenImg.setTranslateX(180);
            //rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(20);
        voorrangImg.setMinSize(80, 80);
        voorrangImg.setMaxSize(80, 80);
        voorrangImg.setTranslateX(-180);
        verkeerstekensImg.setMinSize(80, 80);
        verkeerstekensImg.setMaxSize(80, 80);
        verkeerstekensImg.setTranslateX(-75);
        verkeerstekensImg.setTranslateY(-30);
        snelheidImg.setMinSize(80, 80);
        snelheidImg.setMaxSize(80, 80);
        snelheidImg.setTranslateX(-10);
        afstandImg.setMinSize(80, 80);
        afstandImg.setMaxSize(80, 80);
        afstandImg.setTranslateX(-75);
        afstandImg.setTranslateY(30);
        inhalenImg.setMinSize(80, 80);
        inhalenImg.setMaxSize(80, 80);
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
        this.setAlignment(Pos.CENTER);
        this.setTranslateX(-15);
        this.setStyle("-fx-background-color: #003399");
        
    }
    
    @Override
    public void update(){
        
    }
    
    
}
