package be.matkensim.project.gui;

import be.matkensim.project.controller.SchermController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class OpslaanWaarschuwing extends Pane {

    private final SchermController schermController;

    private VBox vBox;
    private HBox hBox1;

    private Label label, label1,label2;
    private Button opslaanBtn, nietopslaanBtn;

    public OpslaanWaarschuwing(SchermController schermController, HoofdMenu hoofdMenu) {
        this.schermController = schermController;

        vBox = new VBox();
        hBox1 = new HBox();

        label = new Label("U wordt afgemeld...\nVergeet niet alles op te slaan!");
        label2 = new Label("\nWilt u nu alles opslaan?");
        label2.setFont(Font.font("Verdana", 50));
        
        label2.setTextFill(Color.DODGERBLUE);
        label1 = new Label("Info: U kan enkel opslaan als u met de databank verbonden bent."
                + "\nAnders wacht u best met het sluiten van deze applicatie tot u kan verbinden met de databank."
                + "\nU kan nu deze gebruiker toch afmelden en dan later wanneer u terug"
                + "\nmet de databank verbonden bent naar deze terugkeren om deze gebruiker alsnog op te slaan.");
        
        opslaanBtn = new Button("Opslaan en afmelden");
        opslaanBtn.setTextFill(Color.DODGERBLUE);
        opslaanBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                hoofdMenu.save();
                schermController.setScherm(MainApp.LOGIN_ID);
            }
        });
        nietopslaanBtn = new Button("Afmelden zonder opslaan");
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
        label1.setTranslateX(0);
        label1.setTranslateY(50);
        vBox.getChildren().addAll(label,label2, label1);
        hBox1.getChildren().addAll(opslaanBtn, nietopslaanBtn);
        hBox1.setTranslateY(500);
        hBox1.setTranslateX(100);
        hBox1.setSpacing(50);
        vBox.setMinHeight(400);
        vBox.setMaxHeight(400);
        vBox.setMinWidth(800);
        vBox.setMaxWidth(800);
        vBox.setTranslateX(100);
        vBox.setTranslateY(50);
        vBox.setStyle("-fx-background-color: lightgray;"
                + "-fx-border-color: black;");
        this.getChildren().addAll(vBox, hBox1);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
    }
}
