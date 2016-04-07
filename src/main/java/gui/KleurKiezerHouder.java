package gui;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class KleurKiezerHouder extends Pane {

    private Pane pane;
    private Onderdeel ctrl;

    private double SIZE = 30;
    private static boolean ISBEZET = false;

    public KleurKiezerHouder(Pane p, Onderdeel v) {
        pane = p;
        ctrl = v;

        setPadding(new Insets(2));

        Rectangle rectWit, rectGroen, rectOrangje, rectRood;

        rectWit = new Rectangle(SIZE, SIZE, Color.WHITE);
        rectGroen = new Rectangle(SIZE, SIZE, Color.GREEN);
        rectOrangje = new Rectangle(SIZE, SIZE, Color.ORANGE);
        rectRood = new Rectangle(SIZE, SIZE, Color.RED);

        HBox hbox = new HBox(rectWit, rectGroen, rectOrangje, rectRood);
        hbox.setSpacing(2);
        hbox.setPadding(new Insets(2));
        getChildren().add(hbox);

        for (Node node : hbox.getChildren()) {
            node.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
        }

        hbox.setStyle("-fx-border-color: black;");
        ISBEZET = true;

        rectWit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatus(Onderdeel.NEUTRAAL);
            }
        });
        rectGroen.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatus(Onderdeel.GEKEND);
            }
        });
        rectOrangje.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatus(Onderdeel.GEZIEN_NIET_GEKEND);
            }
        });
        rectRood.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                setStatus(Onderdeel.NIET_GEKEND);
            }
        });
    }

    private void setStatus(int status) {
        ctrl.setStatus(status);
        getPane().getChildren().remove(this);
        ISBEZET = false;
    }

    public Pane getPane() {
        return pane;
    }

    public Onderdeel getCtrl() {
        return ctrl;
    }

    public static void show(Pane pane, Onderdeel ctrl) {
        if (ISBEZET == false) {
            KleurKiezerHouder houder = new KleurKiezerHouder(pane, ctrl);

//        System.out.println("TranslateX: " + ctrl.getLayoutX());
//        System.out.println("TranslateY: " + ctrl.getLayoutY());
//        System.out.println("Hoogte: "+ ctrl.getBoundsInLocal().getHeight());
//        System.out.println("Hoogte: "+ ctrl.getBoundsInParent().getHeight());
            houder.setTranslateX(ctrl.getLayoutX() - 50 + ctrl.getTransX() - 20);
            houder.setTranslateY(ctrl.getLayoutY() - ctrl.getBoundsInParent().getHeight() + ctrl.getTransY());

            pane.getChildren().add(houder);
        }
    }
}
