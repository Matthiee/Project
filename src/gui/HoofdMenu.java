/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author simon
 */
public class HoofdMenu extends HBox implements View {
    
    //Images voor stuur
    Image stuur1Neutraal = new Image("resource/Hoofdmenu/stuur1Neutraal.png");
    Image stuur1Groen = new Image("resource/Hoofdmenu/stuur1Groen.png");
    Image stuur1Oranje = new Image("resource/Hoofdmenu/stuur1Oranje.png");
    Image stuur1Rood = new Image("resource/Hoofdmenu/stuur1Rood.png");
        
    Image stuur2Neutraal = new Image("resource/Hoofdmenu/stuur2Neutraal.png");
    Image stuur2Groen = new Image("resource/Hoofdmenu/stuur2Groen.png");
    Image stuur2Oranje = new Image("resource/Hoofdmenu/stuur2Oranje.png");
    Image stuur2Rood = new Image("resource/Hoofdmenu/stuur2Rood.png");
        
    Image stuur3Neutraal = new Image("resource/Hoofdmenu/stuur3Neutraal.png");
    Image stuur3Groen = new Image("resource/Hoofdmenu/stuur3Groen.png");
    Image stuur3Oranje = new Image("resource/Hoofdmenu/stuur3Oranje.png");
    Image stuur3Rood = new Image("resource/Hoofdmenu/stuur3Rood.png");
    
    //Images voor pijlen
    Image pijl1Neutraal = new Image("resource/Hoofdmenu/stuur1Neutraal.png");
    Image pijl1Groen = new Image("resource/Hoofdmenu/stuur1Groen.png");
    Image pijl1Oranje = new Image("resource/Hoofdmenu/stuur1Oranje.png");
    Image pijl1Rood = new Image("resource/Hoofdmenu/stuur1Rood.png");
        
    Image pijl2Neutraal = new Image("resource/Hoofdmenu/stuur2Neutraal.png");
    Image pijl2Groen = new Image("resource/Hoofdmenu/stuur2Groen.png");
    Image pijl2Oranje = new Image("resource/Hoofdmenu/stuur2Oranje.png");
    Image pijl2Rood = new Image("resource/Hoofdmenu/stuur2Rood.png");
        
    Image pijl3Neutraal = new Image("resource/Hoofdmenu/stuur3Neutraal.png");
    Image pijl3Groen = new Image("resource/Hoofdmenu/stuur3Groen.png");
    Image pijl3Oranje = new Image("resource/Hoofdmenu/stuur3Oranje.png");
    Image pijl3Rood = new Image("resource/Hoofdmenu/stuur3Rood.png");

    //objecten en controllers
    private LeerlingController llnController;
    private final SchermController schermController;
    private EvaController evaController;

    //main borderpane
    private BorderPane bp;

    //hoogte en breedte van het venster
    private int hoogte, breedte;
    //achtergrond
    private ImageView achtergrond;
    //top
    private GridPane top;
    private TextArea opmerkingenTxt;
    private LeerlingInfoHouder llnInfo;
    //Left
    private GridPane left;
    private Onderdeel schakelaars, vloeistoffen, banden;
    //right
    private GridPane right;
    private Onderdeel gps, stop, tanken;
    //center
    private GridPane center, iconen, evaluatieMid1, evaluatieMid2;
    private Onderdeel rotonde, rijstroken, stad, snelweg;
    private ImageView attitudeImg, pijl1, pijl2, pijl3, stuur1, stuur2, stuur3;
    //bottom
    private GridPane bottom;
    private EvaSelector evaSelector;
    private Veld4Evolutie graphImg;

