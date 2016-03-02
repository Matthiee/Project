/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import domein.Leerling;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author simon
 */
public class HoofdMenu extends BorderPane implements View {

    //objecten en controllers
    private Leerling lln;
    private LeerlingController llnController;
    private final SchermController schermController;
    private EvaController evaController;
    
    //top
    private GridPane top;
    private VBox profile;
    private TextField opmerkingenTxt;
    private LeerlingInfoHouder llnInfo;
    //Left
    private GridPane left;
    private Onderdeel schakelaars, vloeistoffen, banden;
    //right
    private GridPane right;
    private Onderdeel gps, stop, tanken;
    //center
    private GridPane center, iconen, evaluatieMid1, evaluatieMid2, attitude;
    private Onderdeel rotonde, rijstroken, stad, snelweg; 
    private ImageView attitudeImg, pijl1, pijl2, pijl3, stuur1, stuur2, stuur3;
    private TextField attitudeTxt;
    //bottom
    private GridPane bottom, evaluatie, gekend;
    private VBox evaSelector;
    private ImageView gekendImg1, gekendImg2, gekendImg3;
    private Veld4Evolutie graphImg;

    public HoofdMenu(Leerling lln, LeerlingController llnController, SchermController schermCtrl, EvaController evaController) {

        //Top of the borderpane
        top = new GridPane();
        profile = new VBox();
        //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.lln = lln;
        this.schermController=schermCtrl;
        this.evaController = evaController; 
       
        //de nodes
        opmerkingenTxt = new TextField("Test text voor de opmerkingen");
        llnInfo = new LeerlingInfoHouder(lln, llnController);
        
        llnInfo.setOnMouseClicked((e)->schermController.setScherm(MainApp.INFO_LLN_ID));
        
        //de opmaak
        opmerkingenTxt.setMaxHeight(60);
        opmerkingenTxt.setMinHeight(60);
        opmerkingenTxt.setMaxWidth(200);
        opmerkingenTxt.setMinWidth(200);
        profile.setMaxHeight(100);
        profile.setMinHeight(100);
        top.setPadding(new Insets(30, 20, 5, 20));
        top.setHgap(400);
        //nodes toevoegen
        profile.getChildren().addAll(llnInfo);
        top.add(opmerkingenTxt, 0, 0);
        top.add(profile, 1, 0);

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
        rijstroken = new Onderdeel("resource/Hoofdmenu/rijstroken",35 ,125, evaController);
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
        stuur1.setOnMouseClicked((e)->schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        stuur2.setOnMouseClicked((e)->schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        stuur3.setOnMouseClicked((e)->schermController.setScherm(MainApp.RIJTECHNIEK_ID));
        pijl1.setOnMouseClicked((e)->schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        pijl2.setOnMouseClicked((e)->schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        pijl3.setOnMouseClicked((e)->schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        evaluatieMid2.setOnMouseClicked((e)->schermController.setScherm(MainApp.VERKEERSTECHNIEK_ID));
        //attitude onder
        attitude = new GridPane();
        //de nodes
        attitudeImg = new ImageView("resource/Hoofdmenu/attitude.png");
        attitudeImg.setOnMouseClicked((e)->schermController.setScherm(MainApp.VELD3ATTITUDE_ID));
        attitudeTxt = new TextField("Attitude dummy text!");
        //opmaak
        attitudeImg.setFitHeight(50);
        attitudeImg.setFitWidth(50);
        attitudeTxt.setMaxSize(200, 50);
        attitudeTxt.setMinSize(200, 50);
        attitude.setAlignment(Pos.CENTER);
        attitude.setMaxSize(800, 80);
        attitude.setMinSize(800, 80);
        attitude.setPadding(new Insets(10, 10, 10, 10));
        attitude.setHgap(50);
        //nodes toevoegen aan attitude
        attitude.add(attitudeImg, 0, 0);
        attitude.add(attitudeTxt, 1, 0);
        //alle 3 de onderdelen toevoegen aan center
            //volgorde laten staan! anders werkt schermcontroller niet goed!
        center.add(iconen, 0, 0, 2, 1);
        center.add(evaluatieMid2, 1, 1);
        center.add(evaluatieMid1, 0, 1);
        center.add(attitude, 0, 2, 2, 1);

        //Bottom of the borderpane
        bottom = new GridPane();
        gekend = new GridPane();
        //de nodes
        graphImg = new Veld4Evolutie(schermController);
        gekendImg1 = new ImageView("resource/Hoofdmenu/gekendGroen.png");
        gekendImg2 = new ImageView("resource/Hoofdmenu/gekendOranje.png");
        gekendImg3 = new ImageView("resource/Hoofdmenu/gekendRood.png");
        evaSelector = new EvaSelector(evaController);
        
        //de opmaak
        //graphImg.setFitHeight(80);
        //graphImg.setFitWidth(200);
        graphImg.minWidth(300);
        graphImg.maxWidth(300);
        graphImg.setTranslateX(50);
        gekendImg1.setFitHeight(50);
        gekendImg1.setFitWidth(100);
        gekendImg2.setFitHeight(50);
        gekendImg2.setFitWidth(100);
        gekendImg3.setFitHeight(50);
        gekendImg3.setFitWidth(100);
        gekendImg1.setFitHeight(50);
        gekend.setMinWidth(300);
        gekend.setMaxWidth(300);
        gekend.setAlignment(Pos.CENTER);
        gekend.setTranslateX(-40);
        evaSelector.setMaxWidth(350);
        evaSelector.setMinWidth(350);
        evaSelector.setTranslateX(-100);
        bottom.setAlignment(Pos.CENTER);
        //de nodes toevoegen
        gekend.add(gekendImg1, 0, 0);
        gekend.add(gekendImg2, 1, 0);
        gekend.add(gekendImg3, 2, 0);
        
        bottom.add(evaSelector, 0, 0);
        bottom.add(gekend, 1, 0);
        bottom.add(graphImg, 2, 0);
        //eventhandler
        evaSelector.setOnMouseClicked((e)->updateOnderdelen());

        //alle onderdelen toevoegen aan de borderpane
        this.setTop(top);
        this.setBottom(bottom);
        this.setCenter(center);
        this.setLeft(left);
        this.setRight(right);
        //opmaak
        this.maxHeight(800);
        this.maxWidth(1200);
        top.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);

        left.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(left, (Onderdeel)c));
        });
        
        right.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(right, (Onderdeel)c));
        });
        
        iconen.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(center, (Onderdeel)c));
        });
        
        updateOnderdelen();
        
        
        //bandenImg.setOnMousePressed((e) -> KleurKiezerHouder.show(left, bandenImg));
    }
    
    public void updateOnderdelen(){
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

    @Override
    public void update() {
        
    }

}
