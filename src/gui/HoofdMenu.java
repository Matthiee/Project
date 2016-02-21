/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.LeerlingController;
import domein.Leerling;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author simon
 */
public class HoofdMenu extends BorderPane{
    //objecten en controllers
    private Leerling lln;
    private LeerlingController llnController;
    //top
    private GridPane top;
    private VBox profile;
    private TextField opmerkingenTxt;
    private ImageView profileImg;
    private Label profileLbl;
    //Left
    private GridPane left;
    private ImageView schakelaarsImg, vloeistoffenImg, bandenImg;
    //right
    private GridPane right;
    private ImageView gpsImg, stopImg, tankenImg;
    //center
    private GridPane center, iconen, evaluatieMid1, evaluatieMid2, attitude;
    private ImageView rotondeImg, rijstrokenImg, stadImg, snelwegImg, attitudeImg, pijl1, pijl2, pijl3, stuur1, stuur2, stuur3;
    private TextField attitudeTxt;
    //bottom
    private GridPane bottom, evaluatie, gekend;
    private ImageView evaluatieImg1, evaluatieImg2, evaluatieImg3, graphImg, gekendImg1, gekendImg2, gekendImg3;
    
    public HoofdMenu(Leerling lln, LeerlingController llnController){
        
        //Top of the borderpane
        top = new GridPane();
        profile = new VBox();
            //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.lln = lln;
            //de nodes
        opmerkingenTxt = new TextField("Test text voor de opmerkingen");
        profileImg = new ImageView(lln.getImage());
        profileLbl = new Label(lln.getNaam());
            //de opmaak
        opmerkingenTxt.setMaxHeight(60);
        opmerkingenTxt.setMinHeight(60);
        opmerkingenTxt.setMaxWidth(200);
        opmerkingenTxt.setMinWidth(200);
        profile.setMaxHeight(100);
        profile.setMinHeight(100);
        profileImg.maxHeight(50);
        profileImg.minHeight(50);
        profileImg.setFitHeight(50);
        profileImg.setFitWidth(50);
        profileLbl.maxHeight(20);
        profileLbl.minHeight(20);
        top.setPadding(new Insets(30, 20, 5, 20));
        top.setHgap(400);
            //nodes toevoegen
        profile.getChildren().addAll(profileImg, profileLbl);
        top.add(opmerkingenTxt, 0, 0);
        top.add(profile, 1, 0);
        
        
        //Left side borderpane
        left = new GridPane();
            //de nodes
        schakelaarsImg = new ImageView("resource/Hoofdmenu/schakelaarsNeutraal.png");
        vloeistoffenImg = new ImageView("resource/Hoofdmenu/vloeistoffenNeutraal.png");
        bandenImg = new ImageView("resource/Hoofdmenu/bandenNeutraal.png");
            //opmaak
        schakelaarsImg.setFitHeight(60);
        schakelaarsImg.setFitWidth(60);
        schakelaarsImg.setTranslateX(20);
        vloeistoffenImg.setFitHeight(60);
        vloeistoffenImg.setFitWidth(60);
        bandenImg.setFitHeight(60);
        bandenImg.setFitWidth(60);
        bandenImg.setTranslateX(20);
        left.setVgap(30);
        left.setPadding(new Insets(20, 20, 20, 50));
        left.setMaxHeight(400);
        left.setMinHeight(400);
        left.setMaxWidth(120);
        left.setMinWidth(120);
            //de nodes toevoegen
        left.add(schakelaarsImg, 0, 0);
        left.add(vloeistoffenImg, 0, 1);
        left.add(bandenImg, 0, 2);
        
        
        //Right side borderpane
        right = new GridPane();
            //de nodes
        tankenImg = new ImageView("resource/Hoofdmenu/tankenNeutraal.png");
        gpsImg = new ImageView("resource/Hoofdmenu/gpsNeutraal.png");
        stopImg = new ImageView("resource/Hoofdmenu/stopNeutraal.png");
            //opmaak
        tankenImg.setFitHeight(60);
        tankenImg.setFitWidth(60);
        tankenImg.setTranslateX(-20);
        gpsImg.setFitHeight(60);
        gpsImg.setFitWidth(60);
        stopImg.setFitHeight(60);
        stopImg.setFitWidth(60);
        stopImg.setTranslateX(-20);
        right.setVgap(30);
        right.setPadding(new Insets(20, 50, 20, 20));
        right.setMaxHeight(400);
        right.setMinHeight(400);
        right.setMaxWidth(120);
        right.setMinWidth(120);
            //de nodes toevoegen
        right.add(tankenImg, 0, 0);
        right.add(gpsImg, 0, 1);
        right.add(stopImg, 0, 2);
        
        
        //Center borderpane
        center = new GridPane();
            //opmaak center
        center.setHgap(100);
        center.setVgap(50);
            //Deze is opgedeeld in 3 onderdelen: iconen(boven), evaluatie(midden) en attitude(onderaan)
            //iconen boven
        iconen = new GridPane();
                //de nodes
        stadImg = new ImageView("resource/Hoofdmenu/stadNeutraal.png");
        snelwegImg = new ImageView("resource/Hoofdmenu/snelwegNeutraal.png");
        rotondeImg = new ImageView("resource/Hoofdmenu/rotondeNeutraal.png");
        rijstrokenImg = new ImageView("resource/Hoofdmenu/rijstrokenNeutraal.png");
                //opmaak
        stadImg.setFitHeight(60);
        stadImg.setFitWidth(60);
        snelwegImg.setFitHeight(60);
        snelwegImg.setFitWidth(60);
        snelwegImg.setTranslateY(-20);
        rotondeImg.setFitHeight(60);
        rotondeImg.setFitWidth(60);
        rotondeImg.setTranslateY(-20);
        rijstrokenImg.setFitHeight(60);
        rijstrokenImg.setFitWidth(60);
        iconen.setAlignment(Pos.CENTER);
        iconen.setMaxSize(800, 80);
        iconen.setMinSize(800, 80);
        iconen.setPadding(new Insets(5, 5, 5, 5));
        iconen.setHgap(30);
                //nodes toevoegen aan iconen
        iconen.add(stadImg, 0, 0);
        iconen.add(snelwegImg, 1, 0);
        iconen.add(rotondeImg, 2, 0);
        iconen.add(rijstrokenImg, 3, 0);
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
        evaluatieMid2.setTranslateX(10);
        
                //nodes toevoegen
        evaluatieMid1.add(stuur1, 0, 0, 2, 1);
        evaluatieMid1.add(stuur2, 0, 1);
        evaluatieMid1.add(stuur3, 1, 1);
        evaluatieMid2.add(pijl1, 0, 0);
        evaluatieMid2.add(pijl2, 1, 0);
        evaluatieMid2.add(pijl3, 0, 1, 2, 1);
            //attitude onder
        attitude = new GridPane();
                //de nodes
        attitudeImg = new ImageView("resource/Hoofdmenu/attitude.png");
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
        center.add(iconen, 0, 0, 2, 1);
        center.add(evaluatieMid1, 0, 1);
        center.add(evaluatieMid2, 1, 1);
        center.add(attitude, 0, 2, 2, 1);
        
        
        //Bottom of the borderpane
        bottom = new GridPane();
        gekend = new GridPane();
        evaluatie = new GridPane();
            //de nodes
        graphImg = new ImageView("resource/Hoofdmenu/dummyGraph.png");
        gekendImg1 = new ImageView("resource/Hoofdmenu/gekendGroen.png");
        gekendImg2 = new ImageView("resource/Hoofdmenu/gekendOranje.png");
        gekendImg3 = new ImageView("resource/Hoofdmenu/gekendRood.png");
        evaluatieImg1 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
        evaluatieImg2 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
        evaluatieImg3 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
            //de opmaak
        graphImg.setFitHeight(80);
        graphImg.setFitWidth(200);
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
        evaluatieImg1.setFitWidth(30);
        evaluatieImg1.setFitHeight(30);
        evaluatieImg2.setFitWidth(30);
        evaluatieImg2.setFitHeight(30);
        evaluatieImg3.setFitWidth(30);
        evaluatieImg3.setFitHeight(30);
        gekend.setMinWidth(300);
        gekend.setMaxWidth(300);
        gekend.setAlignment(Pos.CENTER);
        gekend.setTranslateX(-40);
        evaluatie.setAlignment(Pos.CENTER);
        evaluatie.setMinWidth(300);
        evaluatie.setMaxWidth(300);
        evaluatie.setTranslateX(-120);
        evaluatie.setTranslateY(-20);
        evaluatie.setVgap(5);
        bottom.setAlignment(Pos.CENTER);
            //de nodes toevoegen
        gekend.add(gekendImg1, 0, 0);
        gekend.add(gekendImg2, 1, 0);
        gekend.add(gekendImg3, 2, 0);
        evaluatie.add(evaluatieImg1, 0, 0);
        evaluatie.add(evaluatieImg2, 0, 1);
        evaluatie.add(evaluatieImg3, 0, 2);
        bottom.add(evaluatie, 0, 0);
        bottom.add(gekend, 1, 0);
        bottom.add(graphImg, 2, 0);        
        
        //alle onderdelen toevoegen aan de borderpane
        this.setTop(top);
        this.setLeft(left);
        this.setRight(right);
        this.setBottom(bottom);
        this.setCenter(center);
        //opmaak
        this.maxHeight(800);
        this.maxWidth(1200);
        top.setAlignment(Pos.CENTER);
        left.setAlignment(Pos.CENTER);
        right.setAlignment(Pos.CENTER);
        bottom.setAlignment(Pos.CENTER);
        center.setAlignment(Pos.CENTER);
    }
    
}
