
package gui;

import controller.EvaController;
import controller.LeerlingController;
import controller.SchermController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Veld1Rijtechniek extends HBox implements View {
    
    //Images voor stuur
    Image stuur1Neutraal = new Image("resource/Rijtechniek/stuur1Neutraal.png");
    Image stuur1Groen = new Image("resource/Rijtechniek/stuur1Groen.png");
    Image stuur1Oranje = new Image("resource/Rijtechniek/stuur1Oranje.png");
    Image stuur1Rood = new Image("resource/Rijtechniek/stuur1Rood.png");
        
    Image stuur2Neutraal = new Image("resource/Rijtechniek/stuur2Neutraal.png");
    Image stuur2Groen = new Image("resource/Rijtechniek/stuur2Groen.png");
    Image stuur2Oranje = new Image("resource/Rijtechniek/stuur2Oranje.png");
    Image stuur2Rood = new Image("resource/Rijtechniek/stuur2Rood.png");
        
    Image stuur3Neutraal = new Image("resource/Rijtechniek/stuur3Neutraal.png");
    Image stuur3Groen = new Image("resource/Rijtechniek/stuur3Groen.png");
    Image stuur3Oranje = new Image("resource/Rijtechniek/stuur3Oranje.png");
    Image stuur3Rood = new Image("resource/Rijtechniek/stuur3Rood.png");
    
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
    //labels
    private Label kleur, venster;
    private int labelSelected;
    private HBox labels;
    
    public Veld1Rijtechniek(LeerlingController llnCntrl, SchermController schermCtrl, EvaController evaCtrl){
        
        schermController = schermCtrl;
        evaController = evaCtrl;
        llnController=llnCntrl;
        llnController.getLeerling().addView(this);
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        mainGP = new GridPane();       
        
        //labels
        kleur = new Label("Kleur kiezen");
        venster = new Label("Extra vensters");
        
        kleur.setMinSize(80, 30);
        kleur.setMaxSize(80, 30);
        venster.setMinSize(80, 30);
        venster.setMaxSize(80, 30);
        
        
        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        kleur.setAlignment(Pos.CENTER);
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        venster.setAlignment(Pos.CENTER);
        
        kleur.setOnMouseClicked(e -> selecteerKleur());
        venster.setOnMouseClicked(e -> selecteerVenster());
        
        labels = new HBox();
        labels.setSpacing(15);
        labels.setTranslateY(-hoogte*0.83);
        labels.setTranslateX(21);
        labels.getChildren().addAll(kleur, venster);
        
        //alle afbeeldingen aanmaken
            //Links
        links = new GridPane();
        remImg = new Onderdeel("resource/Rijtechniek/rem", 215, 170, evaController);
        koppelingImg = new Onderdeel("resource/Rijtechniek/koppeling", 110, 147, evaController);
        houdingImg = new Onderdeel("resource/Rijtechniek/houding", 30, 147, evaController);
        hellingImg = new Onderdeel("resource/Rijtechniek/helling", 30, 147, evaController);
        stuuroefImg = new Onderdeel("resource/Rijtechniek/stuuroef",110 ,147, evaController);
        achteruitImg = new Onderdeel("resource/Rijtechniek/achteruit",215 ,117, evaController);
        remImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID));
        koppelingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID));
        houdingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID));
            //Rechts
        rechts = new GridPane();
        stuurImg = new Onderdeel("resource/Rijtechniek/stuur", -135, 170, evaController);
        schakelImg = new Onderdeel("resource/Rijtechniek/schakel", -25, 147, evaController);
        kijkImg = new Onderdeel("resource/Rijtechniek/kijk", 40, 147, evaController);
        parkerenImg = new Onderdeel("resource/Rijtechniek/parkeren", 40, 147, evaController);
        kerenImg = new Onderdeel("resource/Rijtechniek/keren", -25, 147, evaController);
        garageImg = new Onderdeel("resource/Rijtechniek/garage", -135, 117, evaController);
        stuurImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID));
        schakelImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID));
        kijkImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID));
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
        mainGP.add(labels, 2, 1);
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
            if (c instanceof Onderdeel && labelSelected == 0)
                 c.setOnMouseClicked((e) -> KleurKiezerHouder.show(rechts, (Onderdeel)c));
        });
        evaSelector.setOnMouseClicked((e)->update());
        
        selecteerKleur();
        update();
    }
    
    public void selecteerKleur(){
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
        labelSelected = 0;
        
        links.getChildren().forEach(c -> {
            if (c instanceof Onderdeel)
                c.setOnMouseClicked((e) -> KleurKiezerHouder.show(links, (Onderdeel)c));
        });
        
        rechts.getChildren().forEach(c -> {
            if (c instanceof Onderdeel && labelSelected == 0)
                 c.setOnMouseClicked((e) -> KleurKiezerHouder.show(rechts, (Onderdeel)c));
        });
        evaSelector.setOnMouseClicked((e)->update());
        
        stuuroefImg.setVisible(true);
        achteruitImg.setVisible(true);
        garageImg.setVisible(true);
        kerenImg.setVisible(true);
        parkerenImg.setVisible(true);
        
        update();
    }
    
    public void selecteerVenster(){
        venster.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
        kleur.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        labelSelected = 1;
        
        remImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKREMTECHNIEK_ID));
        koppelingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKOPPELING_ID));
        houdingImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKHOUDING_ID));
        stuurImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSTUURTECHNIEK_ID));
        schakelImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKSCHAKELTECHNIEK_ID));
        kijkImg.setOnMouseClicked(e -> this.schermController.setScherm(MainApp.VELD1RIJTECHNIEKKIJKTECHNIEK_ID));
        
        stuuroefImg.setVisible(false);
        achteruitImg.setVisible(false);
        garageImg.setVisible(false);
        kerenImg.setVisible(false);
        parkerenImg.setVisible(false);
        
        update();
    }
    
    public void updateStuur(){
        int stuur [] = evaController.loadStuur();
                
        //stuur1
        if(stuur[0] == 0) stuur1Img.setImage(stuur1Neutraal);
        if(stuur[0] == 1) stuur1Img.setImage(stuur1Groen);
        if(stuur[0] == 2) stuur1Img.setImage(stuur1Oranje);
        if(stuur[0] == 3) stuur1Img.setImage(stuur1Rood);
        //stuur2
        if(stuur[1] == 0) stuur2Img.setImage(stuur2Neutraal);
        if(stuur[1] == 1) stuur2Img.setImage(stuur2Groen);
        if(stuur[1] == 2) stuur2Img.setImage(stuur2Oranje);
        if(stuur[1] == 3) stuur2Img.setImage(stuur2Rood);
        //stuur3
        if(stuur[2] == 0) stuur3Img.setImage(stuur3Neutraal);
        if(stuur[2] == 1) stuur3Img.setImage(stuur3Groen);
        if(stuur[2] == 2) stuur3Img.setImage(stuur3Oranje);
        if(stuur[2] == 3) stuur3Img.setImage(stuur3Rood);
    }
    
    public void updateLabels(){
        if(labelSelected == 0)selecteerKleur();
        if(labelSelected == 1)selecteerVenster();
        
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
        updateLabels();
        updateStuur();
    }
    
}
