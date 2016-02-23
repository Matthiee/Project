
package gui;

import controller.SchermController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Veld2Verkeerstechniek extends GridPane{
    
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
        
        
    }
    
    
}