    public HoofdMenu(LeerlingController llnController, SchermController schermCtrl, EvaController evaCtrl) {

        //hoogte en breedte
        hoogte = schermCtrl.getHoogte();
        breedte = schermCtrl.getBreedte();

        //Top of the borderpane
        top = new GridPane();
        //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.llnController.getLeerling().addView(this);
        this.schermController = schermCtrl;
        this.evaController = evaCtrl;

        //de nodes
        llnInfo = new LeerlingInfoHouder(llnController);

        llnInfo.setOnMouseClicked((e) -> schermController.setScherm(MainApp.INFO_LLN_ID));

        attitudeImg = new ImageView("resource/Hoofdmenu/attitude.png");
        attitudeImg.setOnMouseClicked((e) -> schermController.setScherm(MainApp.VELD3ATTITUDE_ID));

        //de opmaak
        top.setPadding(new Insets(30, 20, 5, 20));
        top.setHgap(650);
        top.setMinHeight(140);
        //nodes toevoegen

        top.add(attitudeImg, 0, 0);
        top.add(llnInfo, 1, 0);

        //Left side borderpane
        left = new GridPane();
        //de nodes
        schakelaars = new Onderdeel("resource/Hoofdmenu/schakelaars", 10, 35, evaController);

        vloeistoffen = new Onderdeel("resource/Hoofdmenu/vloeistoffen", -10, 35, evaController);

        banden = new Onderdeel("resource/Hoofdmenu/banden", 10, 35, evaController);

        //opmaak
        schakelaars.setFitHeight(60);
        schakelaars.setFitWidth(60);
        schakelaars.setTranslateX(20);
        vloeistoffen.setFitHeight(60);
        vloeistoffen.setFitWidth(60);
        banden.setFitHeight(60);
        banden.setFitWidth(60);
        banden.setTranslateX(20);
        left.setVgap(30);
        left.setPadding(new Insets(20, 20, 20, 50));
        left.setMaxHeight(400);
        left.setMinHeight(400);
        left.setMaxWidth(120);
        left.setMinWidth(120);
        //de nodes toevoegen
        left.add(schakelaars, 0, 0);
        left.add(vloeistoffen, 0, 1);
        left.add(banden, 0, 2);

        //Right side borderpane
        right = new GridPane();
        //de nodes
        tanken = new Onderdeel("resource/Hoofdmenu/tanken", 0, 35, evaController);

        gps = new Onderdeel("resource/Hoofdmenu/gps", 15, 35, evaController);

        stop = new Onderdeel("resource/Hoofdmenu/stop", 0, 35, evaController);
        //opmaak
        tanken.setFitHeight(60);
        tanken.setFitWidth(60);
        tanken.setTranslateX(-20);
        gps.setFitHeight(60);
        gps.setFitWidth(60);

        stop.setFitHeight(60);
        stop.setFitWidth(60);
        stop.setTranslateX(-20);
        right.setVgap(30);
        right.setPadding(new Insets(20, 50, 20, 20));
        right.setMaxHeight(400);
        right.setMinHeight(400);
        right.setMaxWidth(120);
        right.setMinWidth(120);
        right.setTranslateX(8);
        //de nodes toevoegen
        right.add(tanken, 0, 0);
        right.add(gps, 0, 1);
        right.add(stop, 0, 2);

        //Center borderpane
        center = new GridPane();
        //opmaak center
        center.setHgap(100);
        center.setVgap(50);
        //Deze is opgedeeld in 3 onderdelen: iconen(boven), evaluatie(midden) en attitude(onderaan)
        //iconen boven
        iconen = new GridPane();
        //de nodes
        stad = new Onderdeel("resource/Hoofdmenu/stad", 35, 125, evaController);
        snelweg = new Onderdeel("resource/Hoofdmenu/snelweg", 35, 100, evaController);
        rotonde = new Onderdeel("resource/Hoofdmenu/rotonde", 35, 100, evaController);
        rijstroken = new Onderdeel("resource/Hoofdmenu/rijstroken", 35, 125, evaController);
        //opmaak
        stad.setFitHeight(60);
        stad.setFitWidth(60);
        snelweg.setFitHeight(60);
        snelweg.setFitWidth(60);
        snelweg.setTranslateY(-20);
        rotonde.setFitHeight(60);
        rotonde.setFitWidth(60);
        rotonde.setTranslateY(-20);
        rijstroken.setFitHeight(60);
        rijstroken.setFitWidth(60);
        iconen.setAlignment(Pos.CENTER);
        iconen.setMaxSize(800, 80);
        iconen.setMinSize(800, 80);
        iconen.setPadding(new Insets(5, 5, 5, 5));
        iconen.setHgap(30);
        //nodes toevoegen aan iconen
        iconen.add(stad, 0, 0);
        iconen.add(snelweg, 1, 0);
        iconen.add(rotonde, 2, 0);
        iconen.add(rijstroken, 3, 0);
        //evaluatie midden
        evaluatieMid1 = new GridPane();
        evaluatieMid2 = new GridPane();
        //de nodes
        pijl1 = new ImageView("resource/Hoofdmenu/pijl1Neutraal.png");
        pijl2 = new ImageView("resource/Hoofdmenu/pijl2Neutraal.png");
        pijl3 = new ImageView("resource/Hoofdmenu/pijl3Neutraal.png");
        stuur1 = new ImageView("resource/Hoofdmenu/stuur1Neutraal.png");
        stuur2 = new ImageView("resource/Hoofdmenu/stuur2Neutraal.png");
        stuur3 = new ImageView("resource/Hoofdmenu/stuur3Neutraal.png");
        //opmaak
        pijl1.setFitHeight(80);
        pijl1.setFitWidth(80);
        pijl2.setFitHeight(80);
        pijl2.setFitWidth(80);
        pijl3.setFitHeight(80);
        pijl3.setFitWidth(160);
        stuur1.setFitHeight(80);
        stuur1.setFitWidth(160);
        stuur2.setFitHeight(80);
        stuur2.setFitWidth(80);
        stuur3.setFitHeight(80);
        stuur3.setFitWidth(80);
        evaluatieMid1.setMaxHeight(160);
        evaluatieMid1.setMinHeight(160);
        evaluatieMid1.setPadding(new Insets(5, 5, 5, 5));
        evaluatieMid1.setAlignment(Pos.CENTER);
        evaluatieMid1.setTranslateX(200);
        evaluatieMid2.setMaxHeight(160);
        evaluatieMid2.setMinHeight(160);
        evaluatieMid2.setPadding(new Insets(5, 5, 5, 5));
        evaluatieMid2.setAlignment(Pos.CENTER);
        evaluatieMid2.setTranslateX(0);

        //nodes toevoegen
        evaluatieMid1.add(stuur1, 0, 0, 2, 1);
        evaluatieMid1.add(stuur2, 0, 1);
        evaluatieMid1.add(stuur3, 1, 1);
        evaluatieMid2.add(pijl1, 0, 0);
        evaluatieMid2.add(pijl2, 1, 0);
        evaluatieMid2.add(pijl3, 0, 1, 2, 1);
        //eventhandler
        stuur1.setOnMouseClicked((e) -> schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        stuur2.setOnMouseClicked((e) -> schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        stuur3.setOnMouseClicked((e) -> schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        pijl1.setOnMouseClicked((e) -> schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        pijl2.setOnMouseClicked((e) -> schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        pijl3.setOnMouseClicked((e) -> schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        evaluatieMid2.setOnMouseClicked((e) -> schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));

        //alle 3 de onderdelen toevoegen aan center
        //volgorde laten staan! anders werkt schermcontroller niet goed!
        center.add(iconen, 0, 0, 2, 1);
        center.add(evaluatieMid2, 1, 1);
        center.add(evaluatieMid1, 0, 1);

        //Bottom of the borderpane
        bottom = new GridPane();
        //de nodes
        graphImg = new Veld4Evolutie(schermController, this.llnController);
        evaSelector = new EvaSelector(evaController);
        opmerkingenTxt = new TextArea();
        opmerkingenTxt.setPrefRowCount(10);
        opmerkingenTxt.setWrapText(true);

        //de opmaak
        graphImg.minWidth(300);
        graphImg.maxWidth(300);
        graphImg.setTranslateX(110);
        graphImg.setTranslateY(-20);
        evaSelector.setTranslateX(-100);
        evaSelector.setTranslateY(-60);
        attitudeImg.setFitHeight(50);
        attitudeImg.setFitWidth(50);
        opmerkingenTxt.setMaxSize(350, 200);
        opmerkingenTxt.setMinSize(350, 200);
        opmerkingenTxt.setTranslateX(65);
        opmerkingenTxt.setTranslateY(-20);
        bottom.setAlignment(Pos.CENTER);

        //de nodes toevoegen      
        bottom.add(evaSelector, 0, 0);
        bottom.add(opmerkingenTxt, 1, 0);
        bottom.add(graphImg, 2, 0);
        //eventhandler
        evaSelector.setOnMouseClicked((e) -> update());
        //achtergrond
        //this.setStyle("-fx-background-image: url('resource/Hoofdmenu/achtergrondHoofdmenu.jpg')");
        achtergrond = new ImageView("resource/Hoofdmenu/achtergrondHoofdmenu.png");
        achtergrond.setFitHeight(hoogte);
        achtergrond.setFitWidth(breedte);
        achtergrond.setTranslateX(breedte / 2 + 8);

        //alle onderdelen toevoegen aan de borderpane
        bp = new BorderPane();
        bp.setTop(top);
        bp.setBottom(bottom);
        bp.setCenter(center);
        bp.setLeft(left);
        bp.setRight(right);
        bp.setTranslateX(-breedte / 2);

        this.getChildren().add(achtergrond);
        this.getChildren().add(bp);
        //opmaak
        this.maxHeight(hoogte);
        this.maxWidth(breedte);
        this.setAlignment(Pos.CENTER);

        top.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);
        center.setTranslateY(-30);

        left.getChildren().forEach(c -> {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(left, (Onderdeel) c));
            }
        });

        right.getChildren().forEach(c -> {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(right, (Onderdeel) c));
            }
        });

        iconen.getChildren().forEach(c -> {
            if (c instanceof Onderdeel) {
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(center, (Onderdeel) c));
            }
        });

