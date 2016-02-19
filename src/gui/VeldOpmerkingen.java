package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

/**
 *
 * @author Matthias
 */
public class VeldOpmerkingen extends HBox implements View {
    
    private final Label lblOpmerking;
    
    public VeldOpmerkingen(String text){
        
        lblOpmerking=new Label(text);
        lblOpmerking.setFont(new Font(15));
        
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setPrefSize(500, 200);
        
        this.getChildren().add(lblOpmerking);
    }

    @Override
    public void update() {
        // TODO: MVC implementeren
        // lblOpmerking.setText("");
    }
    
    
    
}
