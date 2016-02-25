package gui;

import controller.SchermController;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Kenzo
 */
public class Veld4Evolutie extends VBox {

    private int score = 0;
    private final Label scoreLabel = new Label();
    private Label info = new Label("");
    private final SchermController schermController;

    private Rectangle rectangle1 = new Rectangle(60, 120, Color.WHITE);
    private Rectangle rectangle2 = new Rectangle(60, 140, Color.WHITE);
    private Rectangle rectangle3 = new Rectangle(60, 160, Color.WHITE);
    private Rectangle rectangle4 = new Rectangle(60, 180, Color.WHITE);
    private Rectangle rectangle5 = new Rectangle(60, 200, Color.WHITE);
    private Rectangle rectangle6 = new Rectangle(60, 220, Color.WHITE);
    private Rectangle rectangle7 = new Rectangle(60, 240, Color.WHITE);
    private Rectangle rectangle8 = new Rectangle(60, 260, Color.WHITE);
    private Rectangle rectangle9 = new Rectangle(60, 280, Color.WHITE);
    private Rectangle rectangle10 = new Rectangle(60, 300, Color.WHITE);
    private Rectangle rectangle11 = new Rectangle(60, 320, Color.WHITE);
    private Rectangle rectangle12 = new Rectangle(60, 340, Color.WHITE);
    private Rectangle[] array = {rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6, rectangle7, rectangle8, rectangle9, rectangle10, rectangle11, rectangle12};

    public Veld4Evolutie(SchermController schermController1) {
        schermController = schermController1;

        Button min = new Button("-");
        Button plus = new Button("+");
        Button exit = new Button("ga terug");

        min.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                veranderKleur(geefvorigeRectangle());
            }
        });
        plus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                veranderKleur(geefVolgendeRectangle());
            }
        });

        HBox hbox1 = new HBox();
        HBox hbox2 = new HBox();
        Label text = new Label("Score: ");
        scoreLabel.setText("0");
        
        info.setTranslateX(10);
        hbox2.getChildren().addAll(text, scoreLabel, info);

        rectangle1.setStroke(Color.BLACK);
        rectangle1.setTranslateY(180);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setTranslateY(160);
        rectangle3.setStroke(Color.BLACK);
        rectangle3.setTranslateY(140);
        rectangle4.setStroke(Color.BLACK);
        rectangle4.setTranslateY(120);
        rectangle5.setStroke(Color.BLACK);
        rectangle5.setTranslateY(100);
        rectangle6.setStroke(Color.BLACK);
        rectangle6.setTranslateY(80);
        rectangle7.setStroke(Color.BLACK);
        rectangle7.setTranslateY(60);
        rectangle8.setStroke(Color.BLACK);
        rectangle8.setTranslateY(40);
        rectangle9.setStroke(Color.BLACK);
        rectangle9.setTranslateY(20);
        rectangle10.setStroke(Color.BLACK);
        rectangle10.setTranslateY(0);
        rectangle11.setStroke(Color.BLACK);
        rectangle11.setTranslateY(-20);
        rectangle12.setStroke(Color.BLACK);
        rectangle12.setTranslateY(-40);

        hbox1.getChildren().addAll(rectangle1, rectangle2, rectangle3, rectangle4, rectangle5, rectangle6, rectangle7, rectangle8, rectangle9, rectangle10, rectangle11, rectangle12);
        hbox1.setTranslateY(100);

        min.setTranslateY(80);
        min.setTranslateX(0);
        plus.setTranslateY(50);
        plus.setTranslateX(40);
        exit.setTranslateY(20);
        exit.setTranslateX(80);

        //eventhandler
        exit.setOnAction(e -> this.schermController.setScherm(MainApp.HOOFDMENU_ID));

        this.getChildren().addAll(hbox2, hbox1, min, plus, exit);
    }

    private void updateScore(int inkomend) {
        score = score + inkomend;
        scoreLabel.setText("" + score);
        updateLabel();
    }
    
    private void updateLabel() {
        if (score == 1 || score == 2) {
            info.setText("");
        }
        if (score == 3) {
            info.setText("Klaar om met een begeleider te oefenen in de stageperiode.");
        }
        if (score == 9) {
            info.setText("Klaar om alleen te oefenen in de stageperiode.");
        }
        if (score == 12) {
            info.setText("Klaar voor praktisch examen.");
        }
    }

    private Rectangle veranderKleur(Rectangle rectangle) {
        if (rectangle.getFill() == Color.WHITE) {
            rectangle.setFill(Color.GREEN);
            updateScore(1);
        } else {
            rectangle.setFill(Color.WHITE);
            updateScore(-1);
        }
        return rectangle;
    }

    private Rectangle geefVolgendeRectangle() {
        for (int i = 0; i < array.length; i++) {

            if (array[i].getFill() == Color.WHITE) {
                return array[i];
            }
        }
        return null;
    }

    private Rectangle geefvorigeRectangle() {

        Rectangle rec = null;
        for (int i = 0; i < array.length; i++) {

            if (array[i].getFill() == Color.GREEN) {
                rec = array[i];
            }
        }
        return rec;
    }
}