        update();

        //bandenImg.setOnMousePressed((e) -> KleurKiezerHouder.show(left, bandenImg));
    }
    
    public void updateStuur(){
        int stuur [] = evaController.loadStuur();
                
        //stuur1
        if(stuur[0] == 0) stuur1.setImage(stuur1Neutraal);
        if(stuur[0] == 1) stuur1.setImage(stuur1Groen);
        if(stuur[0] == 2) stuur1.setImage(stuur1Oranje);
        if(stuur[0] == 3) stuur1.setImage(stuur1Rood);
        //stuur2
        if(stuur[1] == 0) stuur2.setImage(stuur2Neutraal);
        if(stuur[1] == 1) stuur2.setImage(stuur2Groen);
        if(stuur[1] == 2) stuur2.setImage(stuur2Oranje);
        if(stuur[1] == 3) stuur2.setImage(stuur2Rood);
        //stuur3
        if(stuur[2] == 0) stuur3.setImage(stuur3Neutraal);
        if(stuur[2] == 1) stuur3.setImage(stuur3Groen);
        if(stuur[2] == 2) stuur3.setImage(stuur3Oranje);
        if(stuur[2] == 3) stuur3.setImage(stuur3Rood);
    }
    
    public void updatePijlen(){
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

    public void updateOnderdelen() {
        //left
        evaController.loadColorData(schakelaars);
        evaController.loadColorData(vloeistoffen);
        evaController.loadColorData(banden);
        //right
        evaController.loadColorData(gps);
        evaController.loadColorData(stop);
        evaController.loadColorData(tanken);
        //center
        evaController.loadColorData(rotonde);
        evaController.loadColorData(rijstroken);
        evaController.loadColorData(stad);
        evaController.loadColorData(snelweg);
    }

    public void updateEvaSelector() {
        evaSelector.update();
    }

    public void updateGrafiek() {
        graphImg.update();
    }

    @Override
    public void update() {
        updateOnderdelen();
        updateEvaSelector();
        updateGrafiek();
        updateStuur();
        updatePijlen();
    }

}
