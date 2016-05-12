package be.matkensim.project.gui;

import be.matkensim.project.async.GetEvaTask;
import be.matkensim.project.controller.LeerlingController;
import be.matkensim.project.controller.SchermController;
import be.matkensim.project.domein.Leerling;
import java.util.List;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import be.matkensim.project.persistentie.LeerlingMapper;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginScherm extends StackPane implements View {

    private final SchermController schermController;

    private final ImageView img, logo;
    private final TextField txtNaam;
    private final Button btnZoek, btnDoorgaan, btnNieuw;
    private final ListView<Leerling> lvNamen;
    private final ObservableList<Leerling> namen;
    private final Label lblInfo;
    private final LeerlingController llnCntrl;
    private int hoogte, breedte;

    public LoginScherm(LeerlingController llnController, SchermController schermCtrl) {
        setPadding(new Insets(10));

        llnCntrl = llnController;

        schermController = schermCtrl;
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        lblInfo = new Label("");
        lblInfo.setTextFill(Color.RED);
        lblInfo.setVisible(false);
        img = new ImageView("resource/man-icon.png");
        logo = new ImageView("resource/logo.png");
        btnDoorgaan = new Button("Login");
        btnZoek = new Button("Zoek");
        btnNieuw = new Button("Nieuw");
        
        btnDoorgaan.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        btnZoek.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");
        btnNieuw.setStyle("-fx-background-color: #5F6A95; -fx-text-fill:white");

        btnDoorgaan.setMinWidth(90);
        btnZoek.setMinWidth(90);
        btnNieuw.setMinWidth(90);
        logo.setFitHeight(150);
        logo.setFitWidth(150);
        logo.setTranslateY(80);
        
        

        txtNaam = new TextField();
        txtNaam.setStyle("-fx-background-color:#789EBF; -fx-text-fill:white");
        namen = FXCollections.observableArrayList();
        lvNamen = new ListView<>(namen);
        lvNamen.getStylesheets().add("resource/listViewInlogScherm.css");
        lvNamen.setCellFactory(new Callback<ListView<Leerling>, ListCell<Leerling>>() {
            @Override
            public ListCell<Leerling> call(ListView<Leerling> e) {
                return new LeerlingCell();
            }
        });

        lblInfo.setTextFill(Color.RED);

        HBox hbox = new HBox(10, btnZoek, btnDoorgaan, btnNieuw);

        VBox vbox = new VBox(10, txtNaam, lblInfo, hbox, logo);
        vbox.setPadding(new Insets(10));

        HBox holder = new HBox(10, img, vbox, lvNamen);
        holder.setPadding(new Insets(10));
        holder.setMaxSize(665, 440);

        holder.setStyle("-fx-border-color: #282E54; -fx-border-radius: 10 10 10 10;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: #282B3A;"
                + "-fx-background-radius: 5;");

        img.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-radius: 20;");

        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-image: url('resource/achtergrondStandaard.png')");
        this.setMinSize(breedte, hoogte);
        this.setMinSize(breedte, hoogte);
        this.getChildren().addAll(holder);

        // Event handlers
        btnDoorgaan.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                login();
            }
        });
        btnZoek.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                zoek();
            }
        });
        btnNieuw.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                schermController.setScherm(MainApp.NIEUWELEERLING_ID);
            }
        });

        lvNamen.getSelectionModel().getSelectedItems().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                updateItem();
            }
        });

        // gegevens laden 
        // TODO: multithreaden 
        zoek("");
    }

    private void updateItem() {
        Leerling l = lvNamen.getSelectionModel().getSelectedItem();
        if (l != null) {
            lblInfo.setVisible(false);
            img.setImage(l.getImage());
            txtNaam.setText(l.getNaam());
            img.setFitHeight(125);
            img.setFitWidth(125);
        }
    }

    private void zoek() {
        String txt = txtNaam.getText();
        zoek(txt);
    }

    private void zoek(String txt) {
        if (txt.isEmpty()) {
            LeerlingMapper.getLeerlingen(namen);
        } else {
            LeerlingMapper.getLeerlingenMetNaam(namen, txt);
        }
    }

    private void login() {
        String txt = txtNaam.getText();
        if (txt.isEmpty()) {
            lblInfo.setText("Geen leerling geslecteerd!");
            lblInfo.setVisible(true);
        } else if (LeerlingMapper.bestaat(txt)) {
            Leerling lln = LeerlingMapper.getLeerling(txt);
            GetEvaTask task = new GetEvaTask(lln.getInschrijvingsnr(), 1);
            GetEvaTask task1 = new GetEvaTask(lln.getInschrijvingsnr(), 2);
            GetEvaTask task2 = new GetEvaTask(lln.getInschrijvingsnr(), 3);

            MainApp.service.submit(task);
            task.setOnSucceeded((e) -> {
                try {
                    lln.setEva1(task.get());
                    MainApp.service.submit(task1);
                } catch (InterruptedException | ExecutionException ex) {
                    lblInfo.setText("Fout bij het afhalen van evaluatiemomenten!");
                    Logger.getLogger(LoginScherm.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            task1.setOnSucceeded((e) -> {
                try {
                    lln.setEva2(task1.get());
                    MainApp.service.submit(task2);
                } catch (InterruptedException | ExecutionException ex) {
                    lblInfo.setText("Fout bij het afhalen van evaluatiemomenten!");
                    Logger.getLogger(LoginScherm.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            task2.setOnSucceeded((e) -> {
                try {
                    lln.setEva3(task2.get());
                    llnCntrl.setLeerling(lln);

                    schermController.setScherm(MainApp.HOOFDMENU_ID);

                    lblInfo.setVisible(false);
                    txtNaam.clear();
                    zoek();
                } catch (InterruptedException | ExecutionException ex) {
                    lblInfo.setText("Fout bij het afhalen van evaluatiemomenten!");
                    Logger.getLogger(LoginScherm.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        } else {
            lblInfo.setText("Leerling bestaat niet!");
            lblInfo.setVisible(true);
        }
    }

    @Override
    public void update() {
        zoek("");
    }
}
