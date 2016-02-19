/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.LeerlingController;
import domein.Leerling;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author simon
 */
public class HoofdMenu extends BorderPane{
    //objecten en controllers
    private Leerling lln;
    private LeerlingController llnController;
    private LeerlingInfoHouder lih;
    //top
    private GridPane top;
    private TextField opmerkingenTxt;
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
            //De leerlingen en controller toewijzen           
        this.llnController = llnController;
        this.lln = lln;
            //de nodes
        opmerkingenTxt = new TextField("Test text voor de opmerkingen");
        lih = new LeerlingInfoHouder(lln, llnController);
            //nodes toevoegen
        top.add(opmerkingenTxt, 0, 0);
        top.add(lih, 1, 0);
        
        
        //Left side borderpane
        left = new GridPane();
            //de nodes
        schakelaarsImg = new ImageView("resource/Hoofdmenu/schakelaarsNeutraal.png");
        vloeistoffenImg = new ImageView("resource/Hoofdmenu/vloeistoffenNeutraal.png");
        bandenImg = new ImageView("resource/Hoofdmenu/bandenNeutraal.png");
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
            //de nodes toevoegen
        right.add(tankenImg, 0, 0);
        right.add(gpsImg, 0, 1);
        right.add(stopImg, 0, 2);   
        
        
        //Center borderpane
        center = new GridPane();
            //Deze is opgedeeld in 3 onderdelen: iconen(boven), evaluatie(midden) en attitude(onderaan)
            //iconen boven
        iconen = new GridPane();
                //de nodes
        stadImg = new ImageView("resource/Hoofdmenu/stadNeutraal.png");
        snelwegImg = new ImageView("resource/Hoofdmenu/snelwegNeutraal.png");
        rotondeImg = new ImageView("resource/Hoofdmenu/rotondeNeutraal.png");
        rijstrokenImg = new ImageView("resource/Hoofdmenu/rijstrokenNeutraal.png");
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
                //nodes toevoegen
        evaluatieMid1.add(stuur1, 0, 0);
        evaluatieMid1.add(stuur2, 0, 1);
        evaluatieMid1.add(stuur3, 1, 1);
        evaluatieMid2.add(pijl1, 0, 0);
        evaluatieMid2.add(pijl2, 1, 0);
        evaluatieMid2.add(pijl3, 0, 1);
            //attitude onder
        attitude = new GridPane();
                //de nodes
        attitudeImg = new ImageView("resource/Hoofdmenu/attitude.png");
        attitudeTxt = new TextField("Attitude dummy text!");
                //nodes toevoegen aan attitude
        attitude.add(attitudeImg, 0, 0);
        attitude.add(attitudeTxt, 1, 0);
            //alle 3 de onderdelen toevoegen aan center
        center.add(iconen, 0, 0);
        center.add(evaluatieMid1, 0, 1);
        center.add(evaluatieMid2, 1, 1);
        center.add(attitude, 0, 2);
        
        
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
    }
    
}
