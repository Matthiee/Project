package be.matkensim.project.gui;

import be.matkensim.project.controller.SchermController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class OpslaanWaarschuwing extends GridPane {

    private final SchermController schermController;

    private VBox vBox;
    private HBox hBox1;

    private Label label, label1,label2;
    private Button opslaanBtn, nietopslaanBtn;

    int hoogte, breedte;
    
    public OpslaanWaarschuwing(SchermController schermController, HoofdMenu hoofdMenu) {
        this.schermController = schermController;
        hoogte = this.schermController.getHoogte();
        breedte = this.schermController.getBreedte();

        vBox = new VBox();
        hBox1 = new HBox();

        label = new Label("U wordt afgemeld...\nVergeet niet alles op te slaan!");
        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Color.WHITE);
        label2 = new Label("\nWilt u nu alles opslaan?");
        label2.setFont(Font.font("Verdana", 50));
        label2.setAlignment(Pos.CENTER);
        label2.setTranslateY(-20);
        
        label2.setTextFill(Color.DODGERBLUE);
        label1 = new Label("Info: U kan enkel opslaan als u met de databank verbonden bent."
                + "\nAnders wacht u best met het sluiten van deze applicatie tot u kan verbinden met de databank."
                + "\nU kan nu deze gebruiker toch afmelden en dan later wanneer u terug"
                + "\nmet de databank verbonden bent naar deze terugkeren om deze gebruiker alsnog op te slaan.");
        label1.setTextAlignment(TextAlignment.CENTER);
        label1.setAlignment(Pos.CENTER);
        label1.setTextFill(Color.WHITE);
        
        opslaanBtn = new Button("Opslaan en afmelden");
        opslaanBtn.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:#00D800");
        opslaanBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hoofdMenu.save();
                schermController.setScherm(MainApp.LOGIN_ID);
            }
        });
        nietopslaanBtn = new Button("Afmelden zonder opslaan");
        nietopslaanBtn.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:#A80000");
        nietopslaanBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                schermController.setScherm(MainApp.LOGIN_ID);
            }
        });
        opslaanBtn.setMinHeight(100);
        opslaanBtn.setMaxHeight(100);
        opslaanBtn.setMinWidth(350);
        opslaanBtn.setMaxWidth(350);
        opslaanBtn.setFont(Font.font("Verdana", 20));
        nietopslaanBtn.setMinHeight(100);
        nietopslaanBtn.setMaxHeight(100);
        nietopslaanBtn.setMinWidth(350);
        nietopslaanBtn.setMaxWidth(350);
        nietopslaanBtn.setFont(Font.font("Verdana", 20));

        label.setFont(Font.font("Verdana", 50));
        label1.setFont(Font.font("Verdana", 15));
        vBox.getChildren().addAll(label,label2, label1);
        vBox.setAlignment(Pos.CENTER);
        hBox1.getChildren().addAll(opslaanBtn, nietopslaanBtn);
        hBox1.setSpacing(50);
        hBox1.setTranslateY(50);
        hBox1.setAlignment(Pos.CENTER);
        vBox.setMinHeight(400);
        vBox.setMaxHeight(400);
        vBox.setMinWidth(800);
        vBox.setMaxWidth(800);
        vBox.setStyle("-fx-border-color: #282E54; -fx-border-radius: 10 10 10 10;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: #282B3A;"
                + "-fx-background-radius: 5;");
        this.add(vBox, 0, 0);
        this.add(hBox1, 0, 1);
        this.setMinSize(breedte, hoogte);
        this.setMaxSize(breedte, hoogte);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
    }
}
