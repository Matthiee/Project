
package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Veld1Rijtechniek extends GridPane implements View {
    
    //de controllers
    private final SchermController schermController;
    private final LeerlingController llnController;
    private EvaController evaController;
    //Afbeeldingen
    private EvaOnderdeel hellingImg, houdingImg, kijkImg, koppelingImg, remImg, schakelImg, stuurImg;
    private Onderdeel stuuroefImg, achteruitImg, garageImg, kerenImg, parkerenImg;
    private ImageView stuur1Img, stuur2Img, stuur3Img;
    //GridPanes
    private GridPane stuurGp;
    private GridPane links;
    private GridPane rechts;
    //button
    private Button exit;
    //evaSelector
    private EvaSelector evaSelector;
    
    public Veld1Rijtechniek(LeerlingController llnCntrl, SchermController schermCtrl, EvaController evaCtrl){
        
        schermController = schermCtrl;
        evaController = evaCtrl;
        llnController=llnCntrl;
        llnController.getLeerling().addView(this);
        
        //alle afbeeldingen aanmaken
            //Links
        links = new GridPane();
        remImg = new EvaOnderdeel("resource/Rijtechniek/rem.png", evaController);
        remImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID));
        koppelingImg = new EvaOnderdeel("resource/Rijtechniek/koppeling.png", evaController);
        koppelingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID));
        houdingImg = new EvaOnderdeel("resource/Rijtechniek/houding.png", evaController);
        houdingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID));
        hellingImg = new EvaOnderdeel("resource/Rijtechniek/helling.png", evaController);
        stuuroefImg = new Onderdeel("resource/Rijtechniek/stuuroef",120 ,157, evaController);
        achteruitImg = new Onderdeel("resource/Rijtechniek/achteruit",225 ,127, evaController);
            //Rechts
        rechts = new GridPane();
        stuurImg = new EvaOnderdeel("resource/Rijtechniek/stuur.png", evaController);
        stuurImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID));
        schakelImg = new EvaOnderdeel("resource/Rijtechniek/schakel.png", evaController);
        schakelImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID));
        kijkImg = new EvaOnderdeel("resource/Rijtechniek/kijk.png", evaController);
        kijkImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID));
        parkerenImg = new Onderdeel("resource/Rijtechniek/parkeren", 45, 157, evaController);
        kerenImg = new Onderdeel("resource/Rijtechniek/keren", -30, 155, evaController);
        garageImg = new Onderdeel("resource/Rijtechniek/garage", -135, 127, evaController);
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
        this.setHgap(50);
        this.setPadding(new Insets(50,50,50,50));
            //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(10);
        links.setMaxWidth(50);
        remImg.setMinSize(80, 80);
        remImg.setMaxSize(80, 80);
        remImg.setTranslateX(180);
        remImg.setTranslateY(30);
        koppelingImg.setMinSize(80, 80);
        koppelingImg.setMaxSize(80, 80);
        koppelingImg.setTranslateX(75);
        houdingImg.setMinSize(80, 80);
        houdingImg.setMaxSize(80, 80);
        hellingImg.setMinSize(80, 80);
        hellingImg.setMaxSize(80, 80);
        stuuroefImg.setFitHeight(80);
        stuuroefImg.setFitWidth(80);
        stuuroefImg.setTranslateX(75);
        achteruitImg.setFitHeight(80);
        achteruitImg.setFitWidth(80);
        achteruitImg.setTranslateX(180);
        achteruitImg.setTranslateY(-30);
            //Rechts
        rechts.setAlignment(Pos.CENTER);
        rechts.setVgap(10);
        stuurImg.setMinSize(80, 80);
        stuurImg.setMaxSize(80, 80);
        stuurImg.setTranslateX(-180);
        stuurImg.setTranslateY(30);
        schakelImg.setMinSize(80, 80);
        schakelImg.setMaxSize(80, 80);
        schakelImg.setTranslateX(-75);
        kijkImg.setMinSize(80, 80);
        kijkImg.setMaxSize(80, 80);
        parkerenImg.setFitHeight(80);
        parkerenImg.setFitWidth(80);
        kerenImg.setFitHeight(80);
        kerenImg.setFitWidth(80);
        kerenImg.setTranslateX(-75);
        garageImg.setFitHeight(80);
        garageImg.setFitWidth(80);
        garageImg.setTranslateX(-180);
        garageImg.setTranslateY(-30);
            //Stuur center
        stuurGp.setAlignment(Pos.CENTER);
        stuur1Img.setFitHeight(150);
        stuur1Img.setFitWidth(300);
        stuur2Img.setFitHeight(150);
        stuur2Img.setFitWidth(150);
        stuur3Img.setFitHeight(150);
        stuur3Img.setFitWidth(150);
        stuurGp.setTranslateX(-15);
        
        //exit button + evaSelector
        exit = new Button("ga terug");
        evaSelector = new EvaSelector(evaController);
        //eventhandeler
        exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));
        
        //Alle GridPanes toevoegen aan hoofd GridPane
            //moet in deze volgorde anders werkt kleurkiezer niet!!!!
        this.add(stuurGp, 2 ,0);
        this.add(rechts, 3, 0);
        this.add(links, 1, 0);
        this.add(exit, 3, 1);
        this.add(evaSelector, 1, 1);
        this.setAlignment(Pos.CENTER);
        this.setMaxSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        this.setMinSize(schermCtrl.getBreedte(), schermCtrl.getHoogte());
        this.setTranslateX(-20);
        
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
