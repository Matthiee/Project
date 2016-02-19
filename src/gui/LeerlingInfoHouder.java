package gui;

import controller.LeerlingController;
import domein.Leerling;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthias
 */
public class LeerlingInfoHouder extends VBox implements View {
    
    private final ImageView imgView;
    private final Label lblNaam;
    
    private final Leerling lln;
    private final LeerlingController llnController;
    
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
