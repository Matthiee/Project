package gui;

import controller.LeerlingController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthias
 */
public class LeerlingInfoHouder extends VBox implements View {
    
    private final Label lblNaam;
    
    private final LeerlingController llnController;
    
    public LeerlingInfoHouder(LeerlingController controller){
        setPadding(new Insets(10));
        setSpacing(10);
        
        this.llnController=controller;
        this.llnController.getLeerling().addView(this);
        
        setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");
        
        
        lblNaam=new Label();
        
        this.getChildren().addAll(lblNaam);
    }

    @Override
    public void update() {
        lblNaam.setText(llnController.getLeerling().getNaam());
    }
    
    
    
    
    
}
