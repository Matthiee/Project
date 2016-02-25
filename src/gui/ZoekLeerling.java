/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.SchermController;
import java.util.Iterator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Kenzo
 */
public class ZoekLeerling extends Pane {

    private final SchermController schermController;

    private TextField naamFld = new TextField();
    private Button zoekBtn = new Button("Zoek");
    private ListView<String> list = new ListView<String>();
    private ObservableList<String> namen = FXCollections.observableArrayList();
    private Label toonUser = new Label();
    private Button gaDoorBtn = new Button("Ga door!");
    private Button exitBtn = new Button("Ga terug");

    public ZoekLeerling(SchermController schermController1) {
        schermController = schermController1;
        namen.addAll("richi", "richy", "andrea", "Josh", "Mike", "joy");

        list.setItems(namen);

        VBox vBox1 = new VBox();
        Label naamLbl = new Label("Naam: ");

        exitBtn.setOnAction(e -> this.schermController.setScherm(MainApp.LOGIN_ID));
        zoekBtn.setOnAction(e -> zoek());
        vBox1.getChildren().addAll(naamLbl, naamFld, zoekBtn, toonUser, exitBtn, gaDoorBtn);
        vBox1.setTranslateY(10);
        vBox1.setTranslateX(10);
        gaDoorBtn.setVisible(false);
        gaDoorBtn.setOnAction(e -> schermController.setScherm(MainApp.HOOFDMENU_ID));
        list.setOnMouseClicked(e -> doorgaanAlsGebruikerGeselecteerd());

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(list);
        vBox2.setTranslateX(250);
        vBox2.setTranslateY(10);

        this.setMinWidth(500);
        this.getChildren().addAll(vBox1, vBox2);
    }

    private ObservableList<String> zoek() {
        ObservableList<String> uit = FXCollections.observableArrayList();
        for (String naam : namen) {
            if (naam.contains("" + naamFld.getText())) {
                uit.add(naam);
            }
        }
        list.setItems(uit);
        return uit;
    }

    private void doorgaanAlsGebruikerGeselecteerd() {
        toonUser.setText("Doorgaan als: " + list.getSelectionModel().getSelectedItem());
        gaDoorBtn.setVisible(true);
    }
}
