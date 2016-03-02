
package gui;

import controller.EvaController;
import controller.LeerlingController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EvaSelector extends VBox{
    
    LeerlingController llnCtrl;
    EvaController evaCtrl;
    Label lbl1, lbl2, lbl3;
    
    public EvaSelector(EvaController evaCtrl){
        this.evaCtrl = evaCtrl;
        lbl1 = new Label("1");
        lbl2 = new Label("2");
        lbl3 = new Label("3");
        
        lbl1.setMaxSize(30, 30);
        lbl1.setMinSize(30, 30);
        lbl2.setMaxSize(30, 30);
        lbl2.setMinSize(30, 30);
        lbl3.setMaxSize(30, 30);
        lbl3.setMinSize(30, 30);
        
        lbl1.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        lbl2.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        lbl3.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        
        lbl1.setAlignment(Pos.CENTER);
        lbl2.setAlignment(Pos.CENTER);
        lbl3.setAlignment(Pos.CENTER);
        
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(lbl1, lbl2, lbl3);
        this.setSpacing(8);
        
        update();
        
        lbl1.setOnMouseClicked((e)->lbl1Selected());
        lbl2.setOnMouseClicked((e)->lbl2Selected());
        lbl3.setOnMouseClicked((e)->lbl3Selected());
        
    }
    
    public void lbl1Selected(){
        evaCtrl.setSelectedEva(1);
        update();
    }
    
    public void lbl2Selected(){
        evaCtrl.setSelectedEva(2);
        update();
    }
    
    public void lbl3Selected(){
        evaCtrl.setSelectedEva(3);
        update();
    }
    
    public void update(){
        lbl1.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        lbl2.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        lbl3.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: WHITE");
        
        if(evaCtrl.getSelectedEva() == 1)lbl1.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
        if(evaCtrl.getSelectedEva() == 2)lbl2.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
        if(evaCtrl.getSelectedEva() == 3)lbl3.setStyle("-fx-border-color: black; -fx-border-width:1; -fx-border-style: solid; -fx-background-color: GREEN");
    }
    
}
