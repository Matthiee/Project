package be.matkensim.project.gui;

import be.matkensim.project.controller.LeerlingController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class LeerlingInfoHouder extends VBox implements View {

    private final Label lblNaam;

    private final LeerlingController llnController;

    public LeerlingInfoHouder(LeerlingController controller) {
        setPadding(new Insets(10));
        setSpacing(10);

        this.llnController = controller;
        this.llnController.getLeerling().addView(this);
        this.setAlignment(Pos.CENTER);
        setStyle("-fx-border-color: #282E54; -fx-border-radius:10 10 10 10; "
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 10, 0, 0, 0);"
                + "-fx-background-color: #282B3A;"
                + "-fx-background-radius: 5;");

        lblNaam = new Label();
        lblNaam.setAlignment(Pos.CENTER);
        lblNaam.setStyle("-fx-text-fill:white");

        this.getChildren().addAll(lblNaam);
    }

    @Override
    public void update() {
        lblNaam.setText(llnController.getLeerling().getNaam());
    }
}
