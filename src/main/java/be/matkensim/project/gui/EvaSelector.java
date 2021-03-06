package be.matkensim.project.gui;

import be.matkensim.project.controller.EvaController;
import be.matkensim.project.controller.LeerlingController;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class EvaSelector extends HBox {

    private LeerlingController llnCtrl;
    private EvaController evaCtrl;
    private Button lbl1, lbl2, lbl3;

    public EvaSelector(EvaController evaCtrl) {
        this.evaCtrl = evaCtrl;
        lbl1 = new Button("1");
        lbl2 = new Button("2");
        lbl3 = new Button("3");

        lbl1.setMaxSize(30, 30);
        lbl1.setMinSize(30, 30);
        lbl2.setMaxSize(30, 30);
        lbl2.setMinSize(30, 30);
        lbl3.setMaxSize(30, 30);
        lbl3.setMinSize(30, 30);

        lbl1.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        lbl2.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        lbl3.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");

        lbl1.setAlignment(Pos.CENTER);
        lbl2.setAlignment(Pos.CENTER);
        lbl3.setAlignment(Pos.CENTER);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(lbl1, lbl2, lbl3);
        this.setSpacing(8);

        update();

        lbl1.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                lbl1Selected();
            }
        });
        lbl2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                lbl2Selected();
            }
        });
        lbl3.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                lbl3Selected();
            }
        });
    }

    public void lbl1Selected() {
        evaCtrl.setSelectedEva(1);
        update();
    }

    public void lbl2Selected() {
        evaCtrl.setSelectedEva(2);
        update();
    }

    public void lbl3Selected() {
        evaCtrl.setSelectedEva(3);
        update();
    }

    public void update() {
        lbl1.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        lbl2.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        lbl3.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");

        if (evaCtrl.getSelectedEva() == 1) {
            lbl1.setStyle("-fx-background-color: GREEN; -fx-text-fill:white");
        }
        if (evaCtrl.getSelectedEva() == 2) {
            lbl2.setStyle("-fx-background-color: GREEN; -fx-text-fill:white");
        }
        if (evaCtrl.getSelectedEva() == 3) {
            lbl3.setStyle("-fx-background-color: GREEN; -fx-text-fill:white");
        }
    }
}
