package gui;

import controller.SchermController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class Veld3Attitude extends FlowPane
{
    private final SchermController schermController;

    public Veld3Attitude(SchermController schermController1){
       schermController=schermController1;

        VBox vBox = new VBox();
        Label lbl1 = new Label("Attitude");
        Label lbl2 = new Label("Vul in of selecteer:");

        TextField test1 = new TextField("");
        TextField test2 = new TextField("");
        TextField test3 = new TextField("");
        TextField test4 = new TextField("");
        TextField test5 = new TextField("");
        TextField test6 = new TextField("");
        TextField test7 = new TextField("");
        TextField test8 = new TextField("");
        TextField test9= new TextField("");
        vBox.getChildren().addAll(lbl1,lbl2,test1,test2,test3,test4,test5,test6,test7,test8,test9);
        vBox.setTranslateX(40);
        //---
         
        VBox vBox2 = new VBox();  
        ListView attitudes = new ListView(FXCollections.
                observableArrayList("Zenuwachtig","rustig","Geconcentreerd","Afgeleid","Bang","Zelfzeker","Ongeduldig","Geduldig")); 
        vBox2.getChildren().addAll(attitudes);
        vBox2.setTranslateX(40);
        vBox2.setTranslateY(10);
        //Exit button
        Button exit = new Button("ga terug");
        exit.setTranslateX(100);
        
        //eventhandler
        exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));
        this.getChildren().addAll(vBox,vBox2,exit);

        
    }
    
    public void update(){
        
    }
    
}
