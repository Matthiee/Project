
package gui;

import controller.SchermController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Kenzo
 */
public class NieuweLeerling extends Pane
{
    private final SchermController schermController;
    
    private Button showBtn = new Button("Toon");
    private Button exitBtn = new Button("Ga terug");
    private Button saveBtn = new Button("Sla op");
    private Button btnGaDoor = new Button("Ga door");

    private Label naamLbl = new Label("Naam: ");
    private TextField naamFld = new TextField();
    private Label inschrijvingsnummerLbl = new Label("Inschrijvingsnummer: ");
    private TextField inschrijvingsnummerFld = new TextField();
    private Label vervalLbl = new Label("Verval: ");
    private TextField vervalFld = new TextField();
    private Label typeLbl = new Label("Type: ");
    private TextField typeFld = new TextField();
    private Label imageLbl = new Label("Foto: ");
    private TextField imageFld = new TextField();
    
    private Label naamLbl2 = new Label("");
    private Label inschrijvingsnummerLbl2 = new Label("");
    private Label vervalLbl2 = new Label("");
    private Label typeLbl2 = new Label("");
    private Label imageLbl2 = new Label("");
    
    private Label infoOpgeslagen = new Label("");

    public NieuweLeerling(SchermController schermController1)
    {
        schermController=schermController1;
        
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        HBox hBox1 = new HBox();

        exitBtn.setOnAction(e -> this.schermController.setScherm(MainApp.LOGIN_ID));
        showBtn.setOnAction(e->show());
        infoOpgeslagen.setTextFill(Color.RED);
        saveBtn.setOnAction(e->save());
        
        vBox1.setTranslateY(10);
        vBox1.setTranslateX(10);
        vBox2.setTranslateY(30);
        vBox2.setTranslateX(300);
        hBox1.setTranslateY(300);
        hBox1.setTranslateX(10);
        
        naamLbl2.setTranslateY(10);
        inschrijvingsnummerLbl2.setTranslateY(40);
        vervalLbl2.setTranslateY(70);
        typeLbl2.setTranslateY(100);
        imageLbl2.setTranslateY(130);
        infoOpgeslagen.setTranslateY(170);
        saveBtn.setVisible(false);
        btnGaDoor.setVisible(false);
        btnGaDoor.setTranslateY(170);
        
        
        
        btnGaDoor.setOnAction(e-> schermController.setScherm(MainApp.HOOFDMENU_ID));
        
        hBox1.getChildren().addAll(showBtn,exitBtn,saveBtn);
        vBox1.getChildren().addAll(naamLbl,naamFld,inschrijvingsnummerLbl,inschrijvingsnummerFld,vervalLbl, vervalFld,typeLbl,typeFld,imageLbl,imageFld,hBox1);
        vBox2.getChildren().addAll(naamLbl2,inschrijvingsnummerLbl2,vervalLbl2,typeLbl2,imageLbl2,infoOpgeslagen,btnGaDoor);
          
        this.setMinHeight(500);
        this.setMinWidth(500);
        this.getChildren().addAll(vBox1,vBox2,hBox1);
    }
    
    private void show()
    {      
            naamLbl2.setText(naamFld.getText());
            inschrijvingsnummerLbl2.setText(inschrijvingsnummerFld.getText());
            vervalLbl2.setText(vervalFld.getText());
            typeLbl2.setText(typeFld.getText());
            imageLbl2.setText(imageFld.getText());
            infoOpgeslagen.setText("Niet opgeslagen!");
            infoOpgeslagen.setTextFill(Color.RED);
            saveBtn.setVisible(true);  
            btnGaDoor.setVisible(false);
    }
    private void save()
    {      
        if ("".equals(naamLbl2.getText()) || "".equals(inschrijvingsnummerLbl2.getText()) || "".equals(vervalLbl2.getText()) || "".equals(typeLbl2.getText()) ) {
            infoOpgeslagen.setText("Vul alles in!");
            saveBtn.setVisible(false);
        } else 
        {
        infoOpgeslagen.setText("Info opgeslagen!");
        infoOpgeslagen.setTextFill(Color.GREEN);
        naamFld.setText("");
        inschrijvingsnummerFld.setText("");
        vervalFld.setText("");
        typeFld.setText("");
        imageFld.setText("");
        saveBtn.setVisible(false);
        btnGaDoor.setVisible(true);
        }
    }
}
