
package gui;

import controller.EvaController;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import static javafx.scene.layout.Region.USE_PREF_SIZE;

public class EvaOnderdeel extends HBox{
    
    private EvaController evaController;
    
    private String base;
    
    private GridPane rectGP;
    private ImageView rect1, rect2, rect3;
    private ImageView icon;
    
    public EvaOnderdeel(String base, EvaController evaController){
        //nodes aanmaken
        this.evaController = evaController;
        
        this.base = base;
        
        rectGP = new GridPane();
        rect1 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
        rect2 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
        rect3 = new ImageView("resource/Hoofdmenu/evaluatieNeutraal.png");
        
        icon = new ImageView(base);
        
        //opmaak nodes
        icon.setFitHeight(60);
        icon.setFitWidth(60);
        rect1.setFitHeight(15);
        rect1.setFitWidth(15);
        rect2.setFitHeight(15);
        rect2.setFitWidth(15);
        rect3.setFitHeight(15);
        rect3.setFitWidth(15);
        rectGP.setVgap(5);
        rectGP.setMinSize(15, 80);
        rectGP.setMaxSize(15, 80);
        rectGP.setAlignment(Pos.CENTER);
        this.setMaxSize(80, 80);
        this.setMinSize(80, 80);
        this.setSpacing(5);
        this.setAlignment(Pos.CENTER);
        
        //nodes laden in GridPane
        rectGP.add(rect1, 0, 0);
        rectGP.add(rect2, 0, 1);
        rectGP.add(rect3, 0, 2);
        //nodes toevoegen aan HBox
        this.getChildren().addAll(icon, rectGP);        
    }
}
