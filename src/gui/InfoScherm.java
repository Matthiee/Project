package gui;

import controller.LeerlingController;
import controller.SchermController;
import domein.Leerling;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthias
 */
public class InfoScherm extends VBox implements View {

    private final Button btnAfmelden, btnTerug;
    private final Label lblNaam, lblInschrijving, lblInstructeur, lblVerval, lblType;
    private final ImageView imgView;

    private final LeerlingController llnController;
    private final SchermController schermController;
    
    public InfoScherm(LeerlingController controller, SchermController schermCtrl) {
        setPadding(new Insets(10));
        setSpacing(10);

        this.llnController = controller;
        this.llnController.getLeerling().addView(this);
        this.schermController=schermCtrl;

        imgView = new ImageView();
        imgView.maxHeight(128);
        imgView.maxWidth(128);

        imgView.setStyle("-fx-border-color: black;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-color: lightgray;"
                + "-fx-background-radius: 5;");

        lblNaam = new Label("Naam:");
        lblInschrijving = new Label("Inschrijvingnr: ");
        lblInstructeur = new Label("Instructeur: ");
        lblVerval = new Label("Verval: ");
        lblType = new Label("Type: ");

        VBox vbox = new VBox(lblNaam, lblInschrijving, lblInstructeur, lblVerval, lblType);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.prefHeight(Double.MAX_VALUE);
        vbox.minHeight(Double.MAX_VALUE);
        VBox.setVgrow(vbox, Priority.ALWAYS);

        HBox hbox = new HBox(imgView, vbox);
        hbox.setPadding(new Insets(10));
        hbox.setSpacing(10);

        Pane placeHolder = new Pane(hbox);
        placeHolder.setPadding(new Insets(10));
        placeHolder.setStyle("-fx-background-color: lightgray;"
                + "-fx-border-color: black;");
        placeHolder.setPrefSize(1000, 500);

        btnAfmelden = new Button("Afmelden");
        btnAfmelden.setOnAction(e->schermController.setScherm(MainApp.LOGIN_ID));
        
        btnTerug = new Button("Terug");
        btnTerug.setAlignment(Pos.BASELINE_RIGHT);

        btnTerug.setOnAction(e->schermController.setScherm(MainApp.HOOFDMENU_ID));
        
        HBox knopHouder = new HBox(btnAfmelden, btnTerug);
        HBox.setHgrow(knopHouder, Priority.ALWAYS);
        knopHouder.setPadding(new Insets(10));
        knopHouder.setSpacing(10);

        getChildren().addAll(placeHolder, knopHouder);
        this.setPrefSize(1000, 500);
        
        update();
    }

    @Override
    public void update() {
        Leerling lln = llnController.getLeerling();
        lblNaam.setText("Naam: " + lln.getNaam());
        lblInschrijving.setText("Inschrijvingnr: " + lln.getInschrijvingsnr());
        lblInstructeur.setText("Instructeur: " + lln.getInstructeur());
        lblVerval.setText("Verval: " + lln.getVerval().toString());
        lblType.setText("Type: " + lln.getType());
        imgView.setImage(lln.getImage());
    }
}
