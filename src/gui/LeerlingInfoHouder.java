package gui;

import controller.LeerlingController;
import domein.Leerling;
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
public class LeerlingInfoHouder extends VBox implements View {
    
    private ImageView imgView;
    private Label lblNaam;
    
    private Leerling lln;
    private LeerlingController llnController;
    
    public LeerlingInfoHouder(Leerling lln, LeerlingController controller){
        setPadding(new Insets(10));
        setSpacing(10);
        
        this.lln=lln;
        this.llnController=controller;
        this.lln.addView(this);
        
        setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        
        
        imgView = new ImageView();
        lblNaam=new Label();
        
        this.getChildren().addAll(imgView, lblNaam);
        
        update();
    }

    @Override
    public void update() {
        lblNaam.setText(lln.getNaam());
        imgView.setImage(lln.getImage());
    }
    
    
    
    
    
}
