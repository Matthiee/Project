package gui;

import controller.LeerlingController;
import controller.SchermController;
import domein.Leerling;
import java.util.List;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
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
import javafx.scene.paint.Color;
import persistentie.LeerlingMapper;

/**
 *
 * @author Kenzo
 */
public class LoginScherm extends StackPane implements View {

    private final SchermController schermController;

    private final ImageView img;
    private final TextField txtNaam;
    private final Button btnZoek, btnDoorgaan, btnNieuw;
    private final ListView<Leerling> lvNamen;
    private final ObservableList<Leerling> namen;
    private final Label lblInfo;
    private final LeerlingController llnCntrl;
    private int hoogte, breedte;
    
    public LoginScherm(LeerlingController llnController, SchermController schermCtrl) {
        setPadding(new Insets(10));

        llnCntrl=llnController;
        

        schermController = schermCtrl;
        hoogte = schermController.getHoogte();
        breedte = schermController.getBreedte();
        lblInfo = new Label("");
        lblInfo.setTextFill(Color.RED);
        lblInfo.setVisible(false); 
        img = new ImageView("resource/man-icon.png");
        btnDoorgaan = new Button("Doorgaan");
        btnZoek = new Button("Zoek");
        btnNieuw=new Button("Nieuw");
        
        btnDoorgaan.setMinWidth(90);
        btnZoek.setMinWidth(90);
        btnNieuw.setMinWidth(90);
        
        txtNaam = new TextField();
        namen = FXCollections.observableArrayList();
        lvNamen = new ListView<>(namen);

        lvNamen.setCellFactory(e -> new LeerlingCell());

        lblInfo.setTextFill(Color.RED);
        
        HBox hbox = new HBox(10, btnZoek, btnDoorgaan, btnNieuw);

        VBox vbox = new VBox(10, txtNaam, lblInfo, hbox);
        vbox.setPadding(new Insets(10));

        HBox holder = new HBox(10, img, vbox, lvNamen);
        holder.setPadding(new Insets(10));
        holder.setMaxSize(665, 440);

        holder.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
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
        btnDoorgaan.setOnAction(e -> login());
        btnZoek.setOnAction(e -> zoek());
        btnNieuw.setOnAction(e-> schermController.setScherm(MainApp.NIEUWELEERLING_ID));
        
        lvNamen.getSelectionModel().getSelectedItems().addListener((Observable o) -> updateItem());
        
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
        }
    }

    private void zoek() {
        String txt = txtNaam.getText();
        zoek(txt);
    }
    
    private void zoek(String txt) {
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
            String txt = txtNaam.getText();
            if (txt.isEmpty()){
                lblInfo.setText("Geen leerling geslecteerd!");
                lblInfo.setVisible(true);
            } else {
                if (LeerlingMapper.bestaat(txt)) {
                
                   Leerling lln = LeerlingMapper.getLeerling(txt);
                   llnCntrl.setLeerling(lln);
                   
                   schermController.setScherm(MainApp.HOOFDMENU_ID);
                   
                   lblInfo.setVisible(false);
                   txtNaam.clear();
                   zoek();
                    
                } else {
                    lblInfo.setText("Leerling bestaat niet!");
                    lblInfo.setVisible(true);
                }
            }
    }

    @Override
    public void update() {
        zoek("");
    }

}
