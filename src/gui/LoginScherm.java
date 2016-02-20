package gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class LoginScherm 
{
    
    public void loginscherm() 
    {
        VBox vBox = new VBox();
        vBox.setMinSize(450, 180);
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        
        Label lblNaam = new Label("Naam: ");
        TextField fldNaam = new TextField();
        fldNaam.setTranslateX(110);
        hBox1.getChildren().addAll(lblNaam,fldNaam);
        hBox1.setTranslateX(15);
        hBox1.setTranslateY(15);
        
        Label lblInschrijvingsnr = new Label("Inschrijvingsnummer: ");
        TextField fldInschrijvingsnr = new TextField();
        fldInschrijvingsnr.setTranslateX(12);
        hBox2.getChildren().addAll(lblInschrijvingsnr,fldInschrijvingsnr);
        hBox2.setTranslateX(15);
        hBox2.setTranslateY(40);
        
        Button btnZoek = new Button("Zoek");
        Button btnNieuw = new Button("Nieuw");
        btnNieuw.setTranslateX(10);
        Button btnGaDoor = new Button("Ga door");
        btnGaDoor.setTranslateX(20);
        hBox3.getChildren().addAll(btnZoek,btnNieuw,btnGaDoor);
        hBox3.setTranslateX(15);
        hBox3.setTranslateY(60);
        
        vBox.getChildren().addAll(hBox1,hBox2,hBox3);
    }    
}
