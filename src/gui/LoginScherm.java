package gui;

import controller.SchermController;
import domein.Leerling;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import persistentie.LeerlingMapper;

/**
 *
 * @author Kenzo
 */
public class LoginScherm extends StackPane {

    private final SchermController schermController;

    private final ImageView img;
    private final TextField txtNaam;
    private final Button btnZoek, btnDoorgaan;
    private final ListView<Leerling> lvNamen;
    private final ObservableList<Leerling> namen;
    private final Label lblInfo;

    public LoginScherm(SchermController schermCtrl) {
        setPadding(new Insets(10));

        this.setMaxSize(605, 440);

        schermController = schermCtrl;
        lblInfo = new Label("");
        img = new ImageView("resource/man-icon.png");
        btnDoorgaan = new Button("Doorgaan");
        btnZoek = new Button("Zoek");
        txtNaam = new TextField();
        namen = FXCollections.observableArrayList();
        lvNamen = new ListView<>(namen);

        lvNamen.setCellFactory(e -> new LeerlingCell());

        HBox hbox = new HBox(10, btnZoek, btnDoorgaan);

        VBox vbox = new VBox(10, txtNaam, lblInfo, hbox);
        vbox.setPadding(new Insets(10));

        HBox holder = new HBox(10, img, vbox, lvNamen);
        holder.setPadding(new Insets(10));

        holder.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");

        this.setAlignment(Pos.CENTER);

        getChildren().addAll(holder);

        // Event handlers
        btnDoorgaan.setOnAction(e -> login());
        btnZoek.setOnAction(e -> zoek());

        lvNamen.getSelectionModel().getSelectedItems().addListener((Observable o) -> update());

    }

    private void update() {
        Leerling l = lvNamen.getSelectionModel().getSelectedItem();
        if (l != null) {
            img.setImage(l.getImage());
            txtNaam.setText(l.getNaam());
        }
    }

    private void zoek() {
        String txt = txtNaam.getText();
        List<Leerling> resultaat;
        if (txt.isEmpty()) {
            resultaat = LeerlingMapper.getLeerlingen();
        } else {
            resultaat = LeerlingMapper.getLeerlingenMetNaam(txt);
        }

        namen.clear();
        namen.addAll(resultaat);
    }

    private void login() {

    }

}
