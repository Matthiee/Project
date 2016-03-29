package gui;

import controller.LeerlingController;
import controller.SchermController;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Veld4Evolutie extends VBox implements View {

    private int score = 0;
    private final Label lblScore = new Label("0");
    private final Label lblInfo = new Label("Begonnen. \nGeeft de evolutie weer.");
    private final SchermController schermController;
    private LeerlingController leerlingController;

    private final Rectangle[] rects = new Rectangle[12];

    private final Button min = new Button("-");
    private final Button plus = new Button("+");

    private final double SCHAAL = 0.20;

    private void maakRects() {
        for (int i = 0; i < 12; i++) {
            Rectangle r = new Rectangle(60 * SCHAAL, (120 + (i * 20)) * SCHAAL, Color.WHITE);
            r.setStroke(Color.BLACK);
            r.setTranslateY((180 - (i * 20)) * SCHAAL);

            rects[i] = r;
        }
    }

    public Veld4Evolutie(SchermController schermController1, LeerlingController llnCtrl) {

        schermController = schermController1;
        leerlingController = llnCtrl;

        min.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                verminder();
            }
        });

        plus.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                vermeerder();
            }
        });

        maakRects();

        HBox boxRects = new HBox(rects);
        HBox hbox2 = new HBox(10, lblInfo);
        HBox hbox3 = new HBox(10, min, boxRects, plus);
        hbox2.setPadding(new Insets(10));
        hbox3.setTranslateY(100 * SCHAAL);

        min.setTranslateY(140 * SCHAAL);
        plus.setTranslateY(140 * SCHAAL);
        min.setMinSize(35, 35);
        min.setMaxSize(35, 35);
        plus.setMinSize(35, 35);
        plus.setMaxSize(35, 35);

        lblInfo.setMinWidth(100);
        lblInfo.setMaxHeight(100);
        lblInfo.setTranslateX(0);
        lblInfo.setTranslateY(0);
        lblInfo.setTextFill(Color.WHITE);
        this.getChildren().addAll(hbox2, hbox3);
    }

    private void updateLabel() {
        if (score < 3) {
            lblInfo.setText("Begonnen. \nGeeft de evolutie weer.");
        } else if (score < 9) {
            lblInfo.setText(("Klaar om met een begeleider \nte oefenen in de stageperiode."));
        } else if (score < 12) {
            lblInfo.setText(("Klaar om alleen te oefenen \nin de stageperiode."));
        } else if (score == 12) {
            lblInfo.setText(("Klaar voor \npraktisch examen."));
        }
    }

    private void verminder() {
        if (score > 0) {
            score--;
            leerlingController.setGrafiek(score);
            update();
        }
    }

    private void vermeerder() {
        if (score < 12) {
            score++;
            leerlingController.setGrafiek(score);
            update();
        }
    }

    @Override
    public void update() {
        score = leerlingController.getGrafiek();
        for (int i = 0; i < 12; i++) {
            if (i < score) {
                rects[i].setFill(Color.GREEN);
            } else {
                rects[i].setFill(Color.WHITE);
            }
        }
        updateLabel();
    }

    private String verkort(String s) {
        return s.replaceAll("(.{30})", "$1\n");
    }
}
