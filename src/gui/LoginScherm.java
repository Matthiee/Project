package gui;

import controller.SchermController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class LoginScherm extends VBox
{
    private final SchermController schermController;
    
    public LoginScherm(SchermController schermCtrl) 
    {
        schermController = schermCtrl;
        this.setMinSize(450, 180);
        this.maxHeight(800);
        this.maxWidth(1200);
        this.setPrefSize(1200, 800);
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        
       
        
        Button btnZoek = new Button("Zoek");
        btnZoek.setOnAction(e-> schermController.setScherm(MainApp.ZOEKLEERLING_ID));
        Button btnNieuw = new Button("Nieuw");
        btnNieuw.setOnAction(e-> schermController.setScherm(MainApp.NIEUWELEERLING_ID));
        btnNieuw.setTranslateX(10);

        hBox3.getChildren().addAll(btnZoek,btnNieuw);
        hBox3.setTranslateX(15);
        hBox3.setTranslateY(60);
        
        this.getChildren().addAll(hBox1,hBox2,hBox3);
    }    
}
