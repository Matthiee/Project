
package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Veld1Rijtechniek extends HBox implements View {
    
    //de controllers
    private final SchermController schermController;
    private final LeerlingController llnController;
    private EvaController evaController;
    //Afbeeldingen
    private Onderdeel hellingImg, houdingImg, kijkImg, koppelingImg, remImg, schakelImg, stuurImg;
    private Onderdeel stuuroefImg, achteruitImg, garageImg, kerenImg, parkerenImg;
    private ImageView stuur1Img, stuur2Img, stuur3Img;
    //GridPanes
    private GridPane stuurGp;
    private GridPane links;
    private GridPane rechts;
    private GridPane mainGP;
    //button
    private Button exit;
    //evaSelector
    private EvaSelector evaSelector;
    //achtergrond
    private ImageView achtergrond;
    //hoogte en breedte scherm
    private int hoogte, breedte;
    
    public Veld1Rijtechniek(LeerlingController llnCntrl, SchermController schermCtrl, EvaController evaCtrl){
        
        schermController = schermCtrl;
        evaController = evaCtrl;
        llnController=llnCntrl;
        llnController.getLeerling().addView(this);
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        mainGP = new GridPane();
        
        //alle afbeeldingen aanmaken
            //Links
        links = new GridPane();
        remImg = new Onderdeel("resource/Rijtechniek/rem", 215, 170, evaController);
        remImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID));
        koppelingImg = new Onderdeel("resource/Rijtechniek/koppeling", 110, 147, evaController);
        koppelingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID));
        houdingImg = new Onderdeel("resource/Rijtechniek/houding", 30, 147, evaController);
        houdingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID));
        hellingImg = new Onderdeel("resource/Rijtechniek/helling", 30, 147, evaController);
        stuuroefImg = new Onderdeel("resource/Rijtechniek/stuuroef",110 ,147, evaController);
        achteruitImg = new Onderdeel("resource/Rijtechniek/achteruit",215 ,117, evaController);
            //Rechts
        rechts = new GridPane();
        stuurImg = new Onderdeel("resource/Rijtechniek/stuur", -135, 170, evaController);
        stuurImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID));
        schakelImg = new Onderdeel("resource/Rijtechniek/schakel", -25, 147, evaController);
        schakelImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID));
        kijkImg = new Onderdeel("resource/Rijtechniek/kijk", 40, 147, evaController);
        kijkImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID));
        parkerenImg = new Onderdeel("resource/Rijtechniek/parkeren", 40, 147, evaController);
        kerenImg = new Onderdeel("resource/Rijtechniek/keren", -25, 147, evaController);
        garageImg = new Onderdeel("resource/Rijtechniek/garage", -135, 117, evaController);
            //Stuur center
        stuurGp = new GridPane();
        stuur1Img = new ImageView("resource/Rijtechniek/stuur1Neutraal.png");
        stuur2Img = new ImageView("resource/Rijtechniek/stuur2Neutraal.png");
        stuur3Img = new ImageView("resource/Rijtechniek/stuur3Neutraal.png");
        
        //GridPane links
        links.add(remImg, 0, 0);
        links.add(koppelingImg, 0, 1);
        links.add(houdingImg, 0, 2);
        links.add(hellingImg, 0, 3);
        links.add(stuuroefImg, 0, 4);
        links.add(achteruitImg, 0, 5);
        
        //GridPane rechts
        rechts.add(stuurImg, 0, 0);
        rechts.add(schakelImg, 0, 1);
        rechts.add(kijkImg, 0, 2);
        rechts.add(parkerenImg, 0, 3);
        rechts.add(kerenImg, 0, 4);
        rechts.add(garageImg, 0, 5);
        
        //GridPane stuurgp
        stuurGp.add(stuur1Img, 0, 0, 2, 1);
        stuurGp.add(stuur2Img, 0, 1);
        stuurGp.add(stuur3Img, 1, 1);
        
        //Opmaak
            //algemeen
        mainGP.setHgap(50);
        
        mainGP.setPadding(new Insets(50,50,50,50));
            //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(30);
        links.setMaxWidth(50);
        remImg.setFitHeight(70);
        remImg.setFitWidth(70);
        remImg.setTranslateX(180);
        remImg.setTranslateY(30);
        koppelingImg.setFitHeight(70);
        koppelingImg.setFitWidth(70);
        koppelingImg.setTranslateX(75);
        houdingImg.setFitHeight(70);
        houdingImg.setFitWidth(70);
        hellingImg.setFitHeight(70);
        hellingImg.setFitWidth(70);
        stuuroefImg.setFitHeight(70);
        stuuroefImg.setFitWidth(70);
        stuuroefImg.setTranslateX(75);
        achteruitImg.setFitHeight(70);
        achteruitImg.setFitWidth(70);
        achteruitImg.setTranslateX(180);
        achteruitImg.setTranslateY(-30);
            //Rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(30);
        rechts.setMaxWidth(50);
        stuurImg.setFitHeight(70);
        stuurImg.setFitWidth(70);
        stuurImg.setTranslateX(-180);
        stuurImg.setTranslateY(30);
        schakelImg.setFitHeight(70);
        schakelImg.setFitWidth(70);
        schakelImg.setTranslateX(-75);
        kijkImg.setFitHeight(70);
        kijkImg.setFitWidth(70);
        parkerenImg.setFitHeight(70);
        parkerenImg.setFitWidth(70);
        kerenImg.setFitHeight(70);
        kerenImg.setFitWidth(70);
        kerenImg.setTranslateX(-75);
        garageImg.setFitHeight(70);
        garageImg.setFitWidth(70);
        garageImg.setTranslateX(-180);
        garageImg.setTranslateY(-30);
            //Stuur center
        stuurGp.setAlignment(Pos.CENTER);
        stuur1Img.setFitHeight(125);
        stuur1Img.setFitWidth(250);
        stuur2Img.setFitHeight(125);
        stuur2Img.setFitWidth(125);
        stuur3Img.setFitHeight(125);
        stuur3Img.setFitWidth(125);
        stuurGp.setTranslateX(-15);
        
        //exit button + evaSelector
        exit = new Button("ga terug");
        evaSelector = new EvaSelector(evaController);
        evaSelector.setTranslateX(-50);
        exit.setTranslateX(50);
        //eventhandeler
        exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));
        
        //Achtergrond
        achtergrond = new ImageView("resource/Rijtechniek/achtergrondRijtechniek.png");
        
        //Alle GridPanes toevoegen aan hoofd GridPane
            //moet in deze volgorde anders werkt kleurkiezer niet!!!!
        
        mainGP.add(stuurGp, 2 ,0);
        mainGP.add(rechts, 3, 0);
        mainGP.add(links, 1, 0);
        mainGP.add(exit, 3, 1);
        mainGP.add(evaSelector, 1, 1);
        mainGP.setAlignment(Pos.CENTER);
        mainGP.setMaxSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        mainGP.setMinSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        mainGP.setTranslateX(-20);
        
        achtergrond.setTranslateX(breedte/2);
        mainGP.setTranslateX(-breedte/2 -30);
        mainGP.setTranslateY(15);
        
        this.getChildren().add(achtergrond);
        this.getChildren().add(mainGP);
        
        links.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(links, (Onderdeel)c));
        });
        
        rechts.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(rechts, (Onderdeel)c));
        });
        evaSelector.setOnMouseClicked((e)->updateOnderdelen());
        
        updateOnderdelen();
    }
    
    public void updateOnderdelen(){
        evaController.loadColorData(stuuroefImg);
        evaController.loadColorData(kerenImg);
        evaController.loadColorData(achteruitImg);
        evaController.loadColorData(parkerenImg);
        evaController.loadColorData(garageImg);
        evaController.loadColorData(remImg);
        evaController.loadColorData(koppelingImg);
        evaController.loadColorData(houdingImg);
        evaController.loadColorData(hellingImg);
        evaController.loadColorData(stuurImg);
        evaController.loadColorData(schakelImg);
        evaController.loadColorData(kijkImg);
    }
    
    public void updateEvaSelector(){
        evaSelector.update();
    }
    
    @Override
    public void update(){
        updateOnderdelen();
        updateEvaSelector();
    }
    
}
