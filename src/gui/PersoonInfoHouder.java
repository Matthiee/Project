package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Matthias
 */
public class PersoonInfoHouder extends VBox {
    
    private ImageView imgView;
    private Label lblNaam;
    
    public PersoonInfoHouder(){
        setPadding(new Insets(10));
        setSpacing(10);
        
        setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        
        
        imgView = new ImageView("resource/man-icon.png");
        lblNaam=new Label("Jo De Wit");
        
        this.getChildren().addAll(imgView, lblNaam);
    }
    
    
    
    
    
}
