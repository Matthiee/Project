
package gui;

import controller.SchermController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Veld1Rijtechniek extends GridPane{
    
    //de controllers
    private final SchermController schermController;
    //Afbeeldingen
    private ImageView hellingImg, houdingImg, kijkImg, koppelingImg, remImg, schakelImg, stuurImg;
    private Onderdeel stuuroefImg, achteruitImg, garageImg, kerenImg, parkerenImg;
    private ImageView stuur1Img, stuur2Img, stuur3Img;
    //GridPanes
    private GridPane stuurGp;
    private GridPane links;
    private GridPane rechts;
    //button
    private Button exit;
    
    public Veld1Rijtechniek(SchermController schermCtrl){
        schermController = schermCtrl;
        
        //alle afbeeldingen aanmaken
            //Links
        links = new GridPane();
        remImg = new ImageView("resource/Rijtechniek/rem.png");
        koppelingImg = new ImageView("resource/Rijtechniek/koppeling.png");
        houdingImg = new ImageView("resource/Rijtechniek/houding.png");
        hellingImg = new ImageView("resource/Rijtechniek/helling.png");
        stuuroefImg = new Onderdeel("resource/Rijtechniek/stuuroef");
        achteruitImg = new Onderdeel("resource/Rijtechniek/achteruit");
            //Rechts
        rechts = new GridPane();
        stuurImg = new ImageView("resource/Rijtechniek/stuur.png");
        schakelImg = new ImageView("resource/Rijtechniek/schakel.png");
        kijkImg = new ImageView("resource/Rijtechniek/kijk.png");
        parkerenImg = new Onderdeel("resource/Rijtechniek/parkeren");
        kerenImg = new Onderdeel("resource/Rijtechniek/keren");
        garageImg = new Onderdeel("resource/Rijtechniek/garage");
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
            //links
        links.setAlignment(Pos.CENTER);
        links.setVgap(10);
        remImg.setFitHeight(80);
        remImg.setFitWidth(80);
        remImg.setTranslateX(180);
        remImg.setTranslateY(30);
        koppelingImg.setFitHeight(80);
        koppelingImg.setFitWidth(80);
        koppelingImg.setTranslateX(75);
        houdingImg.setFitHeight(80);
        houdingImg.setFitWidth(80);
        hellingImg.setFitHeight(80);
        hellingImg.setFitWidth(80);
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
        stuurImg.setFitHeight(80);
        stuurImg.setFitWidth(80);
        stuurImg.setTranslateX(-180);
        stuurImg.setTranslateY(30);
        schakelImg.setFitHeight(80);
        schakelImg.setFitWidth(80);
        schakelImg.setTranslateX(-75);
        kijkImg.setFitHeight(80);
        kijkImg.setFitWidth(80);
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
    }
    
}
